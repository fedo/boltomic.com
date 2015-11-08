(ns ^:figwheel-always boltomic.core
  (:require [boltomic.state :as state :refer [menu*]]
            [boltomic.sections :as sections]
            [reagent.core :as reagent :refer [atom]]))


(enable-console-print!)



(defn header
  []
  [:header.mdl-layout__header.mdl-layout__header--seamed
   {:class-name (when (:visible @menu*) "bltmc-mdl-layout__header--menu-open")}
   [:div.mdl-layout__header-row
    [:span.mdl-layout-title
     [:a [:img {:src   "images/boltomic-logo-white.png"
                :width "100px"}]]]
    [:div.mdl-layout-spacer]
    [:nav.mdl-navigation.mdl-layout--large-screen-only
     [:a.mdl-navigation__link {:on-click #(state/set-menu-visible! true)} "Link"]]]])


(defn footer
  []
  [:footer.mdl-mega-footer.mdl-color--grey-900
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


(defn content
  []
  [:main.mdl-layout__content
   [:div.page-content.mdl-color--white
    [:div "app-state=" (str @state/app-state)]
    [sections/specialities-component]
    [sections/current-interests-component]
    [sections/tech-we-use]
    [sections/open-source-component]]
   [sections/contact-component]
   [footer]])


(defn menu-component
  []
  [:div.bltmc-menu {:class-name (when (:visible @menu*) "bltmc-menu--open")
                    :on-click   #(state/set-menu-visible! false)}
   [:div.bltmc-menu__links]])


(defn layout []
  [:div.mdl-layout__container
   [menu-component]
   [:div.mdl-layout.mdl-js-layout.mdl-layout--fixed-header.has-drawer.is-upgraded
    [header]
    [content]]])


(reagent/render-component [layout]
  (. js/document (getElementById "app")))


(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )
