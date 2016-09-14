(ns boltomic-com.core
  (:require [boltomic-com.about-me :refer [about-me-component]]
            [boltomic-com.current-interests :refer [current-interests-component]]
            [boltomic-com.footer :refer [footer-component footer-space]]
            [boltomic-com.menu :refer [menu-component]]
            [boltomic-com.open-source :refer [open-source-component]]
            [boltomic-com.state :as state :refer [menu*]]
            [boltomic-com.specialities :refer [specialities-component]]
            [boltomic-com.tech-i-use :refer [tech-i-use-component]]
            [reagent.core :as reagent :refer [atom create-class]]))

(enable-console-print!)

(defn header
  []
  (let [menu-visible (:visible @menu*)]
    [:header.mdl-layout__header.mdl-layout__header--seamed.mdl-layout__header--no-drawer-button
     {:class-name (when menu-visible "bltmc-mdl-layout__header--menu-open")}
     [:div.mdl-layout__header-row
      [:span.mdl-layout-title
       [:a {:href "#"}
        [:img {:src   "images/boltomic-logo-white.png"
               :width "100px"}]]]
      [:div.mdl-layout-spacer]
      [:nav.mdl-navigation
       [:label.mdl-js-button.mdl-button.mdl-button--icon
        {:style    {:cursor "pointer"}
         :on-click #(state/toggle-menu!)}
        [:i.material-icons (if-not menu-visible
                             "menu" "close")]]]]]))



(defn content
  []
  [:main.mdl-layout__content
   [:div.page-content.mdl-color--white
    [about-me-component]
    [specialities-component]
    [current-interests-component]
    [tech-i-use-component]
    [open-source-component]]
   [footer-space]
   [footer-component]])


(defn layout []
  (create-class
    {:componentWillMount
     #(state/listen-resize-event)
     :component-will-unmount
     #(state/unlisten-resize-event)
     :reagent-render
     (fn []
       [:div.mdl-layout__container
        {:class-name "animated once fadeIn"}
        (when (:visible @menu*)
          [menu-component])
        [:div.mdl-layout.mdl-js-layout.mdl-layout--fixed-header.mdl-layout--no-drawer-button
         [header]
         [content]]])}))

(reagent/render-component [layout]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
