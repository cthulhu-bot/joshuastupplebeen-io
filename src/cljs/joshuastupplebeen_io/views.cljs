(ns joshuastupplebeen-io.views
  (:require [re-frame.core :as re-frame]
            [re-com.core :as re-com]
            [joshuastupplebeen-io.subs :as subs]
            [joshuastupplebeen-io.events :as events]))

(def test-text
"round round. Beef ribs kielbasa biltong, drumstick picanha ball tip landjaeger beef filet mignon fatback cow bresaola ham bacon meatball. Kielbasa drumstick tenderloin tail, swine buffalo porchetta. Ground round turducken boudin pancetta. Andouille meatloaf pork belly venison, corned beef chuck drumstick alcatra spare ribs.

Ribeye pork loin frankfurter sausage turducken hamburger. Pancetta strip steak venison, buffalo swine kevin tail fatback sausage ground round t-bone andouille short ribs pig. Cow corned beef beef kielbasa, pork loin turducken biltong meatball bacon cupim chicken. Bacon bresaola frankfurter, shank ham meatball leberkas strip steak brisket ball tip porchetta. Strip steak tenderloin sirloin flank. Pig jowl doner swine, alcatra pancetta turducken salami pork chop filet mignon sirloin.

Kevin shank chicken landjaeger chuck capicola shoulder ham hock t-bone cow beef ribs. Hamburger spare ribs swine pork loin ribeye sausage tenderloin. Cupim turkey hamburger beef tenderloin meatball ribeye chuck kielbasa strip steak fatback. T-bone prosciutto tri-tip, sausage ham hock shoulder drumstick leberkas pork loin hamburger short ribs cupim ground round rump corned beef. Tri-tip tongue drumstick kielbasa boudin ball tip porchetta salami bresaola ham ham hock meatball."
)

(defn title []
  (let [name (re-frame/subscribe [::subs/name])
        page (re-frame/subscribe [::subs/page])]
    [re-com/title
     :label (str "Hello from " @page)
     :level :level1]))

(defn nav-menu2 []
  [:div {:style {;;:background-color "#568e8f"
                           ;;:background-color "#083352"
                           :background-color "#3c5b7f"
                           :height "72px"
                           :padding "20px"
                 :font-size "170%"}}
   [re-com/hyperlink
    :style {:color "white"}
    :label "joshuastupplebeen.io"
    :on-click #(re-frame/dispatch [::events/initialize-db])] ;; not sure why events namespace is necessary
   [re-com/hyperlink
    :style {:color "white"
            :padding-left "40px"}
    :label "Weblog"
    :on-click #(re-frame/dispatch [:nav-weblog])]
   [re-com/hyperlink
    :style {:color "white"
            :padding-left "40px"}
    :label "Portfolio"
    :on-click #(re-frame/dispatch [:nav-portfolio])]
   [re-com/hyperlink
    :style {:color "white"
            :padding-left "40px"}
    :label "Contact"
    :on-click #(re-frame/dispatch [:nav-contact])]])

(defn nav-menu []
  [:div {:style {;;:background-color "#568e8f"
                           ;;:background-color "#083352"
                           :background-color "#3c5b7f"
                           :height "72px"
                           :padding "20px"
                           :font-size "170%"}}
             [:a {:href "www.google.com"
                  :style {:color "white"}}
              "joshuastupplebeen.io"]
             [:a {:href "www.google.com"
                  :style {:padding-left "40px"
                          :color "white"}}
              "Weblog"]
             [:a {:href "www.google.com"
                  :style {:padding-left "40px"
                          :color "white"}}
              "Portfolio"]
             [:a {:href "www.google.com"
                  :style {:padding-left "40px"
                          :color "white"}}
              "Contact"]])

(defn avatar
  ([]
   (avatar "https://lh6.googleusercontent.com/8t7ktX-9bc1r0busavZkly1cWbJ7szHZ0b2o4xborGsgfTziA11Ru0GyOBqINOtq8Z6Pcoc5ro7zPvM=w1043-h1320"))
  ([img-url]
   [:img {:src img-url
                    :style {:border-radius "50%"
                            :padding "10px"
                            :padding-left "30px"
                            :position "relative"}
                    :width "100px"
                    :height "100px"}]))

(defn post-preview
  ([] test-text)
  ([preview-content]
   [:div {:style {:border "1px solid"
                     :border-color "rgb(239, 237, 237)"
                     :padding-top "0px"}}
       [:h3 {:style {:background-color "rgb(239, 237, 237)"
                     :padding "10px"
                     :padding-left "20px"
                     :margin-top "0px"}}
        "Header"]
       [:div
        {:style {:display "flex"}}
        (avatar)
        [:div {:style {:display "flex"
                       :flex-direction "column"}}
         [:text-preview
          {:style {:padding "30px"}} preview-content]
         [:a {:href "#"
              :style {:padding "30px"}} "More..."]]]]))

(defn weblog []
  [re-com/v-box
   :children ["weblog"]])

(defn main-panel []
  (let [page (re-frame/subscribe [::subs/name])]
  [re-com/v-box
   :height "100%"
   :children [[nav-menu2] [title]]]))
