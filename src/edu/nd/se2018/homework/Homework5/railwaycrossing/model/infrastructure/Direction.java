package model.infrastructure;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    private static Direction[] allValues = values();
    public static Direction fromOrdinal(int n) {return allValues[n];}
}
