import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        AIPlayer ai = new AIPlayer();
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("You are X, and the computer is O.");
        System.out.println("Here is the starting board:");
        game.displayBoard();

        while (!game.isGameOver()) {
            // User's turn
            System.out.println("Enter row and column (1-3):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            while (game.board[row][col] != ' ') {
                System.out.println("That square is already taken. Enter another row and column (1-3):");
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;
            }
            game.makeMove(row, col, 'X');
            System.out.println("You played:");
            game.displayBoard();

            if (game.isGameOver()) {
                break;
            }

            // Computer's turn
            System.out.println("The computer is playing...");
            ai.makeMove(game, 'O');
            System.out.println("The computer played:");
            game.displayBoard();
        }

        char winner = game.getWinner();
        if (winner == 'X') {
            System.out.println("You win!");
        } else if (winner == 'O') {
            System.out.println("The computer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

}
