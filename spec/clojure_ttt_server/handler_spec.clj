(ns clojure-ttt-server.handler-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt-server.handler :refer :all]))

(describe "json-board-to-json-minimax-ai-move"
  (it "returns the minimax AI’s move for the passed JSON board"
    (should= (json-board-to-json-minimax-ai-move "[[\"O\",\"O\",\" \"], [\"X\",\"X\",\" \"], [\"X\",\",\",\" \"]]") "[0,2]")))
