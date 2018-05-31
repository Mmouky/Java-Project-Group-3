package model.element.door;

import java.awt.Image;

import model.Element;
import model.ModelFacade;

public class Door extends Element {

	private EDoor eDoor;
	private ModelFacade model;

	public Door(int x, int y, Image sprite, EDoor eDoor, ModelFacade model) {
		super(x, y, sprite);
		this.eDoor = eDoor;
		this.model = model;
	}

	public EDoor geteDoor() {
		return eDoor;
	}

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
