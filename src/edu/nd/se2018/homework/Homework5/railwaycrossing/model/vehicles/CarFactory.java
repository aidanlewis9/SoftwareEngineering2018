package model.vehicles;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import model.infrastructure.Direction;
import model.infrastructure.gate.CrossingGate;


/**
 * Very basic car factory.  Creates the car and registers it with the crossing gate and the car infront of it.
 * @author jane
 *
 */
public class CarFactory {
	
	private Collection<CrossingGate> gates = null;
	private Car previousCar = null;
	Direction direction;
	Point location;
	
	public CarFactory(){}
	
	public CarFactory(Direction direction, Point location, Collection<CrossingGate> gates){
		this.direction = direction;
		this.location = location;
		this.gates = gates;
	}
	
	
	// Most code here is to create random speeds
	public Car buildCar() {
		if (previousCar == null || location.y < previousCar.getVehicleY()-100) {
			Car car = new Car(location.x, location.y);
			double speedVariable = (Math.random() * 10)/10;
			car.setSpeed((2-speedVariable)*1.5); 
			
			// All cars created by this factory must be aware of crossing gates in the road
			for(CrossingGate gate: gates){
				gate.addObserver(car);
				if(gate != null && gate.getTrafficCommand()=="STOP")
					car.setGateDownFlag(false);
			}

			return car;
		} else 
			return null;
	}
}
