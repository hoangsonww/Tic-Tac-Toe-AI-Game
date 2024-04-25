# Tic Tac Toe Game

## Overview
This project contains two versions of the classic Tic Tac Toe game: a console-based version and a graphical version using JavaFX. The console version allows two players to play Tic Tac Toe in a terminal, while the JavaFX version provides a graphical interface with AI for playing against the computer.

## Features
- **Console Version**:
  - Play Tic Tac Toe in the terminal.
  - Two-player game without AI.
  
- **JavaFX Version**:
  - Graphical user interface for Tic Tac Toe.
  - Play against an AI opponent.
  - Displays winning line on game over.

## Prerequisites
- JDK 11 or higher.
- JavaFX SDK (for the JavaFX version).

## Setup and Installation
1. **JavaFX SDK**: Download the JavaFX SDK from [OpenJFX](https://openjfx.io/) and extract it to a known directory if you plan to run the JavaFX version.
2. **Clone the Repository**: Use `git clone <repository-url>` to clone this repository to your local machine.

## Running the Applications

### Console Version
1. Navigate to the directory containing the `TicTacToe.java` file.
2. Compile the Java file using `javac TicTacToe.java`.
3. Run the compiled class with `java TicTacToe`.
4. Follow the on-screen instructions to play the game.

### JavaFX Version
1. Ensure the JavaFX SDK is correctly set up in your IDE or on your system.
2. Compile the `TicTacToeFX.java` file, making sure to include the JavaFX libraries in your classpath.
3. Run the compiled class with the necessary VM options to include the JavaFX modules:
   ```
   --module-path "path/to/javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml

4. Follow the graphical interface to play against the AI.

## How to Play

### Console Version
- Players take turns entering the row and column numbers where they wish to place their mark (X or O).
- The game ends when one player has three of their marks in a row (horizontally, vertically, or diagonally) or when all squares are filled.

### JavaFX Version
- Click on the square where you wish to place your mark (X).
- The AI will make its move (O) after you.
- The game ends when one player wins or all squares are filled, with the winning line displayed.

## Contributing
Contributions to enhance the games, add new features, or improve the AI algorithm are welcome. Please fork the repository, make your changes, and submit a pull request with a detailed description of your improvements.

---

Created with ❤️ in 2023 by [Son Nguyen](https://github.com/hoangsonww). All rights reserved.