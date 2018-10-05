package main;

import cells.Cell;
import cells.OpenCell;
import cells.PlayerCell;
import cells.WaterCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import utilities.Color;
import utilities.Orientation;
import utilities.State;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int GRID_DIMENSIONS = 25;

    private static Player player;

    private Point position;
    private PlayerCell cell;
    private List<Color> keys;
    private boolean canSwim;
    private State state;

    public Player(final int x, final int y) {
        position = new Point(x, y);
        keys = new ArrayList<>();
        canSwim = false;
        state = State.LAND;

        cell = new PlayerCell(position.x, position.y, Orientation.UP, state);

    }

    public static Player getInstance(final int x, final int y) {
        player = new Player(x, y);
        return player;
    }

    public static Player getInstance() {
        return player;
    }

    public ImageView getImageView(){
        return cell.getImageView();
    }

    public PlayerCell getCell() {
        return cell;
    }

    public Point getPosition() {
        return position;
    }

    public State move(Pane root, KeyEvent ke) {
        Grid grid = Grid.getInstance();

        root.getChildren().remove(player.getImageView());

        // add open cell where player used to be
        root.getChildren().remove(grid.getCell(position.x, position.y).getImageView());

        if (state == State.LAND) {
            grid.setCell(new OpenCell(position.x, position.y));
        } else {
            grid.setCell(new WaterCell(position.x, position.y));
        }


        root.getChildren().add(grid.getCell(position.x, position.y).getImageView());

        Orientation orientation = Orientation.UP;

        switch (ke.getCode()) {
            case RIGHT:
                position = goEast(grid);
                orientation = Orientation.RIGHT;
                break;
            case LEFT:
                position = goWest(grid);
                orientation = Orientation.LEFT;
                break;
            case UP:
                position = goNorth(grid);
                orientation = Orientation.UP;
                break;
            case DOWN:
                position = goSouth(grid);
                orientation = Orientation.DOWN;
                break;
        }

        toggleState();

        // set new player location
        grid.setCell(new PlayerCell(position.x, position.y, orientation, state));
        root.getChildren().add(grid.getCell(position.x, position.y).getImageView());

        return state;
    }

    private Point goEast(Grid grid) {

        if (position.x + 1 < GRID_DIMENSIONS && grid.getCell(position.x + 1, position.y).canEnter()) {
            return new Point(position.x + 1, position.y);
        } else {
            return position;
        }
    }

    private Point goWest(Grid grid) {
        if (position.x - 1 >= 0 && grid.getCell(position.x - 1, position.y).canEnter()) {
            return new Point(position.x - 1, position.y);
        } else {
            return position;
        }
    }

    private Point goNorth(Grid grid) {
        if (position.y - 1 >= 0 && grid.getCell(position.x, position.y - 1).canEnter()) {
            return new Point(position.x, position.y - 1);
        } else {
            return position;
        }
    }

    private Point goSouth(Grid grid) {
        if (position.y + 1 < GRID_DIMENSIONS && grid.getCell(position.x, position.y + 1).canEnter()) {
            return new Point(position.x, position.y + 1);
        } else {
            return position;
        }
    }

    public void takeKey(Color key) {
        keys.add(key);
    }

    private boolean hasKey(Color key) {
        return keys.contains(key);
    }

    // returns true upon successful use of key
    public boolean useKey(Color key) {
        if (hasKey(key)) {
            keys.remove(key);
            return true;
        }

        return false;
    }

    public boolean canSwim() {
        return canSwim;
    }

    public void takeFish() {
        canSwim = true;
    }

    private void toggleState() {
        Cell cell = Grid.getInstance().getCell(position.x, position.y);

        if (cell.isDeadly()) {
            state = State.DEAD;
        } else if (cell.hasWon()) {
            state = State.WON;
        } else if (cell.isLand()) {
            state = State.LAND;
        } else {
            state = State.WATER;
        }
    }

    public State getState() {
        return state;
    }

    public String getKeyString() {
        String text = "";

        for (Color key : keys) {
            text += key.getString() + ", ";
        }

        if (text.length() != 0) {
            text = text.substring(0, text.length() - 2);
        }

        return text;
    }
}

