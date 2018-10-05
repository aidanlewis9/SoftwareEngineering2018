package main;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Scoreboard {
    private static final int CANVAS_WIDTH = 650;
    private static final int CANVAS_HEIGHT = 700;

    private static final int TEXT_X = 250;
    private static final int TEXT_Y = 650;
    private static final int FISH_HINT_X = 25;
    private static final int FISH_HINT_Y = 650;
    private static final int ESCAPE_HINT_X = 480;
    private static final int ESCAPE_HINT_Y = 650;

    private static final int GENERAL_FONT_SIZE = 18;
    private static final int HINT_FONT_SIZE = 15;


    private Canvas canvas;

    public Scoreboard() {
        canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    public void nextLevel(Pane root) {
        changeText(root, "Awesome job! Time for the next level!");
    }

    public void updateItems(Pane root, int level) {
        final String text = String.format("Chips remaining: %s\nKeys held: %s\nLevel: %s",
                Grid.getInstance().getChipsRemaining(),
                Player.getInstance().getKeyString(),
                level);

        changeText(root, text);
    }

    public void dead(Pane root) {
        changeText(root, "Sorry! You're dead!");
    }

    public void beatGame(Pane root) {
        changeText(root, "You beat the game!");
    }

    private void changeText(Pane root, final String text) {

        if (root.getChildren().contains(canvas)) {
            root.getChildren().remove(canvas);
        }

        canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setStroke(Color.DARKGRAY);
        gc.setFont(Font.font("Arial", FontWeight.BOLD, GENERAL_FONT_SIZE));
        gc.fillText(text, TEXT_X, TEXT_Y);
        addFishHint(gc);
        addEscapeHint(gc);

        root.getChildren().add(canvas);
    }

    private void addFishHint(GraphicsContext gc) {
        gc.setFont(Font.font("Arial", FontWeight.BOLD, HINT_FONT_SIZE));
        gc.fillText("Hint: The fish allows\nChip to swim!", FISH_HINT_X, FISH_HINT_Y);
    }

    private void addEscapeHint(GraphicsContext gc) {
        gc.setFont(Font.font("Arial", FontWeight.BOLD, HINT_FONT_SIZE));
        gc.fillText("Hint: Press escape\nto quit!", ESCAPE_HINT_X, ESCAPE_HINT_Y);
    }
}
