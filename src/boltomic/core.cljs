(ns ^:figwheel-always boltomic.core
  (:require
    [reagent.core :as reagent :refer [atom]]))


(enable-console-print!)


(def app-state (atom {:text "Hello world!"}))


(defn header
  []
  [:header.mdl-layout__header.mdl-layout__header--seamed
   [:div.mdl-layout__header-row
    [:span.mdl-layout-title
     [:a [:img {:src   "images/boltomic-logo-white.png"
                :width "100px"}]]]
    [:div.mdl-layout-spacer]
    [:nav.mdl-navigation.mdl-layout--large-screen-only
     [:a.mdl-navigation__link "Link"]]]])


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


(def specialities
  [["Clojure / ClojureScript" "clojure.png"]
   ["React" "react.png"]
   ["JavaScript" "javascript.png"]])


(defn speciality-component
  [[name image]]
  [:div.mdl-cell.mdl-cell--2-col
   [:img {:src (str "images/logos/" image) :style
               {:max-width "100px" :max-height "100px"}}]
   [:div name]])


(defn specialities-component
  []
  [:section.section--center.mdl-typography--text-center
   [:div [:div.bltmc-section-title "Specialities"]]
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
  [:section.section--center.mdl-typography--text-center.mdl-color--grey-800.mdl-color-text--white
   [:div [:div.bltmc-section-title "Current Interests"]]
   (into [:div.mdl-grid]
     (concat
       [[:div.mdl-cell.mdl-cell--2-col]]
       (map speciality-component current-interests)
       [[:div.mdl-cell.mdl-cell--2-col]]))])


(def technologies
  [[["AngularJS" "angularjs.png"]
    ["HTML" "html.png"]
    ["CSS" "css.svg"]
   ]
   [
   ["GitHub" "github.png"]
    ["Heroku" "heroku.png"]
    ["Amazon Web Services" "aws.jpg"]
   ]
   [["Java" "java.png"]
    ["Elasticsearch" "elasticsearch.png"]]]
  )


(defn tech-we-use
  []
  [:section.section--center.mdl-typography--text-center
   [:div [:div.bltmc-section-title "Tech we use"]]
   (map (fn [group] (into [:div.mdl-grid]
     (concat
       [[:div.mdl-cell.mdl-cell--3-col]]
       (map speciality-component group)
       [[:div.mdl-cell.mdl-cell--3-col]]))) technologies)])


(defn contact-component
  []
  [:section])


(defn open-source-component
  []
  [:section.section--center.mdl-typography--text-center.mdl-color--grey-800.bltmc-section-open-source
   [:div
    [:img {:src (str "images/logos/github.png" ) :style
                {:max-width "200px" :max-height "200px"}}]]])


(defn content
  []
  [:main.mdl-layout__content
   [:div.page-content.mdl-color--white
    [specialities-component]
    [current-interests-component]
    [tech-we-use]
    [open-source-component]]
   [contact-component]
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

