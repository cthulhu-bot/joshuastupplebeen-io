(ns joshuastupplebeen-io.portfolio
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]
            [joshuastupplebeen-io.components :as components]))

(def website-description
  "this website coded from scratch in clojurescript, re-frame and re-com")

(def devcards-description
  "devcards for this website")

(def random-object-description
  "Random object generator for generative testing in javascript")

(def jscheme-description
  "lisp that compiles to javascript")

(def hipchat-bot-description
  "hipchat bot for one of my old teams")

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
    :children [[components/icon-link url]
               [re-com/v-box
                :style {:padding-top "20px"
                        :padding-left "30px"
                        :padding-right "30px"
                        :padding-bottom "30px"
                        :float "right"
                        :font-size "18px"
                        :font-family "PT Serif, Helvetica, Arial, sans-serif"}
                :children [[components/paragraph description]]]]))

(defn website []
  (project "https://github.com/cthulhu-bot/joshuastupplebeen-io" website-description))

(defn website-devcards []
  (project "https://github.com/cthulhu-bot/joshuastupplebeen.io.devcards" devcards-description))

(defn random-object []
  (project "https://github.com/cthulhu-bot/random-object" random-object-description))

(defn jscheme []
  (project "https://github.com/cthulhu-bot/jscheme" jscheme-description))

(defn hipchat-bot []
  (project "https://github.com/cthulhu-bot/CCX-HipChat-Bot" hipchat-bot-description))

(defn projects []
  (re-com/v-box
   :children [[website]
              [website-devcards]
              [random-object]
              [jscheme]
              [hipchat-bot]]))

(defn projects-card []
  (components/card [[header01]
                    [projects]]))
