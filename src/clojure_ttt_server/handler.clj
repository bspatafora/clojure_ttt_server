(ns clojure-ttt-server.handler
  (:require [clojure-ttt-server.unbeatable-ai :refer :all]
            [cheshire.core :refer :all]))

(defn- read-byte-stream [byte-stream]
  (slurp
    (.bytes byte-stream)))

(defn- json-string-to-vector [json-string]
  (vec
    (parse-string json-string)))

(defn json-board-to-json-minimax-ai-move [json-board]
  (generate-string
    (minimax-move
      (json-string-to-vector json-board))))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (json-board-to-json-minimax-ai-move (read-byte-stream (:body request)))})
