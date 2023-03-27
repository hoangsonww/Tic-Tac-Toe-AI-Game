import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    protected char[][] board = new char[3][3];

    // Constructor
    public TicTacToe() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Display the current state of the game board
    public void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Check if the game is over
    public boolean isGameOver() {
        return hasWon('X') || hasWon('O') || isTie();
    }

    // Check if the specified player has won the game
    public boolean hasWon(char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    // Check if the game has ended in a tie
    public boolean isTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Make a move on the game board for the specified player at the specified row and column
    public void makeMove(int row, int col, char player) {
        board[row][col] = player;
    }

    // Get the winner of the game
    public char getWinner() {
        if (hasWon('X')) {
            return 'X';
        } else if (hasWon('O')) {
            return 'O';
        } else {
            return 'T';
        }
    }
}



