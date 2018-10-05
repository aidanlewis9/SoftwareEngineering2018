package cells;

import main.Player;
import utilities.IVProducer;
import javafx.scene.image.ImageView;

import java.awt.*;

public class FishCell implements Cell {

    private ImageView iv;
    private Point position;

    public FishCell(final int x, final int y) {
        position = new Point(x, y);
        iv = new IVProducer("textures/fish.PNG", position.x, position.y).getImageView();
    }

    @Override
    public boolean canEnter() {
        Player.getInstance().takeFish();
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