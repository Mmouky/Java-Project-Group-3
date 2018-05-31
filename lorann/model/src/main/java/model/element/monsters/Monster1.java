package model.element.monsters;

import java.awt.Image;

import model.ILevel;
import model.element.Monster;

public class Monster1 extends Monster {

	public Monster1(int x, int y, Image sprite, ILevel level) {
		super(x, y, sprite, level);
		this.pattern1();
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

	private void pattern1() {
		for( int i=0; i<3; i++){
			int yEl = this.getY() + 1;
			for(int j=0; i<2; j++){
				int xEl = this.getX() + 1;
				checkCase(xEl, yEl);
			}
		}
	}

	@Override
	public String toString() {
		return "Monstre 1";
	}

}
