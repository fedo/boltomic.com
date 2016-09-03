(ns boltomic.footer
  (:require [boltomic.contact-me :refer [contact-me-component]]
            [boltomic.my-availability :refer [my-availability-component]]
            [reagent.core :as reagent :refer [atom create-class]]))


(defn contact-form
  []
  (create-class
    {:component-did-mount
     (fn []
       (println "[contact-form] upgradeElements")
       (.upgradeElements js/componentHandler
                         (clj->js
                           (mapv #(.getElementById js/document %) ["contact-form--name" "contact-form--email-address" "contact-form--message"]))))
     ;:component-will-unmount
     ;(fn []
     ;  (println "[contact-form] downgradeElements")
     ;  (.downgradeElements js/componentHandler
     ;    (clj->js [(.getElementById js/document "email-name")])))
     :reagent-render
     (fn []
       [:div.bltmc-contact-form
        [:h5.mdl-color-text--white "Send Me a Message"]
        [:div.mdl-textfield.mdl-js-textfield.mdl-textfield--floating-label
         [:input.mdl-textfield__input {:type "text" :id "contact-form--name"}]
         [:label.mdl-textfield__label "Your name..."]]
        [:br]
        [:div.mdl-textfield.mdl-js-textfield.mdl-textfield--floating-label
         [:input.mdl-textfield__input {:type "text" :id "contact-form--email-address"}]
         [:label.mdl-textfield__label "Your email..."]]
        [:br]
        [:div.mdl-textfield.mdl-js-textfield.mdl-textfield--floating-label
         [:textarea.mdl-textfield__input {:type "text" :id "contact-form--message" :rows 3}]
         [:label.mdl-textfield__label "Message..."]]
        [:br]
        [:button.mdl-button.mdl-js-button.mdl-button--raised.mdl-js-ripple-effect.mdl-button--colored
         "Send message"]])}))


(defn footer-component
  []
  [:div.mdl-color--grey-900
   [:div.mdl-grid.mdl-grid--max-width
    [:div.mdl-cell.mdl-cell--6-col
     [my-availability-component]]
    [:div.mdl-cell.mdl-cell--6-col
     [contact-me-component]
     ]]
   [:div.mdl-mini-footer
    "Boltomic Ltd"]])


(defn footer-space
  []
  [:div.bltmc-footer-space])
