(ns joshuastupplebeen-io.utils)

(defn redirect! [loc]
  (set! (.-location js/window) loc))
