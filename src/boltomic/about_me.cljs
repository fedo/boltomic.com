(ns boltomic.about-me
  (:require [boltomic.state :refer [window*]]))


(defn about-me-component
  []
  [:section#slide-1.section--center.mdl-color--grey-900.mdl-color-text--white.slide
   {:style nil                                              ;{:min-height (get-in @window* [:inner-height :value])}
    }
   [:div.slide__bg]
   [:div.slide__content
    [:div.mdl-grid.mdl-grid--max-width
    [:div.mdl-cell.mdl-cell--4-col.mdl-typography--text-center.slide__image
     [:img {:src (str "images/federicoroffi.jpg") :style
                 {:max-width "100%" :max-height "200px" :borderRadius "200px"}}]]
    [:div.mdl-cell.mdl-cell--8-col.mdl-color-text--white.slide__text
     [:div.bltmc-section-title "Hi, I'm Federico Roffi"]
     [:div "Full-Stack Engineer"]]]]])