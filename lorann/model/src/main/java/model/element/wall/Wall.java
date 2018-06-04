package model.element.wall;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
 * @version 1.0
 */
import model.Element;

import java.awt.*;

public class Wall extends Element {

	/**
	 * The EWall
	 */
	private EWall eWall;

	/**
	 * Instantiates a wall
	 * 
	 * @param x
	 * @param y
	 * @param sprite
	 * @param eWall
	 */
	public Wall(int x, int y, Image sprite, EWall eWall) {
		super(x, y, sprite);
		this.eWall = eWall;
	}

	/**
	 * Get the EWall
	 * 
	 * @return EWall
	 */
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
