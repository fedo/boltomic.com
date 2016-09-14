(ns boltomic-com.current-interests
  (:require [boltomic-com.common :refer [technology-component]]))


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