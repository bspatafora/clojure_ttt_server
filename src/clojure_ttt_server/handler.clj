(ns clojure-ttt-server.handler
  (:require [clojure-ttt-server.unbeatable-ai :refer :all]
            [cheshire.core :refer :all]))

(defn- read-byte-stream [byte-stream]
  (slurp
    (.bytes byte-stream)))

(defn json-string-to-vector [json-string]
  (vec
    (parse-string json-string)))

(defn flat-board-to-2d-board [flat-board]
  (vector (subvec flat-board 0 3) (subvec flat-board 3 6) (subvec flat-board 6)))

(defn coordinate-move-to-integer-move [coordinate-move]
  (+ (last coordinate-move) (* 3 (first coordinate-move))))

(defn json-board-to-json-minimax-ai-move [json-board]
  (generate-string
    (coordinate-move-to-integer-move
      (minimax-move
        (flat-board-to-2d-board
          (json-string-to-vector json-board))))))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (json-board-to-json-minimax-ai-move (read-byte-stream (:body request)))})
