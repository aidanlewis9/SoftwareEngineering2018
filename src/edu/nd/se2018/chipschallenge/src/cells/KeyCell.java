package cells;

import javafx.scene.image.ImageView;
import main.Player;
import utilities.Color;
import utilities.IVProducer;

import java.awt.*;

public class KeyCell implements Cell {

    private ImageView iv;
    private Point position;
    private Color key;

    public KeyCell(final int x, final int y, final Color color) {
        position = new Point(x, y);
        key = color;
        final String filepath = String.format("textures/%sKey.PNG", color.getString());
        iv = new IVProducer(filepath, position.x, position.y).getImageView();
    }

    @Override
    public boolean canEnter() {
        Player.getInstance().takeKey(key);
        return true;
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