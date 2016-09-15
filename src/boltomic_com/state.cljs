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
            [goog.events :as events]
            [goog.dom :as gdom])
  (:import goog.dom goog.events goog.events.EventType))


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

(reg-event-db :window/update-window-inner-height
  (fn [db [_]] (assoc-in db [:window/inner-height] (.-innerHeight js/window))))


(reg-event-db :scroll/update-scroll-top
  (fn [db [_]]
    (let [scroll-top (when-let [e (gdom/getElementByClass "mdl-layout__content")] (.-scrollTop e))]
      (assoc-in db [:content/scroll :scroll-top] scroll-top))))


(reg-event-db :scroll/update-scroll-top-listener-key
  (fn
    [db [_ listener-key]]
    (assoc-in db [:content/scroll :scroll-listener-key] listener-key)))


(reg-event-db :window/update-window-inner-height-listener-key
  (fn [db [_]] (assoc-in db [:window/inner-height-listener-key] (.-innerHeight js/window))))


(reg-sub :app/window-inner-height
  (fn [db _] (get-in db [:window/inner-height])))


(reg-sub :app/window-inner-height-listener-key (fn [db _] (get-in db [:window/inner-height-listener-key])))


(reg-sub :app/scroll-top (fn [db _] (get-in db [:content/scroll :scroll-top])))


(reg-sub :app/scroll-listener-key (fn [db _] (get-in db [:content/scroll :scroll-listener-key])))


(defn listen-resize-event
  []
  (dispatch [:window/update-window-inner-height])
  (if (nil? @(subscribe [:app/window-inner-height-listener-key]))
    (let [listener-key (events/listen js/window goog.events.EventType.RESIZE
                         (fn [e]
                           (dispatch [:window/update-window-inner-height])))]
      (timbre/info "listen-resize-event")
      (dispatch [:window/update-window-inner-height-listener-key listener-key]))
    (timbre/error "listen-resize-event already listening")))


(defn listen-scroll-event
  []
  (dispatch [:scroll/update-scroll-top])
  (if (nil? @(subscribe [:app/scroll-top]))
    (let [listener-key (events/listen js/window "scroll"
                         (fn [e]
                           (dispatch [:scroll/update-scroll-top]))
                         true)]
      (timbre/info "listen-scroll-event")
      (dispatch [:scroll/update-scroll-top-listener-key listener-key]))
    (timbre/error "listen-scroll-event already listening")))