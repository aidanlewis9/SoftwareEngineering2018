package cells;

import main.Player;
import utilities.Color;
import utilities.IVProducer;
import javafx.scene.image.ImageView;

import java.awt.*;

public class Door implements CellBehavior {

    private ImageView iv;
    private Point position;
    private Color key;

    public Door(final int x, final int y, final Color color) {
        position = new Point(x, y);
        key = color;
        final String filepath = String.format("textures/%sKeyWall.PNG", color.getString());
        iv = new IVProducer(filepath, position.x, position.y).getImageView();
    }

    @Override
    public boolean canEnter() {
        return Player.getInstance().useKey(key);
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