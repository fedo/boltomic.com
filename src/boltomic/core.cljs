(ns ^:figwheel-always boltomic.core
  (:require [boltomic.footer :refer [footer-component footer-space]]
            [boltomic.menu :refer [menu-component]]
            [boltomic.state :as state :refer [menu*]]
            [boltomic.sections :as sections]
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
    [sections/about-me-component]
    [sections/specialities-component]
    [sections/current-interests-component]
    [sections/tech-i-use]
    [sections/open-source-component]]
   [footer-space]
   [sections/contact-component]
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
