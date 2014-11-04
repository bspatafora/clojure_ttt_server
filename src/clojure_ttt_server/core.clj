(ns clojure-ttt-server.core
  (:require [clojure-ttt-server.handler :refer :all]
            [org.httpkit.server :refer :all])
  (:gen-class))

(defn -main [arg]
  (run-server handler {:port (read-string arg)}))
