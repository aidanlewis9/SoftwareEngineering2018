package edu.nd.se2018.homework.homework3;

import org.junit.Test;

public class HorseTest {

    @Test
    public void testConstructor() {
        final Horse horse = new Horse("Joe",2,25, new EarlySprintStrategy());

        assert("Joe" == horse.getName());
        assert(2 == horse.getNumber());
        assert(25 == horse.getMaxSpeed());
        assert(0 == horse.getDistance());
    }

    @Test
    public void testUpdate1() {
        final Horse horse = new Horse("Joe",2,25, new EarlySprintStrategy());

        horse.update();
        assert(0.5f == horse.getDistance());

        horse.update();
        assert(1.0f == horse.getDistance());

        horse.update();
        assert(1.5f == horse.getDistance());
    }

    @Test
    public void testUpdate2() {
        final Horse horse = new Horse("Flicker",4,25,new SteadyRunStrategy());

        horse.update();
        assert(0.4f == horse.getDistance());

        horse.update();
        assert(0.8f == horse.getDistance());

        horse.update();
        assert(1.2f == horse.getDistance());
    }
}
