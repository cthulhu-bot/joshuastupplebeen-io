(ns joshuastupplebeen-io.portfolio
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]
            [joshuastupplebeen-io.components :as components]))

(def text01
  "Random object generator for generative testing in javascript")

(defn header01 []
    (re-com/h-box
     :style {:background-color "rgb(239, 237, 237)"
             :padding-left "20px"
             :margin-top "0px"
             :justify-content "space-between"
             :font-family "PT Sans, Helvetica, Arial, sans-serif"
             :font-size "18px"}
     :children [[:h2 "Projects"]]))

(defn project [url description]
  (re-com/h-box
    :children [[components/icon-link]
               [re-com/v-box
                :style {:padding-top "20px"
                        :padding-left "30px"
                        :padding-right "30px"
                        :padding-bottom "30px"
                        :float "right"
                        :font-size "18px"
                        :font-family "PT Serif, Helvetica, Arial, sans-serif"}
                :children [[components/paragraph description]]]]))

(defn project01 []
  (project nil text01))

(defn project02 []
  (project nil text01))

(defn projects []
  (re-com/v-box
   :children [[project01]
              [project02]]))

(defn pcard-01 []
  (components/card [[header01]
                    [projects]]))
