package model.vehicles;

import java.util.Observable;
import java.util.Observer;

import model.infrastructure.Direction;
import model.infrastructure.gate.CrossingGate;
import view.CarImageSelector;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * Represents Car object
 * @author jane
 *
 */
public class Car extends Observable implements IVehicle, Observer{
	private static final int GATE_START = 390;
	private static final int GATE_END = 430;
	private static final int FOLLOWING_DISTANCE = 50;
	private static final int MAX_ONSCREEN_Y = 1020;
	private static final String STOP_TRAFFIC_COMMAND = "STOP";

	private ImageView ivCar;
	private double currentX = 0;
	private double currentY = 0;
	private double originalY = 0;
	private boolean gateDown = false;
	private double speed = 0.5;
	private Direction direction = null;
	private boolean stopped = false;

		
	/**
	 * Constructor
	 * @param x initial x coordinate of car
	 * @param y initial y coordinate of car
	 */
	public Car(int x, int y){
		this.currentX = x;
		this.currentY = y;
		originalY = y;
		ivCar = new ImageView(CarImageSelector.getImage());
		ivCar.setX(getVehicleX());
		ivCar.setY(getVehicleY());
	}
		
	@Override
	public Node getImageView() {
		return ivCar;
	}
	
	public double getVehicleX(){
		return currentX;
	}
	public double getVehicleY(){
		return currentY;
	}

	public void go() {
		stopped = false;
	}
	
	public void move(){

		// First case.  Car is at the front of the stopping line.
		if (nearClosedGate()) {
			stopped = true;
		}

		if (!stopped) {
			if (direction == Direction.SOUTH) {
				currentY+=speed;
				ivCar.setY(currentY);
			} else if (direction == Direction.WEST) {
				currentX-=speed;
				ivCar.setX(currentX);
			}
		}

		setChanged();
		notifyObservers();
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public void setGateDownFlag(boolean gateDown){
		this.gateDown = gateDown;
	}
	
	public boolean offScreen(){
		if (currentY > MAX_ONSCREEN_Y)
			return true;
		else
			return false;			
	}
		
	public void reset(){
		currentY = originalY;
	}

	private boolean nearClosedGate() {
		return (gateDown && getVehicleY() < GATE_END && getVehicleY() > GATE_START);
	}

	private boolean closeToNextCar(Car carAhead) {
		if (direction == Direction.NORTH || direction == Direction.SOUTH) {
			return (Math.abs(carAhead.getVehicleY() - getVehicleY()) < FOLLOWING_DISTANCE);
		} else {
			return (Math.abs(carAhead.getVehicleX() - getVehicleX()) < FOLLOWING_DISTANCE);
		}
	}

	private boolean onScreen(Car carAhead) {
		return (carAhead.getVehicleY() < MAX_ONSCREEN_Y);
	}

	@Override
	public void update(Observable o, Object arg1) {
		if (o instanceof Car){
			updateCar((Car) o);
		} else if (o instanceof CrossingGate){
			updateCrossingGate((CrossingGate) o);
		}				
	}

	private void updateCar(Car carAhead) {
		if (closeToNextCar(carAhead) && onScreen(carAhead)) {
			stopped = true;
		} else {
			stopped = false;
		}
	}

	private void updateCrossingGate(CrossingGate gate) {
		if (gate.getTrafficCommand() == STOP_TRAFFIC_COMMAND) {
			gateDown = true;
		} else {
			gateDown = false;
		}
	}
}
