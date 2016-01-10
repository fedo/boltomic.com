(ns boltomic.specialities
  (:require [boltomic.common :refer [technology-component]]))


(def specialities
  [["Clojure / ClojureScript" "clojure.png"]
   ["React" "react.png"]
   ["JavaScript" "javascript.png"]])


(defn specialities-component
  []
  [:section#slide-2.section--center.mdl-typography--text-center.slide
   [:div.slide__bg]
   [:div.slide__content
    [:div.slide__text [:div.bltmc-section-title "Specialities"]]
   (into [:div.mdl-grid.mdl-grid--max-width]
         (map (fn [t]
                [:div.mdl-cell--4-col
                 [technology-component t]]) specialities))]])