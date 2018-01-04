(ns joshuastupplebeen-io.home
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]
            [joshuastupplebeen-io.components :as components]))

(def text
  "My name is Josh! I'm a husband, father and programmer.
   I enjoy coding, cooking, video and board games, baking
   and spending time with my family.
   I also enjoy dabbling in cryptocurrencies, designing realtime systems,
   breaking things and putting them back together again.
   These days you can typically find me coding in a combination of clojure,
   clojurescript and javascript.")

(defn home-card-header []
  (let [base-style {:padding-top "20px"
                    :padding-right "30px"}
        greeting (case (rand-int 4)
                   0 "Howzit"
                   1 "Why hello there!"
                   2 "Alo!"
                   3 "Greetings!")]
    (re-com/h-box
     :style {:background-color "rgb(239, 237, 237)"
             :padding-left "20px"
             :margin-top "0px"
             :justify-content "space-between"}
     :children [[:h3 greeting]])))

(defn post-body [text]
  (re-com/h-box
     :width "100%"
     :children [[components/avatar]
                [re-com/v-box
                 :style {:padding-top "20px"
                         :padding-left "30px"
                         :padding-right "30px"
                         :padding-bottom "30px"
                         :float "right"}
                 :children [[components/paragraph text]]]]))

(defn home-card []
  (components/card [[home-card-header]
                    [post-body text]]))
