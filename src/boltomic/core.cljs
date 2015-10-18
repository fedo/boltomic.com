(ns ^:figwheel-always boltomic.core
    (:require
              [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(println "Edits to this text should show up in your developer console.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))


(defn header
  []
  [:header.mdl-layout__header.is-casting-shadow
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
      [:li "About"]]]]])


(defn parallax
  []
  [:div "parallax"
   [:img  {:src "images/barcelona.jpg"}]
   "post-parallax"])


(defn content
  []
  [:main.mdl-layout__content
   [:div.page-content "content"
    [parallax]]
   [footer]])



(defn hello-world []
  [:div.mdl-layout__container
   [:div.mdl-layout.mdl-js-layout.mdl-layout--fixed-header.has-drawer.is-upgraded
    [header]
    [content]]])

(reagent/render-component [hello-world]
                          (. js/document (getElementById "app")))


(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)

