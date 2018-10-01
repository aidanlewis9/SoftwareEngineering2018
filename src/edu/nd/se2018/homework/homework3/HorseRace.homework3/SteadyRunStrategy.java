public class SteadyRunStrategy implements JockeyStrategy {
    public float getSpeed(final int maxSpeed, final float distance) {
        return maxSpeed * (float) 0.8;
    }
}
