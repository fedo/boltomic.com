(ns boltomic.state
  (:require [reagent.core :as reagent :refer [atom cursor]]))


(def app-state (atom {:menu {:visible false}}))


(def menu* (cursor app-state [:menu]))


(defn set-menu-visible!
  [visible]
  (println "[set-menu-visible!] visible=" visible)
  (swap! menu* assoc :visible visible))


(defn toggle-menu!
  []
  (swap! menu* assoc :visible (not (:visible @menu*))))