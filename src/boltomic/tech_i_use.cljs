(ns boltomic.tech-i-use
  (:require [boltomic.common :refer [technology-component]]))


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


(defn tech-i-use-component
  []
  [:section.section--center.mdl-typography--text-center
   [:div [:div.bltmc-section-title "Tech I Use"]]
   (into [:div]
         (map (fn [group] (into [:div.mdl-grid.mdl-grid--max-width]
                                (map (fn [t]
                                       [:div.mdl-cell--4-col
                                        [technology-component t]]) group))) technologies))])