

import java.util.ArrayList;
import java.util.List;

public class Race {
    private static final float FINISH_LINE = 10f;

    private final List<Horse> horses;

    public Race() {
        horses = new ArrayList<>();
    }

    public void enrollHorse(final String name, final int number, final int maxSpeed, final JockeyStrategy strategy) {
        horses.add(new Horse(name, number, maxSpeed, strategy));
    }

    public void declareWinner(final Horse winner) {
        System.out.println(String.format("Winner is %s", winner.getName()));
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Horse start() throws InterruptedException {
        boolean raceOver = false;
        Horse winner = null;

        while (!raceOver) {
            for (final Horse horse : horses) {
                horse.update();

                if (horse.getDistance() > FINISH_LINE && (winner == null || winner.getDistance() < horse.getDistance())) {
                    raceOver = true;
                    winner = horse;
                }
            }

            Thread.sleep(300);
            System.out.println();
        }

        declareWinner(winner);

        return winner;
    }


}
