(ns joshuastupplebeen-io.contact
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]
            [joshuastupplebeen-io.components :as components]))

(def text01
  "joshua [dot] stupplebeen at [gmail]")

(defn header01 []
    (re-com/h-box
     :style {:background-color "rgb(239, 237, 237)"
             :padding-left "20px"
             :margin-top "0px"
             :justify-content "space-between"
             :font-family "PT Sans, Helvetica, Arial, sans-serif"
             :font-size "18px"}
     :children [[:h2 "Ping!"]]))

(defn body01 [text]
  (re-com/h-box
     :width "100%"
     :children [[components/avatar]
                [re-com/v-box
                 :style {:padding-top "20px"
                         :padding-left "30px"
                         :padding-right "30px"
                         :padding-bottom "30px"
                         :float "right"
                         :font-size "18px"
                         :font-family "PT Serif, Helvetica, Arial, sans-serif"}
                 :children [[components/paragraph text]]]]))

(defn ccard01 []
  (components/card [[header01]
                    [body01 text01]]))
