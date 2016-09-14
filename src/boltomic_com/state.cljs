(ns boltomic-com.state
  (:require [reagent.core :as reagent :refer [atom cursor]]
            [goog.events :as events])
  (:import goog.events))


(def app-state (atom {:menu   {:visible false}
                      :window {:inner-height {:value        nil
                                              :listener-key nil}}}))


(def menu* (cursor app-state [:menu]))
(def window* (cursor app-state [:window]))


(defn set-menu-visible!
  [visible]
  (println "[set-menu-visible!] visible=" visible)
  (swap! menu* assoc :visible visible))


(defn toggle-menu!
  []
  (swap! menu* assoc :visible (not (:visible @menu*))))


(defn update-window-inner-width
  []
  (reset! window*
    (assoc-in @window* [:inner-height :value] (-> js/window .-innerHeight))))


(defn unlisten-resize-event
  []
  (println "[unlisten-resize-event]")
  (if-let [listener-key (get-in @window* [:inner-height :listener-key])]
    (events/unlistenByKey listener-key)
    (println "[unlisten-resize-event] RESIZE event listener doesn't exist")))


(defn listen-resize-event
  []
  (println "[listen-resize-event]")
  (update-window-inner-width)
  (if (nil? (get-in @window* [:inner-height :listener-key]))
    (let [listener-key (events/listen js/window goog.events.EventType.RESIZE
                         (fn [e]
                           (update-window-inner-width)))]
      (reset! window*
        (assoc-in @window* [:inner-height :listener-key] listener-key)))
    (println "[listen-resize-event] RESIZE event listener already exists = " (get-in @window* [:inner-height :value]))))
