package main;

import cells.*;
import utilities.Color;
import javafx.scene.layout.Pane;

public class Level {

    private Grid grid;
    private Pane root;
    private CellFactory factory;

    public Level(Pane root) {
        grid = Grid.getInstance();
        factory = new CellFactory();
        this.root = root;
    }


    public Grid generateLevel(final int level) {
        grid.clear();
        grid = Grid.getInstance();

        if (level == 1) {
            return levelOne();
        } else {
            return levelTwo();
        }
    }

    private Grid levelOne() {

        // add walls

        // left side
        factory.addCell(grid, CellType.WALL, 5, 5);
        factory.addCell(grid, CellType.WALL, 5, 6);
        factory.addCell(grid, CellType.WALL, 5, 7);
        factory.addCell(grid, CellType.WALL, 5, 8);
        factory.addCell(grid, CellType.WALL, 5, 9);
        factory.addCell(grid, CellType.WALL, 5, 10);
        factory.addCell(grid, CellType.WALL, 5, 11);
        factory.addCell(grid, CellType.WALL, 5, 12);
        factory.addCell(grid, CellType.DOOR, 5, 13, Color.RED);
        factory.addCell(grid, CellType.WALL, 5, 14);
        factory.addCell(grid, CellType.WALL, 5, 15);
        factory.addCell(grid, CellType.WALL, 5, 16);
        factory.addCell(grid, CellType.WALL, 5, 17);
        factory.addCell(grid, CellType.WALL, 5, 18);
        factory.addCell(grid, CellType.WALL, 5, 19);
        factory.addCell(grid, CellType.WALL, 5, 20);

        // left outlet
        factory.addCell(grid, CellType.WALL, 4, 10);
        factory.addCell(grid, CellType.WALL, 3, 10);
        factory.addCell(grid, CellType.WALL, 2, 10);
        factory.addCell(grid, CellType.WALL, 1, 10);
        factory.addCell(grid, CellType.WALL, 1, 11);
        factory.addCell(grid, CellType.WALL, 1, 12);
        factory.addCell(grid, CellType.WALL, 1, 13);
        factory.addCell(grid, CellType.WALL, 1, 14);
        factory.addCell(grid, CellType.WALL, 1, 15);
        factory.addCell(grid, CellType.WALL, 2, 15);
        factory.addCell(grid, CellType.WALL, 3, 15);
        factory.addCell(grid, CellType.WALL, 4, 15);

        // add key in left outlet
        factory.addCell(grid, CellType.KEY, 2, 14, Color.YELLOW);

        // add chip in left outlet
        factory.addCell(grid, CellType.CHIP, 2, 11);

        // bottom
        factory.addCell(grid, CellType.WALL, 5, 20);
        factory.addCell(grid, CellType.WALL, 6, 20);
        factory.addCell(grid, CellType.WALL, 7, 20);
        factory.addCell(grid, CellType.WALL, 8, 20);
        factory.addCell(grid, CellType.WALL, 9, 20);
        factory.addCell(grid, CellType.WALL, 10, 20);
        factory.addCell(grid, CellType.WALL, 11, 20);
        factory.addCell(grid, CellType.WALL, 12, 20);
        factory.addCell(grid, CellType.DOOR, 13, 20, Color.GREEN);
        factory.addCell(grid, CellType.WALL, 14, 20);
        factory.addCell(grid, CellType.WALL, 15, 20);
        factory.addCell(grid, CellType.WALL, 16, 20);
        factory.addCell(grid, CellType.WALL, 17, 20);
        factory.addCell(grid, CellType.WALL, 18, 20);
        factory.addCell(grid, CellType.WALL, 19, 20);
        factory.addCell(grid, CellType.WALL, 20, 20);

        // bottom outlet
        factory.addCell(grid, CellType.WALL, 10, 21);
        factory.addCell(grid, CellType.WALL, 10, 22);
        factory.addCell(grid, CellType.WALL, 10, 23);
        factory.addCell(grid, CellType.WALL, 11, 23);
        factory.addCell(grid, CellType.WALL, 12, 23);
        factory.addCell(grid, CellType.WALL, 13, 23);
        factory.addCell(grid, CellType.WALL, 14, 23);
        factory.addCell(grid, CellType.WALL, 15, 23);
        factory.addCell(grid, CellType.WALL, 15, 22);
        factory.addCell(grid, CellType.WALL, 15, 21);

        // add key in bottom outlet
        factory.addCell(grid, CellType.KEY, 11, 22, Color.BLUE);

        // add chip in bottom outlet
        factory.addCell(grid, CellType.CHIP, 14, 22);

        // right side
        factory.addCell(grid, CellType.WALL, 20, 5);
        factory.addCell(grid, CellType.WALL, 20, 6);
        factory.addCell(grid, CellType.WALL, 20, 7);
        factory.addCell(grid, CellType.WALL, 20, 8);
        factory.addCell(grid, CellType.WALL, 20, 9);
        factory.addCell(grid, CellType.WALL, 20, 10);
        factory.addCell(grid, CellType.WALL, 20, 11);
        factory.addCell(grid, CellType.WALL, 20, 12);
        factory.addCell(grid, CellType.DOOR, 20, 13, Color.YELLOW);
        factory.addCell(grid, CellType.WALL, 20, 14);
        factory.addCell(grid, CellType.WALL, 20, 15);
        factory.addCell(grid, CellType.WALL, 20, 16);
        factory.addCell(grid, CellType.WALL, 20, 17);
        factory.addCell(grid, CellType.WALL, 20, 18);
        factory.addCell(grid, CellType.WALL, 20, 19);
        factory.addCell(grid, CellType.WALL, 20, 20);

        // right outlet
        factory.addCell(grid, CellType.WALL, 21, 10);
        factory.addCell(grid, CellType.WALL, 22, 10);
        factory.addCell(grid, CellType.WALL, 23, 10);
        factory.addCell(grid, CellType.WALL, 23, 11);
        factory.addCell(grid, CellType.WALL, 23, 12);
        factory.addCell(grid, CellType.WALL, 23, 13);
        factory.addCell(grid, CellType.WALL, 23, 14);
        factory.addCell(grid, CellType.WALL, 23, 15);
        factory.addCell(grid, CellType.WALL, 22, 15);
        factory.addCell(grid, CellType.WALL, 21, 15);

        // add fish in right outlet
        factory.addCell(grid, CellType.FISH, 22, 11);

        // add green key in right outlet
        factory.addCell(grid, CellType.KEY, 22, 14, Color.GREEN);

        // top
        factory.addCell(grid, CellType.WALL, 5, 5);
        factory.addCell(grid, CellType.WALL, 6, 5);
        factory.addCell(grid, CellType.WALL, 7, 5);
        factory.addCell(grid, CellType.WALL, 8, 5);
        factory.addCell(grid, CellType.WALL, 9, 5);
        factory.addCell(grid, CellType.WALL, 10, 5);
        factory.addCell(grid, CellType.WALL, 11, 5);
        factory.addCell(grid, CellType.WALL, 12, 5);
        factory.addCell(grid, CellType.DOOR, 13, 5, Color.BLUE);
        factory.addCell(grid, CellType.WALL, 14, 5);
        factory.addCell(grid, CellType.WALL, 15, 5);
        factory.addCell(grid, CellType.WALL, 16, 5);
        factory.addCell(grid, CellType.WALL, 17, 5);
        factory.addCell(grid, CellType.WALL, 18, 5);
        factory.addCell(grid, CellType.WALL, 19, 5);
        factory.addCell(grid, CellType.WALL, 20, 5);

        // top outlet
        factory.addCell(grid, CellType.WALL, 10, 4);
        factory.addCell(grid, CellType.WALL, 10, 3);
        factory.addCell(grid, CellType.WALL, 10, 2);
        factory.addCell(grid, CellType.WALL, 10, 1);
        factory.addCell(grid, CellType.WALL, 11, 1);
        factory.addCell(grid, CellType.WALL, 12, 1);
        factory.addCell(grid, CellType.WALL, 13, 1);
        factory.addCell(grid, CellType.WALL, 14, 1);
        factory.addCell(grid, CellType.WALL, 15, 1);
        factory.addCell(grid, CellType.WALL, 15, 2);
        factory.addCell(grid, CellType.WALL, 15, 3);
        factory.addCell(grid, CellType.WALL, 15, 4);

        // add water in top outlet
        factory.addCell(grid, CellType.WATER, 11, 3);
        factory.addCell(grid, CellType.WATER, 12, 3);
        factory.addCell(grid, CellType.WATER, 13, 3);
        factory.addCell(grid, CellType.WATER, 14, 3);
        factory.addCell(grid, CellType.WATER, 11, 4);
        factory.addCell(grid, CellType.WATER, 12, 4);
        factory.addCell(grid, CellType.WATER, 13, 4);
        factory.addCell(grid, CellType.WATER, 14, 4);

        // add chips in top outlet
        factory.addCell(grid, CellType.CHIP, 11, 2);
        factory.addCell(grid, CellType.CHIP, 14, 2);

        // add key in center area
        factory.addCell(grid, CellType.KEY, 18, 18, Color.RED);

        // add chip in center area
        factory.addCell(grid, CellType.CHIP, 7, 7);

        // add portal in center area
        factory.addCell(grid, CellType.WALL, 12, 12);
        factory.addCell(grid, CellType.WALL, 13, 12);
        factory.addCell(grid, CellType.WALL, 14, 12);
        factory.addCell(grid, CellType.WALL, 14, 13);
        factory.addCell(grid, CellType.WALL, 14, 14);
        factory.addCell(grid, CellType.PORTAL_GATE, 13, 14);
        factory.addCell(grid, CellType.WALL, 12, 14);
        factory.addCell(grid, CellType.WALL, 12, 13);
        factory.addCell(grid, CellType.PORTAL, 13, 13);

        // fill rest of grid in as open cells
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size(); j++) {
                if (grid.notSet(i, j)) {
                    factory.addCell(grid, CellType.OPEN, i, j);
                }
            }
        }

        addGridToView();

        Player player = Player.getInstance(13, 18);
        grid.setCell(player.getCell());
        root.getChildren().add(player.getImageView());

        return grid;
    }

    private Grid levelTwo() {

        // add walls

        // add left side
        factory.addCell(grid, CellType.WALL, 3, 6);
        factory.addCell(grid, CellType.WALL, 4, 6);
        factory.addCell(grid, CellType.WALL, 5, 7);
        factory.addCell(grid, CellType.WALL, 6, 7);

        factory.addCell(grid, CellType.WALL, 7, 8);
        factory.addCell(grid, CellType.WALL, 7, 9);
        factory.addCell(grid, CellType.WALL, 7, 10);
        factory.addCell(grid, CellType.WALL, 7, 11);
        factory.addCell(grid, CellType.WALL, 7, 12);
        factory.addCell(grid, CellType.WALL, 7, 13);

        // add bottom
        factory.addCell(grid, CellType.WALL, 8, 14);
        factory.addCell(grid, CellType.WALL, 9, 14);
        factory.addCell(grid, CellType.WALL, 10, 14);
        factory.addCell(grid, CellType.WALL, 11, 14);
        factory.addCell(grid, CellType.DOOR, 12, 14, Color.BLUE);
        factory.addCell(grid, CellType.WALL, 13, 14);
        factory.addCell(grid, CellType.WALL, 14, 14);

        // bottom triangle
        factory.addCell(grid, CellType.WALL, 8, 15);
        factory.addCell(grid, CellType.WALL, 8, 16);
        factory.addCell(grid, CellType.WALL, 8, 17);
        factory.addCell(grid, CellType.WALL, 8, 18);
        factory.addCell(grid, CellType.WALL, 9, 19);
        factory.addCell(grid, CellType.WALL, 10, 20);
        factory.addCell(grid, CellType.WALL, 11, 21);
        factory.addCell(grid, CellType.DOOR, 12, 22, Color.GREEN); // bottom point
        factory.addCell(grid, CellType.WALL, 13, 21);
        factory.addCell(grid, CellType.WALL, 14, 20);
        factory.addCell(grid, CellType.WALL, 15, 19);
        factory.addCell(grid, CellType.WALL, 16, 18);
        factory.addCell(grid, CellType.WALL, 16, 17);
        factory.addCell(grid, CellType.WALL, 16, 16);
        factory.addCell(grid, CellType.WALL, 16, 15);
        factory.addCell(grid, CellType.WALL, 16, 14);
        factory.addCell(grid, CellType.WALL, 16, 13);
        factory.addCell(grid, CellType.WALL, 16, 12);
        factory.addCell(grid, CellType.WALL, 16, 11);
        factory.addCell(grid, CellType.WALL, 16, 10);

        // right side
        factory.addCell(grid, CellType.WALL, 15, 14);
        factory.addCell(grid, CellType.WALL, 15, 13);
        factory.addCell(grid, CellType.WALL, 15, 12);
        factory.addCell(grid, CellType.WALL, 15, 11);
        factory.addCell(grid, CellType.WALL, 15, 10);
        factory.addCell(grid, CellType.WALL, 15, 9);
        factory.addCell(grid, CellType.WALL, 15, 8);
        factory.addCell(grid, CellType.WALL, 15, 7);
        factory.addCell(grid, CellType.DOOR, 15, 6, Color.YELLOW);
        factory.addCell(grid, CellType.WALL, 15, 5);
        factory.addCell(grid, CellType.WALL, 15, 4);
        factory.addCell(grid, CellType.WALL, 15, 3);
        factory.addCell(grid, CellType.WALL, 15, 2);

        // triangular outlet
        factory.addCell(grid, CellType.WALL, 16, 7);
        factory.addCell(grid, CellType.WALL, 17, 5);
        factory.addCell(grid, CellType.WALL, 17, 6);
        factory.addCell(grid, CellType.WALL, 18, 5);
        factory.addCell(grid, CellType.WALL, 19, 4);
        factory.addCell(grid, CellType.WALL, 19, 3);
        factory.addCell(grid, CellType.WALL, 19, 3);
        factory.addCell(grid, CellType.WALL, 19, 3);
        factory.addCell(grid, CellType.WALL, 18, 3);
        factory.addCell(grid, CellType.WALL, 17, 3);
        factory.addCell(grid, CellType.WALL, 16, 3);

        // across top
        factory.addCell(grid, CellType.WALL, 5, 5);
        factory.addCell(grid, CellType.WALL, 6, 4);
        factory.addCell(grid, CellType.WALL, 7, 4);
        factory.addCell(grid, CellType.WALL, 8, 4);
        factory.addCell(grid, CellType.WALL, 9, 3);
        factory.addCell(grid, CellType.WALL, 10, 4);
        factory.addCell(grid, CellType.WALL, 11, 5);
        factory.addCell(grid, CellType.WALL, 12, 4);
        factory.addCell(grid, CellType.WALL, 13, 3);
        factory.addCell(grid, CellType.WALL, 14, 2);
        factory.addCell(grid, CellType.WALL, 15, 1);

        // left interior triangle
        factory.addCell(grid, CellType.DOOR, 8, 7, Color.BLUE);
        factory.addCell(grid, CellType.WALL, 9, 6);
        factory.addCell(grid, CellType.WALL, 10, 5);

        // right interior triangle
        factory.addCell(grid, CellType.DOOR, 11, 5, Color.YELLOW);
        factory.addCell(grid, CellType.WALL, 12, 5);
        factory.addCell(grid, CellType.DOOR, 13, 5, Color.RED);
        factory.addCell(grid, CellType.WALL, 14, 5);

        // add water
        factory.addCell(grid, CellType.WATER, 9, 16);
        factory.addCell(grid, CellType.WATER, 10, 16);
        factory.addCell(grid, CellType.WATER, 11, 16);
        factory.addCell(grid, CellType.WATER, 12, 16);
        factory.addCell(grid, CellType.WATER, 13, 16);
        factory.addCell(grid, CellType.WATER, 14, 16);
        factory.addCell(grid, CellType.WATER, 15, 16);

        factory.addCell(grid, CellType.WATER, 9, 17);
        factory.addCell(grid, CellType.WATER, 10, 17);
        factory.addCell(grid, CellType.WATER, 11, 17);
        factory.addCell(grid, CellType.WATER, 12, 17);
        factory.addCell(grid, CellType.WATER, 13, 17);
        factory.addCell(grid, CellType.WATER, 14, 17);
        factory.addCell(grid, CellType.WATER, 15, 17);

        factory.addCell(grid, CellType.WATER, 10, 19);
        factory.addCell(grid, CellType.WATER, 11, 19);
        factory.addCell(grid, CellType.WATER, 12, 19);
        factory.addCell(grid, CellType.WATER, 13, 19);
        factory.addCell(grid, CellType.WATER, 14, 19);

        factory.addCell(grid, CellType.WATER, 11, 20);
        factory.addCell(grid, CellType.WATER, 12, 20);
        factory.addCell(grid, CellType.WATER, 13, 20);

        // add portal
        factory.addCell(grid, CellType.PORTAL, 18, 4);

        // add portal gate
        factory.addCell(grid, CellType.PORTAL_GATE, 17, 4);

        // add key
        factory.addCell(grid, CellType.KEY, 9, 11, Color.BLUE);
        factory.addCell(grid, CellType.KEY, 5, 6, Color.RED);
        factory.addCell(grid, CellType.KEY, 14, 3, Color.YELLOW);
        factory.addCell(grid, CellType.KEY, 11, 3, Color.GREEN);
        factory.addCell(grid, CellType.KEY, 2, 17, Color.YELLOW);
        factory.addCell(grid, CellType.KEY, 12, 15, Color.BLUE);

        // add chips
        factory.addCell(grid, CellType.CHIP, 9, 15);
        factory.addCell(grid, CellType.CHIP, 14, 8);
        factory.addCell(grid, CellType.CHIP, 15, 18);
        factory.addCell(grid, CellType.CHIP, 12, 21);
        factory.addCell(grid, CellType.CHIP, 9, 4);

        // add fish
        factory.addCell(grid, CellType.FISH, 3, 2);

        // fill rest of grid in as open cells
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size(); j++) {
                if (grid.notSet(i, j)) {
                    factory.addCell(grid, CellType.OPEN, i, j);
                }
            }
        }

        addGridToView();
        addPlayer(11, 12);

        return grid;
    }

    private void addGridToView() {
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size(); j++) {
                root.getChildren().add(grid.getCell(i, j).getImageView());
            }
        }
    }

    private void addPlayer(final int i, final int j) {
        Player player = Player.getInstance(11, 12);
        grid.setCell(player.getCell());
        root.getChildren().add(player.getImageView());
    }
}
