package model.element;

import java.awt.Image;

import model.ILevel;

public abstract class Monster extends Character {

	public Monster(int x, int y, Image sprite, ILevel level) {
		super(x, y, sprite, level);
	}

	@Override
	public String toString() {
		return "Monster";
	}
}
