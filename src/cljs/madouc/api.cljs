(ns madouc.api
  (:require
   [re-frame.core :as rf]))

(defn simulate-events-load
  "Simulates a load of events from external source"
  []
  (rf/dispatch [:simulate-event-load]))

(def interval-id nil)

(defn fetching? [id]
  (not (nil? id)))

(defn start-event-fetching []
  (when (nil? interval-id)
    (let [id (js/setInterval simulate-events-load (* 20 1000))]
      (fetching? (set! interval-id id)))))

(defn stop-event-fetching []
  (when (not (nil? interval-id))
    (do
      (js/clearInterval interval-id)
      (fetching? (set! interval-id nil)))))
