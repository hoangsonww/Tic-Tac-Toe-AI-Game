import java.util.Random;

public class AIPlayer {

    private Random rand = new Random();

    // Make a move for the specified player using the AI algorithm
    public void makeMove(TicTacToe game, char player) {
        // Check for a winning move
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.board[i][j] == ' ') {
                    game.makeMove(i, j, player);
                    if (game.hasWon(player)) {
                        return;
                    } else {
                        game.makeMove(i, j, ' ');
                    }
                }
            }
        }

        // Check for a blocking move
        char opponent = (player == 'X') ? 'O' : 'X';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.board[i][j] == ' ') {
                    game.makeMove(i, j, opponent);
                    if (game.hasWon(opponent)) {
                        game.makeMove(i, j, player);
                        return;
                    } else {
                        game.makeMove(i, j, ' ');
                    }
                }
            }
        }

        // Take the center square if available
        if (game.board[1][1] == ' ') {
            game.makeMove(1, 1, player);
            return;
        }

        // Take a random available corner
        int[][] corners = {{0, 0}, {0, 2}, {2, 0}, {2, 2}};
        int index = rand.nextInt(4);
        int row = corners[index][0];
        int col = corners[index][1];
        if (game.board[row][col] == ' ') {
            game.makeMove(row, col, player);
            return;
        }

        // Take a random available square
        while (true) {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
            if (game.board[row][col] == ' ') {
                game.makeMove(row, col, player);
                return;
            }
        }
    }
}
