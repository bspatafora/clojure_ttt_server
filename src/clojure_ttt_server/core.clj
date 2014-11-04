(ns clojure-ttt-server.core
  (:require [clojure-ttt-server.handler :refer :all]
            [org.httpkit.server :refer :all])
  (:gen-class))

(defn -main [&args]
  (run-server handler {:port (Integer. (first *command-line-args*))}))
