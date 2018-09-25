package model.infrastructure;

import java.awt.Point;
import java.util.*;

import model.infrastructure.gate.CrossingGate;
import model.vehicles.Car;
import model.vehicles.CarFactory;

/**
 * Represents a single road
 * @author jane
 *
 */
public class Road {
	private int startX;
	private int endX;
	private int startY;
	private int endY;

	private List<Road> intersections;
	private CarFactory carFactory;
	private Deque<Car> cars;
	private Random roadPicker;
	Direction direction;
	Collection<CrossingGate> gates;

	boolean clearEnds = false;
	int roadSize;
	
	public Road(){}
	
	public Road(Point start, Point end, Direction direction, boolean buildCarFactory, boolean clearEnds){
		startX = start.x;
		startY = start.y;
		endX = end.x;
		endY = end.y;
		roadSize = 18;
		intersections = new ArrayList<>();
		
		this.direction = direction;
		gates = new Vector<>();
		this.clearEnds = clearEnds;
		roadPicker = new Random();
		cars = new ArrayDeque<>();

		if (buildCarFactory) {
			addCarFactory();
		}
		
	}

	public void addIntersection(Road intersection) {
		intersections.add(intersection);
	}
	
	// Adds a gate to a road
	// In case a new gate is added after the factory is assigned, we reassign factory
	// The factory needs to know all gates on the road in order to register each car as an observer.
	public void assignGate(CrossingGate gate){
		gates.add(gate);
		if (carFactory != null)
			carFactory = new CarFactory(direction, new Point(startX-roadSize/2,startY), gates);  // allows additional gates.  Needs fixing
	}
	
	public void addCarFactory(){
		if (carFactory == null) // We only allow one
			carFactory = new CarFactory(direction, new Point(startX-roadSize/2,startY), gates);
	}
	
	public CarFactory getCarFactory(){
		return carFactory;
	}
	
	public int getStartX(){
		return startX;
	}
	
	public int getEndX(){
		return endX;
	}
	
	public int getStartY(){
		return startY;
	}
	
	public int getEndY(){
		return endY;
	} 
	
	public Direction getDirection(){
		return direction;
	}
	
	public boolean getClearEnds(){
		return clearEnds;
	}
	
	public int getRoadWidth(){
		return roadSize;
	}

	private boolean offRoad(Car car) {
		if (direction == Direction.SOUTH) {
			return car.getVehicleY() > getEndY() - 10;
		} else if (direction == Direction.WEST) {
			return car.getVehicleX() < getStartX() - 22;
		} else {
			return true;
		}
	}

	public ArrayList<Car> moveCars() {
		ArrayList<Car> toDelete = new ArrayList<>();

		if (!cars.isEmpty()) {
			cars.peekFirst().go();

			// move every car on the road
			for (Car car : cars) {
				car.move();
			}

			// remove cars that have reached the end of this road
			while (!cars.isEmpty() && offRoad(cars.peekFirst())) {
				Car car = cars.poll();

				if (intersections.size() > 0) { // go to next road
					Road nextRoad = getNextRoad();
					nextRoad.addCar(car);
				} else { // no more roads, so delete
					car.deleteObservers();
					toDelete.add(car);
				}
			}
		}

		return toDelete;
	}

	private Road getNextRoad() {
		int index = roadPicker.nextInt(intersections.size());
		return intersections.get(index);
	}

	public void addCar(Car car) {
		car.setDirection(this.direction);
		car.deleteObservers();

		if (!cars.isEmpty()) {
			cars.getLast().addObserver(car); // observes car ahead of it
		}

		cars.add(car);
	}
}