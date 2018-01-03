(ns joshuastupplebeen-io.events
  (:require [re-frame.core :as re-frame]
            [joshuastupplebeen-io.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))
