package model;

import java.awt.*;

import showboard.ISquare;

public abstract class Element implements IElement {

	protected Image sprite;
	protected int x;
	protected int y;

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
