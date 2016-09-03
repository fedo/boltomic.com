(ns boltomic.common)


(defn technology-component
  [[name image]]
  [:div.mdl-typography--text-center
   [:div.bltmc-technology-logo
    [:div.bltmc-technology-logo__image-wrapper
     [:img {:src (str "images/logos/" image)}]]]
   [:h5.bltmc-technology-logo__name name]])