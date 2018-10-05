package main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utilities.State;

public class Game extends Application{

    private Pane root;
    private Scene scene;
    private Player player;
    private Grid grid;
    private Scoreboard scoreboard;
    private State state;
    private int level = 1;

    @Override
    public void start(Stage stage) {
        root = new Pane();

        scene = new Scene(root,650,700);
        stage.setTitle("Chip's Challenge");
        stage.setScene(scene);
        stage.show();

        reset();

        startPlaying(stage);
    }

    private void startPlaying(Stage stage) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.ESCAPE){
                    stage.close();
                }


                if (state == State.WON || state == State.DEAD) {
                    return;
                }

                state = player.move(root, ke);

                if (state == State.DEAD) {
                    scoreboard.dead(root);
                } else if (state == State.WON && level == 1) {
                    scoreboard.nextLevel(root);
                    level++;
                    reset();
                } else if (state == State.WON) {
                    scoreboard.beatGame(root);
                } else {
                    scoreboard.updateItems(root, level);
                }


            }
        });
    }

    private void reset() {
        root.getChildren().clear();
        grid = new Level(root).generateLevel(level);

        state = State.LAND;
        player = Player.getInstance();

        scoreboard = new Scoreboard();
        scoreboard.updateItems(root, level);
    }

    public static void main(String[] args){
        launch(args);
    }
}

