(ns boltomic.menu
  (:require [boltomic.state :as state :refer [menu*]]))



(def menu-items
  [["Home" "#"]
   ["About Me" "#/about-me"]
   ["Specialities" "#/specialities"]
   ["Current Interests" "#/current-interests"]
   ["Tech I Use" "#/technologies"]
   ["Fork me on GitHub" "#/github"]
   ["My Availability" "#/my-availability"]
   ["Contact Me" "#/contact-me"]])


(defn menu-component
  []
  [:div.bltmc-menu.mdl-color-text--white {:class-name (when (:visible @menu*) "bltmc-menu--open")
                                          :on-click   #(state/set-menu-visible! false)}
   [:div.bltmc-menu__holder
    (into [:div.bltmc-menu__items]
      (map (fn [[name url]]
             [:div.bltmc-menu__item [:a {:href url} name] ]) menu-items))]])