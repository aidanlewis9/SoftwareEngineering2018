package main;

import cells.*;

public class Grid {

    private static final int GRID_DIMENSIONS = 25;

    private static Grid grid;
    private CellBehavior cells[][];
    private int chipsRemaining;

    public Grid() {
        cells = new CellBehavior[GRID_DIMENSIONS][GRID_DIMENSIONS];
    }

    public static Grid getInstance() {
        if (grid == null) {
            grid = new Grid();
        }

        return grid;
    }

    public int size() {
        return GRID_DIMENSIONS;
    }

    public void setCell(final CellBehavior cell) {
        cells[cell.getX()][cell.getY()] = cell;
    }

    public CellBehavior getCell(final int i, final int j) {
        return cells[i][j];
    }

    public boolean notSet(final int i, final int j) {
        return (getCell(i, j) == null);
    }

    public void takeChip() {
        chipsRemaining--;
    }

    public void incrementChips() {
        chipsRemaining++;
    }

    public boolean allChipsTaken() {
        return chipsRemaining == 0;
    }

    public int getChipsRemaining() {
        return chipsRemaining;
    }

    public void clear() {
        grid = new Grid();
    }
}
