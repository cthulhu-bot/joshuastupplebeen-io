(ns joshuastupplebeen-io.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 ::page
 (fn [db]
   (:page db)))

(re-frame/reg-sub
 ::post01
 (fn [db]
   (:post01-preview db)))
