package model.element;

import java.awt.Image;

import model.ILevel;
import model.element.characters.Lorann;

public abstract class Monster extends Character {

	public Monster(int x, int y, Image sprite, ILevel level) {
		super(x, y, sprite, level);
	}

	public void pattern1(){
		Lorann lorann = (Lorann)getLevel().getLorann();

		if(lorann.getX() < getX()){
			moveLeft();
		}else if(lorann.getX() > getX()){
			moveRight();
		}
		if(lorann.getY() < getY()){
			moveUp();
		}else if(lorann.getY() > getY()){
			moveDown();
		}
	}

	@Override
	public String toString() {
		return "Monster";
	}
}
