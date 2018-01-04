(ns joshuastupplebeen-io.home
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]
            [joshuastupplebeen-io.components :as components]))

(def preview-text
  "bleh")

(defn home-card-header []
  (let [base-style {:padding-top "20px"
                    :padding-right "30px"}]
    (re-com/h-box
     :style {:background-color "rgb(239, 237, 237)"
             :padding-left "20px"
             :margin-top "0px"
             :justify-content "space-between"}
     :children [[:h3 "Why hello there!"]])))

(defn post-body [text preview?]
  (let [more-style (if preview?
                     {}
                     {:visibility "hidden"})]
    (re-com/h-box
     :width "100%"
     :children [[components/avatar]
                [re-com/v-box
                 :style {:padding-top "20px"
                         :padding-left "30px"
                         :padding-right "30px"
                         :padding-bottom "30px"
                         :float "right"}
                 :children [[preview-text text]]]])))

(defn home-card []
  (components/card [[home-card-header]
                    [post-body preview-text]]))
