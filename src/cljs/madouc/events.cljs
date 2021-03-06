(ns madouc.events
  (:require
   [madouc.api :as api]
   [madouc.mock :as mm]
   [re-frame.core :as rf]))

(rf/reg-event-db
 :initialize
 (fn [db _]
   (.info js/console "Initialize handler")
   (assoc db :events [])
   (assoc db :fetching nil)))

(rf/reg-event-db
 :simulate-event-load
 (fn [db _]
   (assoc db :events (mm/get-rand-list 20))))

(rf/reg-event-db
 :start-fetching
 (fn [db _]
   (assoc db :fetching (api/start-event-fetching))))

(rf/reg-event-db
 :stop-fetching
 (fn [db _]
   (assoc db :fetching (api/stop-event-fetching))))
