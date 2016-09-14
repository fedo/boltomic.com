(ns boltomic-com.contact-me)


(defn contact-me-component
  []
  [:div.mdl-color-text--white
   [:h5 "Contact Me"]
   [:p "Please contact me with any opportunities and ideas you would like to discuss."]
   [:p "The easiest way to get in touch with me is by email "
    [:a {:href "mailto:roffi.federico+boltomic@gmail.com"} "roffi.federico@gmail.com"] "."]
   [:p ""]])