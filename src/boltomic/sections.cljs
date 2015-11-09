(ns boltomic.sections)



(def specialities
  [["Clojure / ClojureScript" "clojure.png"]
   ["React" "react.png"]
   ["JavaScript" "javascript.png"]])


(defn tech-component
  [[name image]]
  [:div.mdl-cell.mdl-cell--3-col
   [:div {:style {:max-width "100%" :max-height "100%"}}
    [:img {:src (str "images/logos/" image) :style
               {:max-width "50%" :max-height "100%" :display "inline-block"}}]]
   [:div name]])


(defn specialities-component
  []
  [:section.section--center.mdl-typography--text-center
   [:div [:div.bltmc-section-title "Specialities"]]
   (into [:div.mdl-grid.mdl-grid--max-width]
     (concat
       [[:div.mdl-cell.mdl-cell--1-col]]
       (map tech-component specialities)
       [[:div.mdl-cell.mdl-cell--1-col]]))])


(def current-interests
  [["Datomic" "datomic.png"]
   ["React Native" "react.png"]
   ["Elm" "elm.png"]])


(defn current-interests-component
  []
  [:section.section--center.mdl-typography--text-center.mdl-color--grey-800.mdl-color-text--white
   [:div [:div.bltmc-section-title "Current Interests"]]
   (into [:div.mdl-grid.mdl-grid--max-width]
     (concat
       [[:div.mdl-cell.mdl-cell--1-col]]
       (map tech-component current-interests)
       [[:div.mdl-cell.mdl-cell--1-col]]
       ))])


(def technologies
  [[["AngularJS" "angularjs.png"]
    ["HTML" "html.png"]
    ["CSS" "css.svg"]]
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
   (map (fn [group] (into [:div.mdl-grid.mdl-grid--max-width]
                      (concat
                        [[:div.mdl-cell.mdl-cell--1-col]]
                        (map tech-component group)
                        [[:div.mdl-cell.mdl-cell--2-col]]
                        ))) technologies)])


(defn contact-component
  []
  [:section])


(defn open-source-component
  []
  [:section.section--center.mdl-typography--text-center.mdl-color--grey-800.bltmc-section-open-source
   [:div
    [:img {:src (str "images/logos/github-white.png") :style
                {:max-width "200px" :max-height "200px"}}]]])
