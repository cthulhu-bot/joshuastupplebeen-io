(ns joshuastupplebeen-io.views
  (:require [re-frame.core :as re-frame]
            [re-com.core :as re-com]
            [joshuastupplebeen-io.subs :as subs]
            [joshuastupplebeen-io.events :as events]
            [joshuastupplebeen-io.weblog :as weblog]
            [joshuastupplebeen-io.components :as components]
            [joshuastupplebeen-io.home :as home]
            [joshuastupplebeen-io.portfolio :as portfolio]
            [joshuastupplebeen-io.contact :as contact]
            [joshuastupplebeen-io.utils :as utils]))

(defn icons []
  [re-com/h-box
   :width "55%"
   :justify :end
   :gap "20px"
   :children [[re-com/md-circle-icon-button
               :md-icon-name "zmdi-github"
               :style {:margin-left "15px"
                       :background-color "white"}
               :on-click (fn [_] (utils/redirect! "https://github.com/cthulhu-bot"))]
              [re-com/md-circle-icon-button
               :md-icon-name "zmdi-twitter"
               :style {:margin-left "15px"
                       :background-color "white"}
               :on-click (fn [_] (utils/redirect! "https://twitter.com/joshstupplebeen"))]]])

(defn nav-menu []
  [re-com/h-box
   :style {:background-color "#3c5b7f"
           :height "72px"
           :padding "20px"
           :font-size "170%"
           :font-family "PT Sans, Helvetica, Arial, sans-serif"}
   :children [[re-com/hyperlink
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
               :on-click #(re-frame/dispatch [:nav-contact])]
              [icons]]])

(defn portfolio []
  [re-com/v-box
   :style {:padding-left "10%"
           :padding-top "20px"}
   :width "70%"
   :gap "50px"
   :children [[portfolio/projects-card]]])

(defn contact []
  [re-com/v-box
   :style {:padding-left "10%"
           :padding-top "20px"}
   :width "70%"
   :gap "50px"
   :children [[contact/ccard01]]])

(defn home []
  [re-com/v-box
   :style {:padding-left "10%"
           :padding-top "20px"}
   :width "70%"
   :gap "50px"
   :children [[home/home-card]
              [weblog/post-card-01]]])

(defn weblog []
  [re-com/v-box
   :style {:padding-left "10%"
           :padding-top "20px"}
   :width "70%"
   :children [[weblog/post-card-01]]])

(defn main-panel []
  (let [page (re-frame/subscribe [::subs/page])
        rendered-page (case @page
                        "main"      [home]
                        "weblog"    [weblog]
                        "portfolio" [portfolio]
                        "contact"   [contact]
                        [home])]
    [re-com/v-box
     :height "100%"
     :style {:margin-bottom "50px"}
     :children [[nav-menu]
                rendered-page]]))
