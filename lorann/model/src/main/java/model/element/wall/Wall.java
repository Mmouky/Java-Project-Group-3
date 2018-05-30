package model.element.wall;

import model.Element;

import java.awt.*;

public class Wall extends Element {

	private EWall eWall;

	public Wall(int x, int y, Image sprite, EWall eWall) {
		super(x, y, sprite);
		this.eWall = eWall;
	}

	public EWall geteWall() {
		return eWall;
	}

	@Override
	public String toString() {
		String str = "";
		if (eWall == EWall.CORNER) {
			str = "CORNER";
		} else if (eWall == EWall.HORIZONTAL) {
			str = "HORIZONTAL";
		} else if (eWall == EWall.VERTICAL) {
			str = "VERTICAL";
		}
		return str;
	}
}
