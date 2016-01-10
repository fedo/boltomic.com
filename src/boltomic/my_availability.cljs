(ns boltomic.my-availability)


(defn my-availability-component
  []
  [:div.mdl-color-text--white
   [:h5 "My Availabilty"]
   [:h6.small "Not available until " [:a "April 2016"]]

   [:div.mdl-progress.mdl-js-progress.mdl-progress__indeterminate {:style {:width "50%"}}]
   [:div.small "Last update: 10 January 2016"]])