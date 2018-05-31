package model.element.monsters;

import java.awt.Image;

import model.ILevel;
import model.element.Monster;

public class Monster4 extends Monster {

	public Monster4(int x, int y, Image sprite, ILevel level) {
		super(x, y, sprite, level);
	}

	@Override
	public String toString() {
		return "Monstre 4";
	}

}
