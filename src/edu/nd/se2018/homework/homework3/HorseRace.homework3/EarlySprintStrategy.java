

public class EarlySprintStrategy implements JockeyStrategy {
    public float getSpeed(final int maxSpeed, final float distance) {
        if (distance < 2) {
            return maxSpeed;
        } else {
            return maxSpeed * (float) 0.75;
        }
    }
}
