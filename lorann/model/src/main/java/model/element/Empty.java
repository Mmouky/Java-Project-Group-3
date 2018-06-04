package model.element;

import java.awt.Image;

import model.Element;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
 * @version 1.0
 */
public class Empty extends Element {

	/**
	 * Instantiates a new empty
	 * 
	 * @param x
	 * 			position x
	 * @param y
	 * 			position y
	 * @param sprite
	 * 			sprite
	 */
	public Empty(int x, int y, Image sprite) {
		super(x, y, sprite);
	}

	@Override
	public String toString() {
		return "Empty";
	}

}
