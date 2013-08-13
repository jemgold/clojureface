(ns clojureface.server
  (:use [compojure.core]
        [clojureface.views.common]
        [ring.adapter.jetty :as ring])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]))

(defroutes app-routes
  (GET "/" [] (index-page
               [:div#controls]
               [:div#wobble]
               [:div#notes]
               [:div#piano]))
  (route/resources "/"))

(def application
  (handler/site app-routes))

(defn -main []
    (run-jetty #'application {:port 8080 :join? false}))