package unit13.queens.view;

import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import unit13.queens.model.Board;
import unit13.queens.model.BoardObserver;
import unit13.queens.model.Square;

import unit13.queens.model.*;
import unit13.backtracker.Backtracker;

public class NQueensGUI extends Application implements BoardObserver {
    private void solve() {
        status.setText("Not implemented!");
        Queen[] queens = board.getQueens();
        NQueens config = new NQueens(n, queens);
        Backtracker<NQueens> backtracker = new Backtracker<>(false);
        NQueens solution = backtracker.solve(config);
        if(solution != null) {
            Queen[] solved = solution.getQueens();
            board.clear();
            board.placeQueens(solved);
            status.setText("Solved!");
        } else {
            status.setText("No solution...");
        }
    }

    private static final String IMAGE_PATH = "file:media/images/";
    private static final Image BLANK = new Image(IMAGE_PATH + "blank.png");
    private static final Image BLACK = new Image(IMAGE_PATH + "black.png");
    private static final Image WHITE = new Image(IMAGE_PATH + "white.png");
    private static final Image RED = new Image(IMAGE_PATH + "red.png");
    private static final Image QUEEN = new Image(IMAGE_PATH + "queen.png");

    private static final Font COURIER_18 = new Font("Courier New", 18);

    /**
     * The size fof the board (the number of rows and columns).
     */
    private int n;

    /**
     * The virtual board used to keep track of queens that have been placed, 
     * and which squares are empty or attackable.
     */
    private Board board;

    /**
     * Used to keep track of the buttons in the UI and their locations so that
     * the images can be changed.
     */
    private Button[][] buttons;

    /**
     * Use to display the current status to the user.
     */
    private Label status;

    @Override
    public void start(Stage stage) throws Exception {
        List<String> params = getParameters().getRaw();
        n = params.size() > 0 ? Integer.parseInt(params.get(0)) : 8;

        board = new Board(n);
        board.setOnUpdate(this);
        buttons = new Button[n][n];

        GridPane grid = new GridPane();
        Image background = BLACK;
        for(int row=0; row<n; row++) {
            for(int col=0; col<n; col++) {
                Button button = makeSquareButton(row, col, background);
                buttons[row][col] = button;
                grid.add(button, col, row);
                background = background == BLACK ? WHITE : BLACK;
            }
            background = background == BLACK ? WHITE : BLACK;
        }

        grid.setBorder(new Border(
            new BorderStroke(
                Color.BROWN, 
                BorderStrokeStyle.SOLID, 
                CornerRadii.EMPTY, 
                BorderStroke.THICK)));

        HBox controls = new HBox();
        controls.getChildren().addAll(
            makeControlButton("Clear", (e) -> {
                clear();
            }),
            makeControlButton("Solve", (e) -> {
                solve();
            })
        );
        grid.add(controls, 0, n, n, 1);

        status = new Label("Ready!");
        status.setFont(COURIER_18);
        status.setAlignment(Pos.CENTER_LEFT);
        status.setPadding(new Insets(5));
        status.setBackground(new Background(
            new BackgroundFill(
                Color.LIGHTBLUE, 
                CornerRadii.EMPTY, 
                Insets.EMPTY)));
        status.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        grid.add(status, 0, n+1, n, 1);


        Scene scene = new Scene(grid);
        stage.setTitle("The " + n + " Queens Problem");
        stage.setScene(scene);
        stage.show();
    }

    private void clear() {
        board.clear();
        status.setText("Ready!");
    }

    private Button makeControlButton(String text, 
        EventHandler<ActionEvent> handler) {
        Button button = new Button(text);
        button.setFont(COURIER_18);
        button.setPadding(new Insets(10));
        button.setAlignment(Pos.CENTER);
        button.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        button.setOnAction(handler);
        HBox.setHgrow(button, Priority.ALWAYS);
        return button;
    }

    private Button makeSquareButton(int row, int col, Image background) {
        Button button = new Button();
        button.setPrefSize(36, 36);
        button.setBackground(
            new Background(
                new BackgroundImage(background, 
                    BackgroundRepeat.NO_REPEAT, 
                    BackgroundRepeat.NO_REPEAT, 
                    BackgroundPosition.CENTER, 
                    BackgroundSize.DEFAULT)));
        button.setGraphic(new ImageView(BLANK));
        button.setPadding(Insets.EMPTY);
        button.setBorder(new Border(
            new BorderStroke(
                Color.BLACK, 
                BorderStrokeStyle.SOLID, 
                CornerRadii.EMPTY, 
                BorderStroke.THIN)));

        button.setOnAction((e) -> {
            status.setText(board.toggleQueen(row, col) ? 
                board.isSolution() ? "Solved!" : "Nice move!" : "Invalid move.");
        });

        return button;
    }

    @Override
    public void boardUpdated(Board board) {
        for(int row=0; row<n; row++) {
            for(int col=0; col<n; col++) {
                Square square = board.getSquare(row, col);
                Button button = buttons[row][col];
                if(square == Square.QUEEN) {
                    button.setGraphic(new ImageView(QUEEN));
                } else if(square == Square.ATTACKABLE) {
                    button.setGraphic(new ImageView(RED));
                } else {
                    button.setGraphic(new ImageView(BLANK));
                }
            }
        } 
    }

    public static void main(String[] args) {
        launch(args);
    }    
}
