package cells;

import main.Grid;
import main.Player;
import utilities.Color;

public class CellFactory {

    public void addCell(Grid grid, CellType type, int i, int j) {

        switch (type) {
            case CHIP:
                grid.setCell(new Chip(i, j));
                break;
            case FISH:
                grid.setCell(new Fish(i, j));
                break;
            case OPEN:
                grid.setCell(new Open(i, j));
                break;
            case PORTAL:
                grid.setCell(new Portal(i, j));
                break;
            case PORTAL_GATE:
                grid.setCell(new PortalGate(i, j));
                break;
            case WALL:
                grid.setCell(new Wall(i, j));
                break;
            case WATER:
                grid.setCell(new Water(i, j));
                break;
        }
    }

    public void addCell(Grid grid, CellType type, int i, int j, Color color) {

        switch (type) {
            case DOOR:
                grid.setCell(new Door(i, j, color));
                break;
            case KEY:
                grid.setCell(new Key(i, j, color));
                break;
        }
    }

}
