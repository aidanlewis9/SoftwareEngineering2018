package edu.nd.se2018.homework.homework3;

import org.junit.Test;

public class RaceTest {
    @Test
    public void testEnrollHorse() {
        final Race race = new Race();
        race.enrollHorse("Jim",0,22,new EarlySprintStrategy());
        race.enrollHorse("Maddy",1,24,new SlowStartStrategy());

        assert(race.getHorses().size() == 2);

        // check Jim
        assert(race.getHorses().get(0).getName() == "Jim");
        assert(race.getHorses().get(0).getNumber() == 0);
        assert(race.getHorses().get(0).getMaxSpeed() == 22);
        assert(race.getHorses().get(0).getDistance() == 0);

        // check Maddy
        assert(race.getHorses().get(1).getName() == "Maddy");
        assert(race.getHorses().get(1).getNumber() == 1);
        assert(race.getHorses().get(1).getMaxSpeed() == 24);
        assert(race.getHorses().get(1).getDistance() == 0);
    }

    @Test
    public void testRace1() throws InterruptedException {
        Race race = new Race();
        race.enrollHorse("Sam",0,22,new EarlySprintStrategy());
        race.enrollHorse("Molly",1,24,new SlowStartStrategy());
        race.enrollHorse("Joe",2,25,new EarlySprintStrategy());
        race.enrollHorse("Blizzard",3,25,new SlowStartStrategy());
        race.enrollHorse("Flicker",4,25,new SteadyRunStrategy());

        final Horse winner = race.start();
        assert(winner == race.getHorses().get(3));
    }

    @Test
    public void testRace2() throws InterruptedException {
        Race race = new Race();
        race.enrollHorse("Sam",0,22,new EarlySprintStrategy());
        race.enrollHorse("Molly",1,22,new EarlySprintStrategy());

        final Horse winner = race.start();
        assert(winner == race.getHorses().get(0));
    }

    @Test
    public void testRace3() throws InterruptedException {
        Race race = new Race();
        race.enrollHorse("Sam",0,100,new EarlySprintStrategy());
        race.enrollHorse("Molly",1,100,new SlowStartStrategy());

        final Horse winner = race.start();
        assert(winner == race.getHorses().get(1));
    }
}
