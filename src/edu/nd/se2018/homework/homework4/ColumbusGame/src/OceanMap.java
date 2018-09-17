import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
//import javafx.scene.shape.Rectangle;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class OceanMap {
    enum CellType {
        OCEAN, ISLAND, COLUMBUS, PIRATE;
    }

    private static final int DIMENSIONS = 25;
    private static final int GRID_MAX_INDEX = DIMENSIONS - 1;
    private static final int ISLANDS_COUNT = 10;
    private static OceanMap oceanMap;

    private final CellType[][] oceanGrid = new CellType[DIMENSIONS][DIMENSIONS];

    private OceanMap() { }

    public static OceanMap getInstance() {
        if (oceanMap == null) {
            oceanMap = new OceanMap();
        }

        return oceanMap;
    }

    public void drawMap(ObservableList<Node> root, int scale) {
        final Set<Point> islands = generateIslands();

        for (int x = 0; x < DIMENSIONS; x++) {
            for (int y = 0; y < DIMENSIONS; y++) {
                final Point p = new Point(x, y);
                final Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
                rect.setStroke(Color.BLACK);

                if (islands.contains(p)) {
                    configureIslandRect(rect, x, y);
                } else {
                    configureOceanRect(rect, x, y);
                }

                root.add(rect);
            }
        }
    }

    public void setOceanGrid(final int x, final int y, final CellType cellType) {
        oceanGrid[x][y] = cellType;
    }

    private void configureIslandRect(final Rectangle rect, final int x, final int y) {
        rect.setFill(Color.GREEN);
        oceanGrid[x][y] = CellType.ISLAND;
    }

    private void configureOceanRect(final Rectangle rect, final int x, final int y) {
        rect.setFill(Color.PALETURQUOISE);
        oceanGrid[x][y] = CellType.OCEAN;
    }

    private Set<Point> generateIslands() {
        Set<Point> islands = new HashSet<>();

        while (islands.size() < ISLANDS_COUNT) {
            final Point island = generateRandomPoint();
            islands.add(island);
        }

        return islands;
    }

    private Point generateRandomPoint() {
        return new Point(generateRandomCoordinate(), generateRandomCoordinate());
    }

    private int generateRandomCoordinate() {
        final int min = 0;
        return (int) Math.round((Math.random() * ((GRID_MAX_INDEX - min) + 1)) + min);
    }

    public boolean isOcean(final int x, final int y) {
        return (oceanGrid[x][y] == CellType.OCEAN);
    }
}
