(ns clojureface.views.common
  (:use [hiccup core page]))

(defn index-page [& content]
  (html5
    [:head
      [:title "Clojureface"]
      (include-css "/css/reset.css")
      (include-css "/css/default.css")
      (include-js "https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js")]
    [:body
      [:div#wrapper
        [:h2 "Clojureface"]
        content]
      (include-js "/js/bootstrap.js")
      ]))
