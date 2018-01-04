(ns joshuastupplebeen-io.weblog
  (:require [re-com.core :as re-com]
            [re-frame.core :as re-frame]
            [joshuastupplebeen-io.components :as components]))

(def test-text
"round round. Beef ribs kielbasa biltong, drumstick picanha ball tip landjaeger beef filet mignon fatback cow bresaola ham bacon meatball. Kielbasa drumstick tenderloin tail, swine buffalo porchetta. Ground round turducken boudin pancetta. Andouille meatloaf pork belly venison, corned beef chuck drumstick alcatra spare ribs.

Ribeye pork loin frankfurter sausage turducken hamburger. Pancetta strip steak venison, buffalo swine kevin tail fatback sausage ground round t-bone andouille short ribs pig. Cow corned beef beef kielbasa, pork loin turducken biltong meatball bacon cupim chicken. Bacon bresaola frankfurter, shank ham meatball leberkas strip steak brisket ball tip porchetta. Strip steak tenderloin sirloin flank. Pig jowl doner swine, alcatra pancetta turducken salami pork chop filet mignon sirloin.

Kevin shank chicken landjaeger chuck capicola shoulder ham hock t-bone cow beef ribs. Hamburger spare ribs swine pork loin ribeye sausage tenderloin. Cupim turkey hamburger beef tenderloin meatball ribeye chuck kielbasa strip steak fatback. T-bone prosciutto tri-tip, sausage ham hock shoulder drumstick leberkas pork loin hamburger short ribs cupim ground round rump corned beef. Tri-tip tongue drumstick kielbasa boudin ball tip porchetta salami bresaola ham ham hock meatball."
  )

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
