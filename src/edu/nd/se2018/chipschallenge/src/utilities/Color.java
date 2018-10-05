package utilities;

public enum Color {
    RED("red"),
    BLUE("blue"),
    GREEN("green"),
    YELLOW("yellow");

    private final String str;

    private Color(String str) {
        this.str = str;
    }

    public String getString() {
        return str;
    }
}
