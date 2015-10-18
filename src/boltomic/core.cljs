(ns ^:figwheel-always boltomic.core
    (:require
              [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(println "Edits to this text should show up in your developer console.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))


(defn header
  []
  [:header.mdl-layout__header
   [:div.mdl-layout__header-row
    [:span.mdl-layout-title "Boltomic"]
    [:div.mdl-layout-spacer]
    [:nav.mdl-navigation.mdl-layout--large-screen-only
     [:a.mdl-navigation__link "Link"]]]])


(defn footer
  []
  [:footer.mdl-mega-footer
   [:div.mdl-mega-footer__middle-section
    [:div.mdl-mega-footer__drop-down-section
     [:h1.mdl-mega-footer__heading "Boltomic Ltd"]
     [:ul.mdl-mega-footer__link-list
      [:li "About"]]]]
   [:div.mdl-mega-footer--bottom-section
    [:div.mdl-logo "More Information"]
    [:ul.mdl-mega-footer--link-list
     [:li
      [:a {} "www.boltomic.com"]]]]])


(defn parallax
  []
  [:div "parallax"
   [:img  {:src "images/polygon-10.jpg"}]
   "post-parallax"])


(defn features
  []
  [:section.section--footer.mdl-color--white.mdl-grid
   [:div.section__circle-container.mdl-cell.mdl-cell--2-col.mdl-cell--1-col-phone
    [:div.section__circle-container__circle.mdl-color--accent
     {:style {:width "100px" :height "100px" :borderRadius "50px"}}]]
   [:div.section__text.mdl-cell.mdl-cell--4-col-desktop.mdl-cell--6-col-tablet.mdl-cell--3-col-phone
    [:h5 "Title"]
    "Qui sint ut et qui nisi cupidatat. Reprehenderit nostrud proident officia exercitation anim et pariatur ex."]])


(defn content
  []
  [:main.mdl-layout__content
   [:div.page-content "content"
    [parallax]
    [features]]
   [footer]])


(defn layout []
  [:div.mdl-layout__container
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

