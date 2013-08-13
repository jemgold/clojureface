(ns clojureface.main
  (:require [crate.core :as crate])
  (:use [jayq.core :only [$ append delegate data]])
  (:use-macros [crate.def-macros :only [defpartial]]))


(def $body ($ :body))
(def $piano ($ :#piano))
(def $wobble ($ :#wobble))
(def $controls ($ :#controls))
(def $notes ($ :#notes))

(defpartial button [{:keys [label action param]}]
  [:a.button {:href "#" :data-action action :data-param param} label])


(def piano-notes (for [n (range 40 62)]
                   {:label (str n) :action "play-note" :param n}))

(def wobble-notes (for [n (range 40 80)]
                    {:label (str n) :action "play-note" :param n}))

(def wobble-pads (for [w (range 0 8)]
              {:label (str "wob" w) :action "wob" :param w}))

(def control-buttons [{:label "start" :action "start-dub" :param ""}
                      {:label "stop" :action "stop-dub" :param ""}])

(defn populate [container buttons]
  (doseq [b buttons]
    (append container (button b))))

(populate $piano piano-notes)
(populate $wobble wobble-pads)
(populate $notes wobble-notes)
(populate $controls control-buttons)

(delegate $body button :click
          (fn [e]
            (.preventDefault e)
            (this-as me
                     (let [$me ($ me)
                       action (data $me :action)
                       param (data $me :param)
                       param (if (= param "")
                               []
                               [param])]
                       (.log js/console action param)))))
