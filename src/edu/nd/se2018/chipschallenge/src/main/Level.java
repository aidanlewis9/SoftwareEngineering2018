package main;

import cells.*;
import utilities.Color;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

public class Level {

    private Grid grid;
    private Pane root;

    public Level(Pane root) {
        grid = Grid.getInstance();
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
        addWall(5, 5);
        addWall(5, 6);
        addWall(5, 7);
        addWall(5, 8);
        addWall(5, 9);
        addWall(5, 10);
        addWall(5, 11);
        addWall(5, 12);
        addDoor(5, 13, Color.RED);
        addWall(5, 14);
        addWall(5, 15);
        addWall(5, 16);
        addWall(5, 17);
        addWall(5, 18);
        addWall(5, 19);
        addWall(5, 20);

        // left outlet
        addWall(4, 10);
        addWall(3, 10);
        addWall(2, 10);
        addWall(1, 10);
        addWall(1, 11);
        addWall(1, 12);
        addWall(1, 13);
        addWall(1, 14);
        addWall(1, 15);
        addWall(2, 15);
        addWall(3, 15);
        addWall(4, 15);

        // add key in left outlet
        addKey(2, 14, Color.YELLOW);

        // add chip in left outlet
        addChip(2, 11);

        // bottom
        addWall(5, 20);
        addWall(6, 20);
        addWall(7, 20);
        addWall(8, 20);
        addWall(9, 20);
        addWall(10, 20);
        addWall(11, 20);
        addWall(12, 20);
        addDoor(13, 20, Color.GREEN);
        addWall(14, 20);
        addWall(15, 20);
        addWall(16, 20);
        addWall(17, 20);
        addWall(18, 20);
        addWall(19, 20);
        addWall(20, 20);

        // bottom outlet
        addWall(10, 21);
        addWall(10, 22);
        addWall(10, 23);
        addWall(11, 23);
        addWall(12, 23);
        addWall(13, 23);
        addWall(14, 23);
        addWall(15, 23);
        addWall(15, 22);
        addWall(15, 21);

        // add key in bottom outlet
        addKey(11, 22, Color.BLUE);

        // add chip in bottom outlet
        addChip(14, 22);

        // right side
        addWall(20, 5);
        addWall(20, 6);
        addWall(20, 7);
        addWall(20, 8);
        addWall(20, 9);
        addWall(20, 10);
        addWall(20, 11);
        addWall(20, 12);
        addDoor(20, 13, Color.YELLOW);
        addWall(20, 14);
        addWall(20, 15);
        addWall(20, 16);
        addWall(20, 17);
        addWall(20, 18);
        addWall(20, 19);
        addWall(20, 20);

        // right outlet
        addWall(21, 10);
        addWall(22, 10);
        addWall(23, 10);
        addWall(23, 11);
        addWall(23, 12);
        addWall(23, 13);
        addWall(23, 14);
        addWall(23, 15);
        addWall(22, 15);
        addWall(21, 15);

        // add fish in right outlet
        addFish(22, 11);

        // add green key in right outlet
        addKey(22, 14, Color.GREEN);

        // top
        addWall(5, 5);
        addWall(6, 5);
        addWall(7, 5);
        addWall(8, 5);
        addWall(9, 5);
        addWall(10, 5);
        addWall(11, 5);
        addWall(12, 5);
        addDoor(13, 5, Color.BLUE);
        addWall(14, 5);
        addWall(15, 5);
        addWall(16, 5);
        addWall(17, 5);
        addWall(18, 5);
        addWall(19, 5);
        addWall(20, 5);

        // top outlet
        addWall(10, 4);
        addWall(10, 3);
        addWall(10, 2);
        addWall(10, 1);
        addWall(11, 1);
        addWall(12, 1);
        addWall(13, 1);
        addWall(14, 1);
        addWall(15, 1);
        addWall(15, 2);
        addWall(15, 3);
        addWall(15, 4);

        // add water in top outlet
        addWater(11, 3);
        addWater(12, 3);
        addWater(13, 3);
        addWater(14, 3);
        addWater(11, 4);
        addWater(12, 4);
        addWater(13, 4);
        addWater(14, 4);

        // add chips in top outlet
        addChip(11, 2);
        addChip(14, 2);

        // add key in center area
        addKey(18, 18, Color.RED);

        // add chip in center area
        addChip(7, 7);

        // add portal in center area
        addWall(12, 12);
        addWall(13, 12);
        addWall(14, 12);
        addWall(14, 13);
        addWall(14, 14);
        addPortalGate(13, 14);
        addWall(12, 14);
        addWall(12, 13);
        addPortal(13, 13);

        // fill rest of grid in as open cells
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size(); j++) {
                if (grid.notSet(i, j)) {
                    addOpen(i, j);
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
        addWall(3, 6);
        addWall(4, 6);
        addWall(5, 7);
        addWall(6, 7);

        addWall(7, 8);
        addWall(7, 9);
        addWall(7, 10);
        addWall(7, 11);
        addWall(7, 12);
        addWall(7, 13);

        // add bottom
        addWall(8, 14);
        addWall(9, 14);
        addWall(10, 14);
        addWall(11, 14);
        addDoor(12, 14, Color.BLUE);
        addWall(13, 14);
        addWall(14, 14);

        // bottom triangle
        addWall(8, 15);
        addWall(8, 16);
        addWall(8, 17);
        addWall(8, 18);
        addWall(9, 19);
        addWall(10, 20);
        addWall(11, 21);
        addDoor(12, 22, Color.GREEN); // bottom point
        addWall(13, 21);
        addWall(14, 20);
        addWall(15, 19);
        addWall(16, 18);
        addWall(16, 17);
        addWall(16, 16);
        addWall(16, 15);
        addWall(16, 14);
        addWall(16, 13);
        addWall(16, 12);
        addWall(16, 11);
        addWall(16, 10);

        // right side
        addWall(15, 14);
        addWall(15, 13);
        addWall(15, 12);
        addWall(15, 11);
        addWall(15, 10);
        addWall(15, 9);
        addWall(15, 8);
        addWall(15, 7);
        addDoor(15, 6, Color.YELLOW);
        addWall(15, 5);
        addWall(15, 4);
        addWall(15, 3);
        addWall(15, 2);

        // triangular outlet
        addWall(16, 7);
        addWall(17, 5);
        addWall(17, 6);
        addWall(18, 5);
        addWall(19, 4);
        addWall(19, 3);
        addWall(19, 3);
        addWall(19, 3);
        addWall(18, 3);
        addWall(17, 3);
        addWall(16, 3);

        // across top
        addWall(5, 5);
        addWall(6, 4);
        addWall(7, 4);
        addWall(8, 4);
        addWall(9, 3);
        addWall(10, 4);
        addWall(11, 5);
        addWall(12, 4);
        addWall(13, 3);
        addWall(14, 2);
        addWall(15, 1);

        // left interior triangle
        addDoor(8, 7, Color.BLUE);
        addWall(9, 6);
        addWall(10, 5);

        // right interior triangle
        addDoor(11, 5, Color.YELLOW);
        addWall(12, 5);
        addDoor(13, 5, Color.RED);
        addWall(14, 5);

        // add water
        addWater(9, 16);
        addWater(10, 16);
        addWater(11, 16);
        addWater(12, 16);
        addWater(13, 16);
        addWater(14, 16);
        addWater(15, 16);

        addWater(9, 17);
        addWater(10, 17);
        addWater(11, 17);
        addWater(12, 17);
        addWater(13, 17);
        addWater(14, 17);
        addWater(15, 17);

        addWater(10, 19);
        addWater(11, 19);
        addWater(12, 19);
        addWater(13, 19);
        addWater(14, 19);

        addWater(11, 20);
        addWater(12, 20);
        addWater(13, 20);

        // add portal
        addPortal(18, 4);

        // add portal gate
        addPortalGate(17, 4);

        // add key
        addKey(9, 11, Color.BLUE);
        addKey(5, 6, Color.RED);
        addKey(14, 3, Color.YELLOW);
        addKey(11, 3, Color.GREEN);
        addKey(2, 17, Color.YELLOW);
        addKey(12, 15, Color.BLUE);

        // add chips
        addChip(9, 15);
        addChip(14, 8);
        addChip(15, 18);
        addChip(12, 21);
        addChip(9, 4);

        // add fish
        addFish(3, 2);

        // fill rest of grid in as open cells
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size(); j++) {
                if (grid.notSet(i, j)) {
                    addOpen(i, j);
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

    private void addWall(final int i, final int j) {
        grid.setCell(new WallCell(i, j));
    }

    private void addWater(final int i, final int j) {
        grid.setCell(new WaterCell(i, j));
    }

    private void addPortal(final int i, final int j) {
        grid.setCell(new PortalCell(i, j));
    }

    private void addOpen(final int i, final int j) {
        grid.setCell(new OpenCell(i, j));
    }

    private void addDoor(final int i, final int j, final Color color) {
        grid.setCell(new DoorCell(i, j, color));
    }

    private void addKey(final int i, final int j, final Color color) {
        grid.setCell(new KeyCell(i, j, color));
    }

    private void addChip(final int i, final int j) {
        grid.setCell(new ChipCell(i, j));
    }

    private void addFish(final int i, final int j) {
        grid.setCell(new FishCell(i, j));
    }

    private void addPortalGate(final int i, final int j) {
        grid.setCell(new PortalGateCell(i, j));
    }

    private void addPlayer(final int i, final int j) {
        Player player = Player.getInstance(11, 12);
        grid.setCell(player.getCell());
        root.getChildren().add(player.getImageView());
    }
}
