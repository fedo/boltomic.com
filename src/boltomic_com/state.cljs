(ns boltomic-com.state
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [reagent.core :as reagent :refer [atom cursor]]
            [re-frame.core :refer [reg-event-db
                                   path
                                   reg-sub
                                   dispatch
                                   dispatch-sync
                                   subscribe]]
            [taoensso.timbre :as timbre]
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

(reg-sub :app/window-inner-height
  (fn [db _] (get-in db [:window/inner-height])))

(reg-event-db :window/update-window-inner-height
  (fn [db [_]] (assoc-in db [:window/inner-height] (.-innerHeight js/window))))

(defn listen-resize-event
  []
  (dispatch [:window/update-window-inner-height])
  (if (nil? @(subscribe [:app/window-inner-height]))
    (let [listener-key (events/listen js/window goog.events.EventType.RESIZE
                         (fn [e]
                           (dispatch [:window/update-window-inner-height])))]
      (dispatch [:scroll/update-scroll-y-listener-key listener-key]))
    (timbre/error "listen-resize-event already listening")))

(reg-sub :app/scroll-y
  (fn [db _] (get-in db [:window/scroll :scroll-y])))

(reg-sub :app/scroll-y-listener-key
  (fn [db _] (get-in db [:window/scroll :scroll-y-listener-key])))


(reg-event-db :scroll/update
  (fn [db [_]] (assoc-in db [:window/scroll :scroll-y] (.-scrollY js/window))))

(reg-event-db :scroll/update-scroll-y-listener-key
  (fn
    [db [_ listener-key]]
    (assoc-in db [:window/scroll :scroll-y-listener-key] listener-key)))

(defn listen-scroll-event
  []
  (dispatch [:scroll/update])
  (if (nil? @(subscribe [:app/scroll-y]))
    (let [listener-key (events/listen js/window goog.events.EventType.SCROLL
                         (fn [e]
                           (.log js/console e)
                           (dispatch [:scroll/update])))]
      (dispatch [:scroll/update-scroll-y-listener-key listener-key]))
    (timbre/error "listen-scroll-event already listening")))