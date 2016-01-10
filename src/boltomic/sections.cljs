(ns boltomic.sections
  (:require [boltomic.state :refer [window*]]))


(def specialities
  [["Clojure / ClojureScript" "clojure.png"]
   ["React" "react.png"]
   ["JavaScript" "javascript.png"]])


(defn technology-component
  [[name image]]
  [:div.mdl-typography--text-center
   [:div.bltmc-technology-logo
    [:div.bltmc-technology-logo__image-wrapper
     [:img {:src (str "images/logos/" image)}]]]
   [:h5.bltmc-technology-logo__name name]])


(defn specialities-component
  []
  [:section.section--center.mdl-typography--text-center
   [:div [:div.bltmc-section-title "Specialities"]]
   (into [:div.mdl-grid.mdl-grid--max-width]
     (map (fn [t]
            [:div.mdl-cell--4-col
             [technology-component t]]) specialities))])


(def current-interests
  [["Datomic" "datomic.png"]
   ["React Native" "react.png"]
   ["Elm" "elm.png"]])


(defn current-interests-component
  []
  [:section.section--center.mdl-typography--text-center.mdl-color--grey-900.mdl-color-text--white
   [:div [:div.bltmc-section-title "Current Interests"]]
   (into [:div.mdl-grid.mdl-grid--max-width]
     (map (fn [t]
            [:div.mdl-cell--4-col
             [technology-component t]]) current-interests))])


(def technologies
  [[["AngularJS" "angularjs.png"]
    ["HTML" "html.png"]
    ["CSS" "css.png"]]
   [["Java" "java.png"]
    ["Elasticsearch" "elasticsearch.png"]
    ["Docker" "docker.png"]]
   [["GitHub" "github.png"]
    ["Heroku" "heroku.png"]
    ["Amazon Web Services" "aws.jpg"]]])


(defn tech-i-use
  []
  [:section.section--center.mdl-typography--text-center
   [:div [:div.bltmc-section-title "Tech I Use"]]
   (into [:div]
     (map (fn [group] (into [:div.mdl-grid.mdl-grid--max-width]
                        (map (fn [t]
                               [:div.mdl-cell--4-col
                                [technology-component t]]) group))) technologies))])


(defn contact-component
  []
  [:section])


(defn open-source-component
  []
  [:section.section--center.mdl-color--grey-800.bltmc-section-open-source
   [:div.mdl-grid.mdl-grid--max-width
    [:div.mdl-cell.mdl-cell--4-col.mdl-typography--text-center
     [:img {:src (str "images/logos/github-white.png") :style
                 {:max-width "100%" :max-height "200px"}}]]
    [:div.mdl-cell.mdl-cell--8-col.mdl-color-text--white
     [:div.bltmc-section-title "Talk is cheap." [:br] "Show me the code."]
     [:div
      [:p "This website is built using " [:a "Reagent"] ", a " [:a "ClojureScript"] " interface to "[:a "Facebook's React"]". "]
      [:p "For the look and feel I use " [:a "Material Design Lite"] " and custom styles written in SCSS. "]
      [:p "In order to automate tasks the project is configured with " [:a "Leiningen"] ",
      with a little help from " [:a "Gulp"] " which provides a large variety of plugins."]
      [:p [:a "CirleCI"] " handles continuous integration and automatic deployment to " [:a "Amazon S3"]". "]
      [:p "You can find the source code of this project in " [:a "GitHub"] ". If find a bug or you have
      an idea on how to improve it please create an "[:a "issue"] " or send me an " [:a "email"] ". I'm really
      keen on discussing about different methodologies and technologies."]]]]])


(defn about-me-component
  []
  [:section.section--center.mdl-color--grey-900.mdl-color-text--white
   {:style {:min-height (get-in @window* [:inner-height :value])}}
   [:div.mdl-grid.mdl-grid--max-width
    [:div.mdl-cell.mdl-cell--4-col.mdl-typography--text-center
     [:img {:src (str "images/federicoroffi.jpg") :style
                 {:max-width "100%" :max-height "200px" :borderRadius "200px"}}]]
    [:div.mdl-cell.mdl-cell--8-col.mdl-color-text--white
     [:div.bltmc-section-title "Hi, I'm Federico Roffi"]
     [:div "Full-Stack Engineer"]]]])
