import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TicTacToeFX extends Application {
    private TicTacToe game = new TicTacToe();
    private AIPlayer ai = new AIPlayer();
    private Button[][] buttons = new Button[3][3];
    private boolean playerTurn = true;
    private boolean gameOver = false;
    private Move lastMove = null;

    private Label statusLabel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setPrefSize(100, 100);
                button.setFont(Font.font("Verdana", FontWeight.BOLD, 36));
                gridPane.add(button, j, i);
                buttons[i][j] = button;

                final int row = i;
                final int col = j;
                button.setOnAction(event -> {
                    if (gameOver) {
                        return;
                    }
                    if (game.board[row][col] == ' ') {
                        game.makeMove(row, col, 'X');
                        lastMove = new Move(row, col);
                        button.setText("X");
                        checkGameState();
                        if (!gameOver) {
                            playerTurn = false;
                            ai.makeMove(game, 'O');
                            lastMove = lastMove;
                            buttons[lastMove.row][lastMove.col].setText("O");
                            checkGameState();
                            playerTurn = true;
                        }
                    }
                });
            }
        }

        StackPane root = new StackPane();
        root.getChildren().add(gridPane);

        Text message = new Text("");
        message.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        message.setFill(Color.RED);
        root.getChildren().add(message);
        StackPane.setAlignment(message, Pos.BOTTOM_CENTER);

        Scene scene = new Scene(root, 320, 320);

        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void checkGameState() {
        if (game.isGameOver()) {
            gameOver = true;
            if (game.hasWon('X')) {
                showWinningLine(getWinningLine());
                showMessage("You win!");
            } else if (game.hasWon('O')) {
                showWinningLine(getWinningLine());
                showMessage("The computer wins!");
            } else {
                showMessage("It's a tie!");
            }
        }
    }

    private void showMessage(String message) {
        Text text = new Text(message);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        text.setFill(Color.RED);
        StackPane root = (StackPane) buttons[0][0].getParent().getParent();
        root.getChildren().add(text);
        StackPane.setAlignment(text, Pos.BOTTOM_CENTER);
    }

    private void showWinningLine(Line line) {
        StackPane root = (StackPane) buttons[0][0].getParent().getParent();
        Line lineShape = new Line(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
        lineShape.setStrokeWidth(5);
        lineShape.setStroke(Color.GREEN);
        root.getChildren().add(lineShape);
    }

    public Line getWinningLine() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (game.board[i][0] != ' ' && game.board[i][0] == game.board[i][1] && game.board[i][1] == game.board[i][2]) {
                return new Line(50, (i + 0.5) * 100, 250, (i + 0.5) * 100);
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (game.board[0][j] != ' ' && game.board[0][j] == game.board[1][j] && game.board[1][j] == game.board[2][j]) {
                return new Line((j + 0.5) * 100, 50, (j + 0.5) * 100, 250);
            }
        }

        // Check diagonals
        if (game.board[1][1] != ' ' && game.board[0][0] == game.board[1][1] && game.board[1][1] == game.board[2][2]) {
            return new Line(50, 50, 250, 250);
        }
        if (game.board[1][1] != ' ' && game.board[0][2] == game.board[1][1] && game.board[1][1] == game.board[2][0]) {
            return new Line(250, 50, 50, 250);
        }

        return null;
    }

}
