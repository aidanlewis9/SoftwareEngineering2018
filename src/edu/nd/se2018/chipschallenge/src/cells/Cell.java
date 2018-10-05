package cells;

import javafx.scene.image.ImageView;

public interface Cell {
    boolean canEnter();
    boolean isDeadly();
    boolean hasWon();
    boolean isLand();
    ImageView getImageView();
    int getX();
    int getY();
}
