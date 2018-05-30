package model.element;

import java.awt.Image;

import model.Element;

public abstract class Character extends Element {

	private boolean isAlive;

	public Character(int x, int y, Image sprite) {
		super(x, y, sprite);
		this.isAlive = true;
	}

	public boolean moveUP() {
		this.x -= 1;
		return true;
	}

	public boolean moveDown() {
		this.x += 1;
		return true;
	}

	public boolean moveLeft() {
		this.y -= 1;
		return true;
	}

	public boolean moveRight() {
		this.y += 1;
		return true;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public String toString() {
		return "Character";
	}
	
}
