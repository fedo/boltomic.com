(ns boltomic-com.about-me
  (:require [boltomic-com.state :refer [window*]]))


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