

import org.junit.Test;

public class JockeyStrategyTest {

    @Test
    public void testEarlySprintStrategy() {
        final JockeyStrategy jockeyStrategy = new EarlySprintStrategy();
        final float speed1 = jockeyStrategy.getSpeed(10, 0.0f);
        assert(speed1 == 10.0f);

        final float speed2 = jockeyStrategy.getSpeed(87, 6.7f);
        assert(speed2 == 65.25f);
    }

    @Test
    public void testSlowStartStrategy() {
        final JockeyStrategy jockeyStrategy = new SlowStartStrategy();
        final float speed1 = jockeyStrategy.getSpeed(10, 0.0f);
        assert(speed1 == 7.5f);

        final float speed2 = jockeyStrategy.getSpeed(87, 6.7f);
        assert(speed2 == 78.299995f);
    }

    @Test
    public void testSteadyRunStrategy() {
        final JockeyStrategy jockeyStrategy = new SteadyRunStrategy();
        final float speed1 = jockeyStrategy.getSpeed(10, 0.0f);
        assert(speed1 == 8.0f);

        final float speed2 = jockeyStrategy.getSpeed(87, 6.7f);
        assert(speed2 == 69.6f);
    }

}
