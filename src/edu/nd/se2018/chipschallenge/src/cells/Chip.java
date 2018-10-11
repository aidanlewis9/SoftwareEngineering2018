package cells;

import main.Grid;
import utilities.IVProducer;
import javafx.scene.image.ImageView;

import java.awt.*;

public class Chip implements CellBehavior {

    private ImageView iv;
    private Point position;

    public Chip(final int x, final int y) {
        position = new Point(x, y);
        iv = new IVProducer("textures/chip.PNG", position.x, position.y).getImageView();
        Grid.getInstance().incrementChips();
    }

    @Override
    public boolean canEnter() {
        Grid.getInstance().takeChip();
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