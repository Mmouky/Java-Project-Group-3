package model.element.characters.monsters;

import java.awt.Image;

import model.ILevel;
import model.element.Monster;

public class Monster2 extends Monster {

	public Monster2(int x, int y, Image sprite, ILevel level) {
		super(x, y, sprite, level);
	}

	@Override
	public String toString() {
		return "Monstre 2";
	}

	
}
