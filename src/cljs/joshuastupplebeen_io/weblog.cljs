(ns joshuastupplebeen-io.weblog
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]
            [joshuastupplebeen-io.components :as components]))

(def test-text
  "Finally upgraded this site to something cool, slick and infinitely more 
fun to program. Namely swapped out straight up ES6, react and redux, for clojurescript, 
reframe and recom (which include javascript and react under the hood, I know).")

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
                         :float "right"
                         :font-family "PT Serif, Helvetica, Arial, sans-serif"
                         :font-size "18px"}
                 :children [[components/paragraph text]
                            [re-com/hyperlink
                             :style more-style
                             :label "More ..."
                             :on-click #(re-frame/dispatch [:expand-preview])]]]])))

(defn post-card
  ([card-content] (post-card card-content true))
  ([card-content preview?]
   (components/card card-content)))

(defn post-card-01 []
  (post-card [[post-header true]
              [post-body test-text true]]))

(defn post-cards
  [post-card-01])
