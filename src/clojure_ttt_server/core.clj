(ns clojure-ttt-server.core
  (:require [clojure-ttt-server.unbeatable-ai :refer :all]
            [org.httpkit.server :refer :all]
            [cheshire.core :refer :all])
  (:gen-class))

(defn ttt [req]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (generate-string (minimax-move (vec (parse-string (apply doall (line-seq (clojure.java.io/reader (:body req))))))))})

(defn -main []
  (run-server ttt {:port 9000}))
