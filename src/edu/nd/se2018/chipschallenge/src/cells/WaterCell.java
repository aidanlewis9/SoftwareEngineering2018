package cells;

import javafx.scene.image.ImageView;
import main.Player;
import utilities.IVProducer;

import java.awt.*;

public class WaterCell implements Cell {

    private ImageView iv;
    private Point position;

    public WaterCell(final int x, final int y) {
        position = new Point(x, y);
        iv = new IVProducer("textures/water.png", position.x, position.y).getImageView();
    }

    @Override
    public boolean canEnter() {
        return true;
    }

    @Override
    public boolean isDeadly() {
        return !Player.getInstance().canSwim();
    }

    @Override
    public boolean hasWon() {
        return false;
    }

    @Override
    public boolean isLand() {
        return false;
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

