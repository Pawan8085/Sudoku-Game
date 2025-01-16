# Sudoku-Game
### Developed an API for a Sudoku game with solution generation powered by a backtracking algorithm. Designed an interactive UI using HTML, CSS, and JavaScript to enable gameplay. Key features include game modes (easy, medium, hard), options for generating new games, retrieving solutions, checking for a winning state, and filling the grid interactively.
---
### **Features**

- 🎮 **Game Modes**:
  - **Easy**: Easy Sudoku puzzle.
  - **Medium**: Medium Sudoku puzzle.
  - **Hard**: Hard Sudoku puzzle.

- 🔄 **Next Game**: Option to switch to another game.

- 💡 **Sudoku Solution**: Access the solution to the current puzzle when needed.

- ✍️ **Play Sudoku**:
  - **Fill Empty Positions**: Interactively input numbers into blank cells.
  - **Real-Time Validation**: Checks whether input is correct or incorrect.

- 🏆 **Win Detection**: Automatically notified upon successful completion of the puzzle.

- 💻 **Interactive UI**:
  - **User-Friendly Interface**: Built with HTML, CSS, and JavaScript for an engaging user experience.

- 🎥 **Demo Video**: Watch the game in action [here](https://drive.google.com/file/d/1oED-YMqrxem8qit1y04QJTMv8AN4UQA6/view?usp=sharing).

---
## Game API'S 
### Get Easy Sudoku Puzzle

- **URL**: `/sudoku/easy`
- **Method**: `GET`
- **Description**: Retrieves an easy-level Sudoku puzzle for the user to solve.
  
#### Response
Returns a 9x9 Sudoku puzzle grid with some cells prefilled and others set to 0.

**Example Response:**
```json
[
  [0, 0, 0, 8, 0, 7, 0, 4, 9],
  [0, 0, 3, 9, 0, 5, 2, 0, 0],
  [9, 0, 1, 0, 0, 4, 0, 7, 0],
  [0, 0, 5, 0, 0, 8, 0, 0, 1],
  [4, 0, 8, 0, 0, 0, 9, 0, 3],
  [3, 0, 0, 2, 0, 0, 8, 0, 0],
  [0, 2, 0, 1, 0, 0, 6, 0, 5],
  [0, 0, 4, 5, 0, 2, 1, 0, 0],
  [1, 5, 0, 7, 0, 6, 0, 0, 0]
]
```

### Get Medium Sudoku Puzzle

- **URL**: `/sudoku/medium`
- **Method**: `GET`
- **Description**: Retrieves a medium-level Sudoku puzzle for the user to solve.
  
#### Response
Returns a 9x9 Sudoku puzzle grid with some cells prefilled and others set to 0.

**Example Response:**
```json
[
  [0, 0, 0, 8, 0, 7, 0, 4, 9],
  [0, 0, 3, 9, 0, 5, 2, 0, 0],
  [9, 0, 1, 0, 0, 4, 0, 7, 0],
  [0, 0, 5, 0, 0, 8, 0, 0, 1],
  [4, 0, 8, 0, 0, 0, 9, 0, 3],
  [3, 0, 0, 2, 0, 0, 8, 0, 0],
  [0, 2, 0, 1, 0, 0, 6, 0, 5],
  [0, 0, 4, 5, 0, 2, 1, 0, 0],
  [1, 5, 0, 7, 0, 6, 0, 0, 0]
]

```
### Get Hard Sudoku Puzzle

- **URL**: `/sudoku/hard`
- **Method**: `GET`
- **Description**: Retrieves a hard-level Sudoku puzzle for the user to solve.

#### Response
Returns a 9x9 Sudoku puzzle grid with some cells prefilled and others set to 0.

**Example Response:**
```json
[
  [0, 0, 0, 8, 0, 7, 0, 4, 9],
  [0, 0, 3, 9, 0, 5, 2, 0, 0],
  [9, 0, 1, 0, 0, 4, 0, 7, 0],
  [0, 0, 5, 0, 0, 8, 0, 0, 1],
  [4, 0, 8, 0, 0, 0, 9, 0, 3],
  [3, 0, 0, 2, 0, 0, 8, 0, 0],
  [0, 2, 0, 1, 0, 0, 6, 0, 5],
  [0, 0, 4, 5, 0, 2, 1, 0, 0],
  [1, 5, 0, 7, 0, 6, 0, 0, 0]
]

```
### Get Next Sudoku Puzzle

- **URL**: `/sudoku/next`
- **Method**: `GET`
- **Description**: Retrieves the next Sudoku puzzle for the user to solve.

#### Response
Returns a 9x9 Sudoku puzzle grid, which could be the next puzzle in the game sequence.

**Example Response:**
```json
[
  [0, 0, 0, 8, 0, 7, 0, 4, 9],
  [0, 0, 3, 9, 0, 5, 2, 0, 0],
  [9, 0, 1, 0, 0, 4, 0, 7, 0],
  [0, 0, 5, 0, 0, 8, 0, 0, 1],
  [4, 0, 8, 0, 0, 0, 9, 0, 3],
  [3, 0, 0, 2, 0, 0, 8, 0, 0],
  [0, 2, 0, 1, 0, 0, 6, 0, 5],
  [0, 0, 4, 5, 0, 2, 1, 0, 0],
  [1, 5, 0, 7, 0, 6, 0, 0, 0]
]

```
### Fill Empty Grid Position

- **URL**: `/sudoku/{row}/{col}/{num}`
- **Method**: `PUT`
- **Description**: Fills a specific empty position in the Sudoku grid with a number provided by the user.

## Request Parameters

| Parameter | Type     | Required | Description                                                      |
|-----------|----------|----------|------------------------------------------------------------------|
| `row`     | `int`    | Yes      | The row number in the Sudoku grid to fill or validate.           |
| `col`     | `int`    | Yes      | The column number in the Sudoku grid to fill or validate.        |
| `num`     | `int`    | Yes      | The number to fill in the grid position (1-9).                   |

#### Response
- **Type**: `Boolean`
- **Description**: Returns `true` if the number is valid for the specified position, otherwise `false`.

**Example Request:**
```http
PUT /sudoku/0/2/5
```
### Checks if the Grid Cell is Valid for User Input

- **URL**: `/sudoku/{row}/{col}`
- **Method**: `GET`
- **Description**: Checks whether the specified grid cell is empty and valid for user input.

#### Request
- **Path Parameters**:
  - `row` (Integer): The row number of the grid (0-8).
  - `col` (Integer): The column number of the grid (0-8).

#### Response
- **Type**: `Boolean`
- **Description**: Returns `true` if the specified cell is empty and valid for input, otherwise `false`.

**Example Request:**
```http
GET /sudoku/0/2
```
### Checks if the user has won the game

- **URL**: `/sudoku/won`
- **Method**: `GET`
- **Description**: Checks whether the user has successfully completed the Sudoku puzzle.

#### Response
- **Type**: `Boolean`
- **Description**: Returns `true` if the user has completed the Sudoku puzzle correctly, otherwise `false`.

**Example Request:**
```http
GET /sudoku/won
```

<br/>

## Game UI



![sudoku_](https://github.com/user-attachments/assets/42540b29-b6d6-45fe-868b-48f488be0283)
