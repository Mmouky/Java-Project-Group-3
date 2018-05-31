package model.element;

import java.awt.*;

public class Lorann extends Character {
	public Lorann(int x, int y, Image sprite) {
		super(x, y, sprite);
	}

	public void attack() {

	}

	@Override
	public boolean moveDown() {
		return super.moveDown();
	}

	@Override
	public boolean moveRight() {
		return super.moveRight();
	}

	@Override
	public boolean moveLeft() {
		return super.moveLeft();
	}

	@Override
	public boolean moveUp() {
		return super.moveUp();
	}

	@Override
	protected void die() {
		super.die();
	}

	@Override
	public String toString() {
		return "Lorann";
	}

	
}
