package cells;

import utilities.IVProducer;
import javafx.scene.image.ImageView;
import utilities.Orientation;
import utilities.State;

import java.awt.*;

public class PlayerCell implements Cell {

    private ImageView iv;
    private Point position;

    public PlayerCell(final int x, final int y, final Orientation orientation, final State state) {
        position = new Point(x, y);

        final String filepath = getFilepath(state, orientation);
        iv = new IVProducer(filepath, position.x, position.y).getImageView();
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

    public void setPosition(final Point position) {
        this.position = position;
    }

    private String getFilepath(final State state, final Orientation orientation) {
        switch (state) {
            case LAND:
                return String.format("textures/chip%s.PNG", orientation.getString());
            case WATER:
                return String.format("textures/chipSwim%s.PNG", orientation.getString());
            case WON:
                return String.format("textures/chip%s.PNG", orientation.getString());
            case DEAD:
                return "textures/chipDrowns.PNG";
        }

        return "";
    }
}
