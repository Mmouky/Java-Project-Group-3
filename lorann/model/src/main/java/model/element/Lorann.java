package model.element;

import java.awt.Image;

import model.ILevel;

public class Lorann extends Character {
	public Lorann(int x, int y, Image sprite, ILevel level) {
		super(x, y, sprite, level);
	}

	public void attack() {

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
