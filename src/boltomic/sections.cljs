(ns boltomic.sections)



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
   ["React Native" "react.png"]
   ["Famous" "famous-white.png"]
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
    ["CSS" "css.svg"]]
   [["GitHub" "github.png"]
    ["Heroku" "heroku.png"]
    ["Amazon Web Services" "aws.jpg"]]
   [["Java" "java.png"]
    ["Elasticsearch" "elasticsearch.png"]]])


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
    [:img {:src (str "images/logos/github-white.png") :style
                {:max-width "200px" :max-height "200px"}}]]])