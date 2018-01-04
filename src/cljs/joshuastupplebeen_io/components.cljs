(ns joshuastupplebeen-io.components
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]))

(defn card [card-content]
  [re-com/border
   :border "1px solid rgb(239, 237, 237)"
   :child [re-com/v-box
           :style {:padding-bottom "20px"}
           :children card-content]])

(defn avatar
  ([]
   (avatar "https://lh3.googleusercontent.com/-aGjZkC1lEDo/AAAAAAAAAAI/AAAAAAAABUk/w1lSzJbX1_Q/s640/photo.jpg"))
  ([img-url]
   [:img {:src img-url
          :style {:border-radius "50%"
                  :padding "10px"
                  :position "relative"}
          :width "100px"
          :height "100px"}]))

(defn icon-link []
  [re-com/md-circle-icon-button
   :md-icon-name "zmdi-github-alt"])

(defn paragraph [text]
  (re-com/p text))
