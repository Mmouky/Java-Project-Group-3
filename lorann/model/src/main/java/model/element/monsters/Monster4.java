package model.element.monsters;

import java.awt.*;

import model.element.Monster;

public class Monster4 extends Monster {

	public Monster4(int x, int y, Image sprite) {
		super(x, y, sprite);
	}

	@Override
	public String toString() {
		return "Monstre 4";
	}

	@Override
	public Point getPosition() {
		return null;
	}
}
