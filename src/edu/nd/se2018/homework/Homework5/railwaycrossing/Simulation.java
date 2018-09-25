import java.util.ArrayList;
import java.util.Collection;

import model.infrastructure.Direction;
import model.infrastructure.MapBuilder;
import model.infrastructure.RailwayTracks;
import model.infrastructure.Road;
import model.infrastructure.gate.CrossingGate;
import model.vehicles.Car;
import model.vehicles.Train;
import model.vehicles.TrainFactory;
import view.MapDisplay;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Simulation extends Application{
	
	private Pane root;
	private Scene scene;
	private MapBuilder mapBuilder;
	private MapDisplay mapDisplay;
	private TrainFactory trainFactory;
	
	@Override  
	public void start(Stage stage) throws Exception {
		
		root = new Pane();
		
		// Build infrastructure
		mapBuilder = new MapBuilder();
		mapDisplay = new MapDisplay(root, mapBuilder.getRoads(), mapBuilder.getTracks(),mapBuilder.getAllGates());					
		mapDisplay.drawTracks();		
		mapDisplay.drawRoad();
		mapDisplay.drawGate();
		
		scene = new Scene(root,1200,1000);
		stage.setTitle("Railways");
		stage.setScene(scene);
		stage.show();

		trainFactory = new TrainFactory();

		// Create trains
		createTrain("Royal", 100, 25, Direction.WEST); // east to west
		createTrain("Regal", 350, 25, Direction.EAST); // west to east

		for (CrossingGate gate: mapBuilder.getAllGates()) {
			trainFactory.addObserver(gate);
		}
				
		// Sets up a repetitive loop i.e., in handle that runs the actual simulation
		new AnimationTimer(){

			@Override
			public void handle(long now) {
			
				createCar();
				trainFactory.move();
				
				for(CrossingGate gate: mapBuilder.getAllGates()) {
					gate.operateGate();
				}

				trainFactory.checkOffscreen();
				clearCars();				
			}
		}.start();
	}
	
	// Clears cars as they leave the simulation
	private void clearCars(){
		Collection<Road> roads = mapBuilder.getRoads();
		for (Road road: roads){
			ArrayList<Car> junkCars = road.moveCars();
			mapDisplay.removeCarImages(junkCars);
		}
	}
	
	private void createCar(){
		Collection<Road> roads = mapBuilder.getRoads();
		for(Road road: roads){
			if (road.getCarFactory() != null){
				if ((int)(Math.random() * 150) == 15){
					Car car = road.getCarFactory().buildCar();
					if (car != null){
						road.addCar(car);
						root.getChildren().add(car.getImageView());
					}
				}
			}
		}
	}

	private void createTrain(String trackName, int startX, int startY, Direction direction) {
		RailwayTracks track = mapBuilder.getTrack(trackName);
		Train train = new Train(track.getEndX()+startX,track.getEndY()-startY, direction);
		root.getChildren().add(train.getImageView());
		trainFactory.addTrain(train);
	}
	
	public static void main(String[] args){
		launch(args);
	}
}

