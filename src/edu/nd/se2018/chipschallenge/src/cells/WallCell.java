package cells;

import javafx.scene.image.ImageView;
import utilities.IVProducer;

import java.awt.*;

public class WallCell implements Cell {

    private ImageView iv;
    private Point position;

    public WallCell(final int x, final int y) {
        position = new Point(x, y);
        iv = new IVProducer("textures/wall.PNG", position.x, position.y).getImageView();
    }

    @Override
    public boolean canEnter() {
        return false;
    }

    @Override
    public boolean isDeadly() {
        return false;
    }

    @Override
    public boolean hasWon() {
        return false;
    }

    @Override
    public boolean isLand() {
        return true;
    }

    @Override
    public ImageView getImageView() {
        return iv;
    }

    @Override
    public int getX() {
        return position.x;
    }

    @Override
    public int getY() {
        return position.y;
    }
}

