public class SlowStartStrategy implements JockeyStrategy {
    public float getSpeed(final int maxSpeed, final float distance) {
        if (distance < 6) {
            return maxSpeed * (float) 0.75;
        } else if (distance < 9) {
            return maxSpeed * (float) 0.9;
        } else {
            return maxSpeed;
        }
    }
}
