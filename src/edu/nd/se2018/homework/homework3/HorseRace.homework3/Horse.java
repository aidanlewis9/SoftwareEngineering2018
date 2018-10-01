

public class Horse {
    private final float DISTANCE_MODIFIER = 50f;

    private final String name;
    private final int number;
    private final int maxSpeed;
    private float distance;
    private JockeyStrategy jockeyStrategy;

    public Horse(final String name, final int number, final int maxSpeed, final JockeyStrategy jockeyStrategy) {
        this.name = name;
        this.number = number;
        this.maxSpeed = maxSpeed;
        this.distance = 0;
        this.jockeyStrategy = jockeyStrategy;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public float getDistance() {
        return distance;
    }

    public void resetJockeyStrategy(final JockeyStrategy newJockeyStrategy) {
        this.jockeyStrategy = newJockeyStrategy;
    }

    public void update() {
        final float currentSpeed = jockeyStrategy.getSpeed(maxSpeed, distance);
        distance += (currentSpeed / DISTANCE_MODIFIER);

        display();
    }

    private void display() {
        final float displayDistance = (distance <= 10) ? distance : 10.0f;
        System.out.println(String.format("%s has run %.1f miles", name, displayDistance));
    }

}
