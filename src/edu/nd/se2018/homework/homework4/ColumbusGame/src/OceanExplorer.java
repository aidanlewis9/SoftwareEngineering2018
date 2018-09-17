import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.LinkedList;

public class OceanExplorer extends Application {
    private static final int SCALING_FACTOR = 20;

    private OceanMap oceanMap;
    private Ship columbusShip;
    private LinkedList<PirateShip> pirateShips;

    public OceanExplorer() {
        pirateShips = new LinkedList<>();
        columbusShip = new Ship();

        int pirateCount = 2;

        for(int j = 0; j < pirateCount; j++) {
            final PirateShip pirateShip = new PirateShip();
            pirateShips.add(pirateShip);
            columbusShip.addObserver(pirateShip);
        }
    }

    public static void main(String[] args) {
        new OceanExplorer();
        launch(args);
    }

    public void start(final Stage oceanStage) {
        final int width = 520;
        final int height = 520;
        final String title = "My Island";

        final Pane root = new AnchorPane();
        final Scene scene = new Scene(root, width, height);

        oceanMap = OceanMap.getInstance();
        oceanMap.drawMap(root.getChildren(), SCALING_FACTOR);

        root.getChildren().add(columbusShip.getImageView());

        for (final PirateShip pirateShip : pirateShips) {
            root.getChildren().add(pirateShip.getImageView());
        }

        oceanStage.setScene(scene);
        oceanStage.setTitle(title);
        oceanStage.show();

        startSailing(scene);
    }

    private void startSailing(final Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                switch (ke.getCode()) {
                    case RIGHT:
                        columbusShip.goEast();
                        break;
                    case LEFT:
                        columbusShip.goWest();
                        break;
                    case UP:
                        columbusShip.goNorth();
                        break;
                    case DOWN:
                        columbusShip.goSouth();
                        break;
                    default:
                        break;
                }

                columbusShip.getImageView().setX(columbusShip.getPosition().x * SCALING_FACTOR);
                columbusShip.getImageView().setY(columbusShip.getPosition().y * SCALING_FACTOR);
            }
        });
    }


}
