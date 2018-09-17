import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.Point;
import java.util.Observable;
import java.util.Random;

public class Ship extends Observable {
    private static final int GRID_DIMENSIONS = 25;
    private static final int GRID_MAX_INDEX = GRID_DIMENSIONS - 1;
    private static final int SCALING_FACTOR = 20;

    private Point position;
    private ImageView imageView;
    private Random random;

    public Ship() {
        random = new Random();
        final int startX = generateRandomCoordinate();
        final int startY = generateRandomCoordinate();
        position = new Point(startX, startY);

        final String filename = "images/ColumbusShip.png";
        final int imageSize = 20;
        final Image image = new Image(filename,imageSize,imageSize,true,true);

        imageView = new ImageView(image);
        imageView.setX(position.x * SCALING_FACTOR);
        imageView.setY(position.y * SCALING_FACTOR);
    }

    public ImageView getImageView(){
        return imageView;
    }

    private int generateRandomCoordinate() {
        return random.nextInt(GRID_MAX_INDEX + 1);
    }

    public Point getPosition() {
        return position;
    }

    public void goEast() {
        OceanMap oceanMap = OceanMap.getInstance();

        if (position.x + 1 < GRID_DIMENSIONS && oceanMap.isOcean(position.x + 1, position.y)) {
            oceanMap.setOceanGrid(position.x, position.y, OceanMap.CellType.OCEAN);
            position.x++;
            oceanMap.setOceanGrid(position.x, position.y, OceanMap.CellType.COLUMBUS);
            updateObservers();
        }
    }

    public void goWest() {
        OceanMap oceanMap = OceanMap.getInstance();

        if (position.x - 1 >= 0 && oceanMap.isOcean(position.x - 1, position.y)) {
            oceanMap.setOceanGrid(position.x, position.y, OceanMap.CellType.OCEAN);
            position.x--;
            oceanMap.setOceanGrid(position.x, position.y, OceanMap.CellType.COLUMBUS);
            updateObservers();
        }
    }

    public void goNorth() {
        OceanMap oceanMap = OceanMap.getInstance();

        if (position.y - 1 >= 0 && oceanMap.isOcean(position.x, position.y - 1)) {
            oceanMap.setOceanGrid(position.x, position.y, OceanMap.CellType.OCEAN);
            position.y--;
            oceanMap.setOceanGrid(position.x, position.y, OceanMap.CellType.COLUMBUS);
            updateObservers();
        }
    }

    public void goSouth() {
        OceanMap oceanMap = OceanMap.getInstance();

        if (position.y + 1 < GRID_DIMENSIONS && oceanMap.isOcean(position.x, position.y + 1)) {
            oceanMap.setOceanGrid(position.x, position.y, OceanMap.CellType.OCEAN);
            position.y++;
            oceanMap.setOceanGrid(position.x, position.y, OceanMap.CellType.COLUMBUS);
            updateObservers();
        }
    }

    private void updateObservers() {
        setChanged();
        notifyObservers();
    }
}
