# clojure-ttt-server

Provides an unbeatable Tic-tac-toe-playing AI as a service. Post a JSON board 
string to get a minimax-generated move string in response.

## Starting the server

  1. Build the JAR: `lein uberjar`
  2. Start the server on port 9000: `java -jar target/clojure-ttt-server-0.1.0-SNAPSHOT-standalone.jar`

## Using the service

  * Send a POST request with a board in JSON format
      * Board should be a string representing a one-dimensional array
      * AI’s token is "O"; opponent’s token is "X"
      * Example: `"[\"O\",\"O\",\" \",\"X\",\"X\",\" \",\"X\",\" \",\" \"]"`
