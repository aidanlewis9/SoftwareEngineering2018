package model.vehicles;

import java.util.Observable;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.infrastructure.Direction;

/**
 * Represents the train entity object
 * @author jane
 *
 */
public class Train implements IVehicle{
	private double currentX = 0;
	private double currentY = 0;
	private Direction direction;
	private double originalX = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	
	public Train(int x, int y, Direction direction){
		this.currentX = x;
		this.currentY = y;
		this.direction = direction;
		originalX = (direction == Direction.WEST) ? x : -200;
		img = new Image("images/Train.PNG",120,trainLength,false,false);
		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		currentX = (direction == Direction.WEST) ? currentX - 2 : currentX + 2;
		imgView.setX(currentX);
	}
	
	public boolean offScreen(){
		if ((direction == Direction.WEST && currentX < -200) ||
				(direction == Direction.EAST && currentX > 1200))
			return true;
		else
			return false;				
	}
	
	public void reset(){
		currentX = originalX;
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
}