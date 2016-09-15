(ns boltomic-com.about-me
  (:require [boltomic-com.state :refer [window*]]
            [goog.string :as gstring]
            [goog.string.format]
            [re-frame.core :refer [subscribe]]))

(defn- i-am-component
  []
  [:div.mdl-grid.mdl-grid--max-width
   [:div.mdl-cell.mdl-cell--4-col.mdl-typography--text-center
    [:img {:src (str "images/federicoroffi.jpg") :style
                {:max-width "100%" :max-height "200px" :borderRadius "200px"}}]]
   [:div.mdl-cell.mdl-cell--8-col.mdl-color-text--white
    [:div.bltmc-section-title "Hi, I'm Federico Roffi"]
    [:div "Full-Stack Engineer"]]])


(defn about-me-component
  []
  (let [inner-height* (subscribe [:app/window-inner-height])]
    (fn []
    [:section.section--center.mdl-color--grey-900.mdl-color-text--white
   {:style {:height (- @inner-height* 10)
            :background-position :center
            :background-size :cover
            :background-image (gstring/format "url('%s')" "images/slide-1.jpg")}}
   [:div]])))