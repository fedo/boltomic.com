(ns boltomic.current-interests
  (:require [boltomic.common :refer [technology-component]]))


(def current-interests
  [["Datomic" "datomic.png"]
   ["React Native" "react.png"]
   ["Elm" "elm.png"]])


(defn current-interests-component
  []
  [:section#slide-3.section--center.mdl-typography--text-center.mdl-color--grey-900.mdl-color-text--white.slide
   [:div.slide__bg]
   [:div.slide__content
    [:div.slide__text [:div.bltmc-section-title "Current Interests"]]
   (into [:div.mdl-grid.mdl-grid--max-width]
         (map (fn [t]
                [:div.mdl-cell--4-col
                 [technology-component t]]) current-interests))]])