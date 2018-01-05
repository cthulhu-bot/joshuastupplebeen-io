(ns joshuastupplebeen-io.home
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]
            [joshuastupplebeen-io.components :as components]))

(def text
  "My name is Josh! I'm a husband, father and programmer.
   I enjoy coding, cooking, video and board games, baking
   and spending time with my family.
   I also enjoy dabbling in cryptocurrencies, designing realtime systems, programming languages,
   breaking things and putting them back together again.
   These days you can typically find me coding in a combination of clojure,
   clojurescript and javascript. Especially this webpage, which was coded using clojurescript, reframe and recom.")

(defn home-card-header []
  (let [greeting (case (rand-int 4)
                   0 "Howzit"
                   1 "Why hello there!"
                   2 "Hey there!"
                   3 "Greetings!")]
    (re-com/h-box
     :style {:background-color "rgb(239, 237, 237)"
             :padding-left "20px"
             :margin-top "0px"
             :justify-content "space-between"
             :font-family "PT Sans, Helvetica, Arial, sans-serif"
             :font-size "18px"}
     :children [[:h2 greeting]])))

(defn post-body [text]
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

(defn home-card []
  (components/card [[home-card-header]
                    [post-body text]]))
