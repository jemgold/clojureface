(defproject clojureface "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1844"]
                 [overtone "0.8.1" :exclusions [org.clojure/clojure]]
                 [jayq "2.4.0"]
                 [hiccup "1.0.4"]
                 [compojure "1.1.5"]
                 [ring/ring-jetty-adapter "1.1.6"]
                 [crate "0.2.4"]]
  :main clojureface.server
  :plugins [[lein-cljsbuild "0.3.2"]
            [lein-ring "0.8.6"]]
  :ring {:auto-refresh? true
         :handler clojureface.server/application}
  :source-paths ["src/clj"]
  :cljsbuild {
    :builds [{
      :source-paths ["src/cljs"]
      :compiler {
                 :output-to "resources/public/js/bootstrap.js"
                 :optimizations :whitespace
                 :pretty-print true
                 }}]})
