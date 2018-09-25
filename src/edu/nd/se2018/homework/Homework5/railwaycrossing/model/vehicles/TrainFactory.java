package model.vehicles;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class TrainFactory extends Observable {
    List<Train> trains = new ArrayList<>();

    public void addTrain(Train newTrain) {
        trains.add(newTrain);
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void move() {
        for (Train train : trains) {
            train.move();
        }
        setChanged();
        notifyObservers();
    }

    public void checkOffscreen() {
        for (Train train : trains) {
            if (train.offScreen())
                train.reset();
        }
    }
}
