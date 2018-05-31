package model.element.monsters;

import java.awt.*;

import model.Element;
import model.element.Monster;

public class Monster1 extends Monster {

	public Monster1(int x, int y, Image sprite) {
		super(x, y, sprite);
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

	private void Pattern(){

	}


	@Override
	public String toString() {
		return "Monstre 1";
	}

}
