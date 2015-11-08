(ns ^:figwheel-always boltomic.core
  (:require [boltomic.state :as state :refer [menu*]]
            [boltomic.sections :as sections]
            [reagent.core :as reagent :refer [atom]]))


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
       [:a.mdl-navigation__link "Link"]
       [:label.mdl-js-button.mdl-button.mdl-button--icon
        {:style    {:cursor "pointer"}
         :on-click #(state/toggle-menu!)}
        [:i.material-icons (if-not menu-visible
                             "menu" "close")]]]]]))


(defn footer
  []
  [:footer.mdl-mega-footer.bltmc-mdl-mega-footer.mdl-color--grey-900
   [:div.mdl-mega-footer__middle-section
    [:div.mdl-mega-footer__drop-down-section
     [:h1.mdl-mega-footer__heading "Boltomic Ltd"]
     [:ul.mdl-mega-footer__link-list
      [:li "About"]]]]
   [:div.mdl-mega-footer--middle-section
    [:div.mdl-logo "More Information"]
    [:ul.mdl-mega-footer--link-list
     [:li
      [:a {} "www.boltomic.com"]]]]])

(defn footer-space
  []
  [:div.bltmc-footer-space])

(defn content
  []
  [:main.mdl-layout__content
   [:div.page-content.mdl-color--white
    [sections/specialities-component]
    [sections/current-interests-component]
    [sections/tech-we-use]
    [sections/open-source-component]]
   [footer-space]
   [sections/contact-component]
   [footer]])


(def menu-items
  [["Home" "#"]
   ["Specialities" "#/specialities"]
   ["Current Interests" "#/current-interests"]
   ["Tech we use" "#/technologies"]
   ["About me" "#/about-me"]])


(defn menu-component
  []
  [:div.bltmc-menu.mdl-color-text--white {:class-name (when (:visible @menu*) "bltmc-menu--open")
                    :on-click   #(state/set-menu-visible! false)}
   [:div.bltmc-menu__holder
    (into [:div.bltmc-menu__items]
     (map (fn [[name url]]
            [:h3.bltmc-menu__item [:a {:href url} name] ]) menu-items))]])


(defn layout []
  [:div.mdl-layout__container
   [menu-component]
   [:div.mdl-layout.mdl-js-layout.mdl-layout--fixed-header.mdl-layout--no-drawer-button
    [header]
    [content]]])


(reagent/render-component [layout]
  (. js/document (getElementById "app")))


(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )
