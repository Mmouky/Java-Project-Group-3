package model.element.monsters;

import java.awt.Image;

import model.ILevel;
import model.element.Monster;

public class Monster3 extends Monster {

	public Monster3(int x, int y, Image sprite, ILevel level) {
		super(x, y, sprite, level);
	}

	@Override
	public String toString() {
		return "Monstre 3";
	}

	
}
