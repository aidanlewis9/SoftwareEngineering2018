package utilities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IVProducer {
    private static final int IMAGE_SIZE = 25;
    private static final int SCALING_FACTOR = 25;

    private ImageView iv;

    public IVProducer(String filepath, int x, int y) {
        Image img = new Image(filepath,  IMAGE_SIZE,  IMAGE_SIZE,false,true);
        iv = new javafx.scene.image.ImageView(img);
        iv.setX(x * SCALING_FACTOR);
        iv.setY(y * SCALING_FACTOR);
    }

    public ImageView getImageView() {
        return iv;
    }


}
