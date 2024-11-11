# Sudoku-Game
### Developed an API for a Sudoku game with solution generation powered by a backtracking algorithm. Designed an interactive UI using HTML, CSS, and JavaScript to enable gameplay. Key features include game modes (easy, medium, hard), options for generating new games, retrieving solutions, checking for a winning state, and filling the grid interactively.

## Game API'S 
### get easy sudoku puzzle
#### Request 
```
  http://localhost:8080/sudoku/easy
```
#### Response
```
[[0,0,0,8,0,7,0,4,9],
[0,0,3,9,0,5,2,0,0],
[9,0,1,0,0,4,0,7,0],
[0,0,5,0,0,8,0,0,1],
[4,0,8,0,0,0,9,0,3],
[3,0,0,2,0,0,8,0,0],
[0,2,0,1,0,0,6,0,5],
[0,0,4,5,0,2,1,0,0],
[1,5,0,7,0,6,0,0,0]]
```
### get medium sudoku puzzle
#### Request 
```
  http://localhost:8080/sudoku/medium
```
#### Response
```
[[0,0,0,8,0,7,0,4,9],
[0,0,3,9,0,5,2,0,0],
[9,0,1,0,0,4,0,7,0],
[0,0,5,0,0,8,0,0,1],
[4,0,8,0,0,0,9,0,3],
[3,0,0,2,0,0,8,0,0],
[0,2,0,1,0,0,6,0,5],
[0,0,4,5,0,2,1,0,0],
[1,5,0,7,0,6,0,0,0]]
```
### get hard sudoku puzzle
#### Request 
```
  http://localhost:8080/sudoku/hard
```
#### Response
```
[[0,0,0,8,0,7,0,4,9],
[0,0,3,9,0,5,2,0,0],
[9,0,1,0,0,4,0,7,0],
[0,0,5,0,0,8,0,0,1],
[4,0,8,0,0,0,9,0,3],
[3,0,0,2,0,0,8,0,0],
[0,2,0,1,0,0,6,0,5],
[0,0,4,5,0,2,1,0,0],
[1,5,0,7,0,6,0,0,0]]
```
### get next sudoku puzzle
#### Request 
```
  http://localhost:8080/sudoku/next
```
#### Response
```
[[0,0,0,8,0,7,0,4,9],
[0,0,3,9,0,5,2,0,0],
[9,0,1,0,0,4,0,7,0],
[0,0,5,0,0,8,0,0,1],
[4,0,8,0,0,0,9,0,3],
[3,0,0,2,0,0,8,0,0],
[0,2,0,1,0,0,6,0,5],
[0,0,4,5,0,2,1,0,0],
[1,5,0,7,0,6,0,0,0]]
```
### fill empty grid position
#### Request 
```
  http://localhost:8080/sudoku/{row}/{col}/{num}
```
#### Response
```
true / false
```
### checks valid empty grid cell
#### Request 
```
  http://localhost:8080/sudoku/{row}/{col}
```
#### Response
```
true / false
```
### checks user won the game or not
#### Request 
```
  http://localhost:8080/sudoku/won
```
#### Response
```
true / false
```
