package model;

import java.awt.*;

import showboard.ISquare;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
 * @version 1.0
 */
public abstract class Element implements IElement {

	/**
	 * The sprite
	 */
	protected Image sprite;
	/**
	 * The position X
	 */
	protected int x;
	/**
	 * 	The position y
	 */
	protected int y;

	/**
	 * Instantiates an element
	 * @param x
	 * @param y
	 * @param sprite
	 */
	public Element(int x, int y, Image sprite) {
		this.y = y;
		this.x = x;
		this.sprite = sprite;

	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Element";
	}

	@Override
	public Image getImage() {
		return sprite;
	}

	@Override
	public void setImage(Image image) {
		this.sprite = image;
	}

}
