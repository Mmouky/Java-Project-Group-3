package model.element;

import java.awt.*;

public abstract class Monster extends Character {

	public Monster(int x, int y, Image sprite) {
		super(x, y, sprite);
	}

	@Override
	public String toString() {
		return "Monster";
	}
}
