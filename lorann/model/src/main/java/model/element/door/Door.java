package model.element.door;

import java.awt.Image;

import model.Element;
import model.ModelFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
 * @version 1.0
 */
public class Door extends Element {

	/**
	 * The EDoor
	 */
	private EDoor eDoor;

	/**
	 * The model
	 */
	private ModelFacade model;

	/**
	 * Instantiates the door.
	 * 
	 * @param x
	 * 			position x
	 * @param y
	 * 			position y
	 * @param sprite
	 * 			sprite of the door
	 * @param eDoor
	 * 			EDoor of the door
	 * @param model
	 * 			The model
	 */
	public Door(int x, int y, Image sprite, EDoor eDoor, ModelFacade model) {
		super(x, y, sprite);
		this.eDoor = eDoor;
		this.model = model;
	}

	/**
	 * Get the EDoor
	 * 
	 * @return EDoor
	 */
	public EDoor geteDoor() {
		return eDoor;
	}

	/**
	 * Set the EDoor
	 * 
	 * @param eDoor
	 * 			EDoor of the door
	 */
	public void seteDoor(EDoor eDoor) {
		this.eDoor = eDoor;
		if (eDoor == EDoor.CLOSE) {
			this.setImage(model.getGate_closed());
		} else if (eDoor == EDoor.OPEN) {
			this.setImage(model.getGate_open());
		}
	}

	@Override
	public String toString() {
		return "Door";
	}
}
