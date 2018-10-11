package cells;

import utilities.IVProducer;
import javafx.scene.image.ImageView;

import java.awt.*;

public class Portal implements CellBehavior {

    private ImageView iv;
    private Point position;

    public Portal(final int x, final int y) {
        position = new Point(x, y);
        iv = new IVProducer("textures/portal.png", position.x, position.y).getImageView();
    }

    @Override
    public boolean canEnter() {
        return true;
    }

    @Override
    public boolean isDeadly() {
        return false;
    }

    @Override
    public boolean hasWon() {
        return true;
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
