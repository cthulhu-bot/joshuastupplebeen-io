(ns joshuastupplebeen-io.components
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]))

(defn card [card-content]
  [re-com/v-box
   :style {:border "1px solid"
           :border-color "rgb(239, 237, 237)"
           :padding-bottom "20px"}
   :children card-content])

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

(defn paragraph [text]
  (re-com/p text))
