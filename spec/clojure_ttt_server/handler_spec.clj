(ns clojure-ttt-server.handler-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt-server.handler :refer :all]))

(describe "json-board-to-json-minimax-ai-move"
  (it "returns the minimax AI move for the passed JSON board"
    (should= "2" 
             (json-board-to-json-minimax-ai-move "[\"O\",\"O\",\" \",\"X\",\"X\",\" \",\"X\",\" \",\" \"]"))))

(describe "json-string-to-vector"
  (it "turns a 2D vector-like JSON string into a vector"
    (should= [["O" "O" " "] ["X" "X" " "] ["X" " " " "]] 
             (json-string-to-vector "[[\"O\",\"O\",\" \"], [\"X\",\"X\",\" \"], [\"X\",\" \",\" \"]]")))
  (it "turns a flat vector-like JSON string into a vector"
    (should= ["O" "O" " " "X" "X" " " "X" " " " "] 
             (json-string-to-vector "[\"O\",\"O\",\" \",\"X\",\"X\",\" \",\"X\",\" \",\" \"]"))))

(describe "flat-board-to-2d-board"
  (it "turns a flat board vector into a 2D board vector"
    (should= [["O" "O" " "] ["X" "X" " "] ["X" " " " "]] (flat-board-to-2d-board ["O" "O" " " "X" "X" " " "X" " " " "]))))

(describe "coordinate-move-to-integer-move"
  (it "converts coordinate-move [0,2] (for a 2D board) into integer-move 2 (for a 1D board)"
    (should= 2 (coordinate-move-to-integer-move [0,2])))
  (it "converts [2,1] into 7"
    (should= 7 (coordinate-move-to-integer-move [2,1]))))
