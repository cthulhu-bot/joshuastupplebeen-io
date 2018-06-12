(ns joshuastupplebeen-io.weblog
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]
            [joshuastupplebeen-io.components :as components]
            [joshuastupplebeen-io.posts :as posts]
            [clojure.string :as str]))

(defn post-header [preview?]
  (let [base-style {:padding-top "20px"
                    :padding-right "30px"}
        amended-style (if preview?
                        (assoc base-style :visibility "hidden")
                        base-style)]
    (re-com/h-box
     :style {:background-color "rgb(239, 237, 237)"
             :padding-left "20px"
             :margin-top "0px"
             :justify-content "space-between"
             :font-family "PT Sans, Helvetica, Arial, sans-serif"}
     :children [[:h3 "1/3/2018"]
                [re-com/hyperlink
                 :style amended-style
                 :label "Less ..."
                 :on-click #(re-frame/dispatch [:shrink-preview])]])))

(defn post-body [text preview? expandfn]
  (let [more-style (if preview?
                     {}
                     {:visibility "hidden"})
        card-text (if preview?
                    (str/join " " (take 40 (str/split text #" ")))
                    text)]
    (re-com/h-box
     :width "100%"
     :children [[components/avatar]
                [re-com/v-box
                 :style {:padding-top "20px"
                         :padding-left "30px"
                         :padding-right "30px"
                         :padding-bottom "30px"
                         :float "right"
                         :font-family "PT Serif, Helvetica, Arial, sans-serif"
                         :font-size "18px"}
                 :children [[components/paragraph card-text]
                            [re-com/hyperlink
                             :style more-style
                             :label "More ..."
                             :on-click #(re-frame/dispatch [:expand-card card-name])]]]])))

(defn post-card
  ([card-content] (post-card card-content true))
  ([card-content preview?]
   (components/card card-content)))

(defn post-card-01 []
  (let [preview? (re-frame/subscribe [::post01])
        expandfn #(re-frame/dispatch [:expand-preview])]
    (post-card [[post-header true]
                [post-body posts/post01 true expandfn]])))

(defn post-card-02 []
  (let [preview? (re-frame/subscribe [::post02])
        expandfn #(re-frame/dispatch [:expand-preview])]
    (post-card [[post-header true]
                [post-body posts/post02 true expandfn]])))

(defn post-cards
  [post-card-01
   post-card-02])
