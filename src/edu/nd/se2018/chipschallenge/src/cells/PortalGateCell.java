package cells;

import main.Grid;
import utilities.IVProducer;
import javafx.scene.image.ImageView;

import java.awt.*;

public class PortalGateCell implements Cell {

    private ImageView iv;
    private Point position;

    public PortalGateCell(final int x, final int y) {
        position = new Point(x, y);
        iv = new IVProducer("textures/portalGate.PNG", x, y).getImageView();
    }

    @Override
    public boolean canEnter() {
        if (Grid.getInstance().allChipsTaken()) {
            return true;
        }

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
