package model.element;

import java.awt.Image;
import java.awt.Point;

import model.Element;
import model.IMobile;

public abstract class Character extends Element implements IMobile {

	private boolean isAlive;

	public Character(int x, int y, Image sprite) {
		super(x, y, sprite);
		this.isAlive = true;
	}

	public boolean moveUp() {
        this.setY(this.getY() + 1);
		return true;
	}

	public boolean moveDown() {
        this.setY(this.getY() -1);
		return true;
	}

	public boolean moveLeft() {
        this.setX(this.getX() - 1);
		return true;
	}

	public boolean moveRight() {
        this.setX(this.getX() + 1);
		return true;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	protected void die(){
	    this.isAlive = false;
    }

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return super.getX();
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return super.getY();
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return new Point(getX(), getY());
	}

	@Override
	public String toString() {
		return "Character";
	}

}
