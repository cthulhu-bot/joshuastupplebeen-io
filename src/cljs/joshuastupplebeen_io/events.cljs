(ns joshuastupplebeen-io.events
  (:require [re-frame.core :as re-frame]
            [joshuastupplebeen-io.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::nav-weblog
 (fn [db _]
   (assoc db :page "weblog")))

(re-frame/reg-event-db
 ::nav-portfolio
 (fn [db _]
   (assoc db :page "portfolio")))

(re-frame/reg-event-db
 ::nav-contact
 (fn [db _]
   (assoc db :page "contact")))
