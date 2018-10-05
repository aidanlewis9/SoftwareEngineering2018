package utilities;

public enum Orientation {
    UP("Up"),
    RIGHT("Right"),
    DOWN("Down"),
    LEFT("Left");

    private final String str;

    private Orientation(String str) {
        this.str = str;
    }

    public String getString() {
        return str;
    }
}
