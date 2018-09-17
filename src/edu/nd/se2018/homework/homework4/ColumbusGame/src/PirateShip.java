import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class PirateShip implements Observer {
    private static final int GRID_DIMENSIONS = 25;
    private static final int GRID_MAX_INDEX = GRID_DIMENSIONS - 1;
    private static final int SCALING_FACTOR = 20;

    private Point shipPosition;
    private Point piratePosition;
    private ImageView pirateImageView;
    private Random random;

    // Constructor
    public PirateShip(){
        random = new Random();
        piratePosition = new Point(generateRandomCoordinate(), generateRandomCoordinate());

        final String filename = "images/pirateship.gif";
        final int imageSize = 20;
        final Image pirateImage = new Image(filename,imageSize,imageSize,true,true);

        pirateImageView = new ImageView(pirateImage);
        pirateImageView.setX(piratePosition.x * SCALING_FACTOR);
        pirateImageView.setY(piratePosition.y * SCALING_FACTOR);

        OceanMap.getInstance().setOceanGrid(piratePosition.x, piratePosition.y, OceanMap.CellType.PIRATE);
    }

    public ImageView getImageView(){
        return pirateImageView;
    }

    public void movePirate() {
        OceanMap.getInstance().setOceanGrid(piratePosition.x, piratePosition.y, OceanMap.CellType.OCEAN);

        if (piratePosition.x - shipPosition.x < 0 && piratePosition.x + 1 < GRID_DIMENSIONS) {
            piratePosition.x++;
        } else if (piratePosition.x - 1 >= 0) {
            piratePosition.x--;
        }

        if (piratePosition.y - shipPosition.y < 0 && piratePosition.y + 1 < GRID_DIMENSIONS) {
            piratePosition.y++;
        } else if (piratePosition.y - 1 >= 0) {
            piratePosition.y--;
        }

        pirateImageView.setX(piratePosition.x * SCALING_FACTOR);
        pirateImageView.setY(piratePosition.y * SCALING_FACTOR);

        OceanMap.getInstance().setOceanGrid(piratePosition.x, piratePosition.y, OceanMap.CellType.PIRATE);

        if (piratePosition.equals(shipPosition)) {
            System.out.println("You've been captured by the pirates!\nGAME OVER");
            Platform.exit();
        }
    }

    @Override
    public void update(Observable s, Object arg1) {
        if (s instanceof Ship){
            shipPosition = ((Ship) s).getPosition();
            movePirate();
        }
    }

    private int generateRandomCoordinate() {
        return random.nextInt(GRID_MAX_INDEX + 1);
    }
}
