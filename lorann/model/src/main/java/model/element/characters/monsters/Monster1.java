package model.element.characters.monsters;

import java.awt.Image;

import model.ILevel;
import model.element.Monster;

public class Monster1 extends Monster {

	public Monster1(int x, int y, Image sprite, ILevel level) {
		super(x, y, sprite, level);
	}

	private boolean isDetected() {
		return true;
	};

	private void PathFinding() {

	};

	private void Attack() {

	};

	private void Sleep() {

	};

	private void Pattern() {

	}

	@Override
	public String toString() {
		return "Monstre 1";
	}

}
