(ns ^:figwheel-always boltomic.core
  (:require
    [reagent.core :as reagent :refer [atom]]))


(enable-console-print!)


(def app-state (atom {:text "Hello world!"}))


(defn header
  []
  [:header.mdl-layout__header
   [:div.mdl-layout__header-row
    [:span.mdl-layout-title
     [:a [:img {:src   "images/boltomic-logo-white.png"
                :width "100px"}]]]
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
  [:div
   [:section.section--center.mdl-grid
    [:div.mdl-cell.mdl-cell--12-col "parallax"]]
   [:div [:img {:src "images/polygon-10.jpg"}]]])


(def specialities
  [["Clojure / ClojureScript" "clojure.png"]
   ["React" "react.png"]
   ["JavaScript" "javascript.png"]])


(defn speciality-component
  [[name image]]
  [:div.mdl-cell.mdl-cell--2-col
   [:img {:src (str "images/logos/" image) :width "100px"}]
   [:div name]])


(defn technology-component
  []
  [:section.section--center.mdl-color--grey-800.mdl-color-text--white.mdl-typography--text-center
   [:div [:h2 "Specialities"]]
   (into [:div.mdl-grid]
     (concat
       [[:div.mdl-cell.mdl-cell--3-col]]
       (map speciality-component specialities)
       [[:div.mdl-cell.mdl-cell--3-col]]))])


(def current-interests
  [["Datomic" "datomic.png"]
   ["React Native" "react-native.png"]
   ["Famous" "famous.png"]
   ["Elm" "elm.png"]])


(defn current-interests-component
  []
  [:section.section--center.mdl-typography--text-center
   [:div [:h2 "Current Interests"]]
   (into [:div.mdl-grid]
     (concat
       [[:div.mdl-cell.mdl-cell--2-col]]
       (map speciality-component current-interests)
       [[:div.mdl-cell.mdl-cell--2-col]]))])


(defn tech-we-use
  []
  [:div
   [:section.section--center.mdl-grid
    [:div.mdl-cell.mdl-cell--12-col "parallax"]]
   [:div [:h2 "Tech we use"]
    [:div "Heroku"]
    [:div "AWS"]
    [:div "Elasticsearch"]
    [:div "GitHub"]
    ;
    [:div "AngularJS"]
    [:div "SASS"]
    [:div "Gulp"]
    [:div "Grunt"]
    [:div "Bower"]
    [:div "HTML5"]
    ;
    [:div "TeamCity"]
    [:div "Go CD"]
    [:div "PhoneGap"]
    [:div "Java"]
    [:div "Spring Framework"]
    ]])


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
   [:div.page-content.mdl-color--white "content"
    ;[features]
    [technology-component]
    [current-interests-component]
    [tech-we-use]]
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

