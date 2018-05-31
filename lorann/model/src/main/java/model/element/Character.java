package model.element;

import java.awt.Image;
import java.awt.Point;

import model.Element;
import model.ILevel;
import model.IMobile;
import model.element.wall.Wall;

public abstract class Character extends Element implements IMobile {

	private boolean isAlive;
	private ILevel level;

	public Character(int x, int y, Image sprite, ILevel level) {
		super(x, y, sprite);
		this.level = level;
		this.isAlive = true;
	}

	public void moveUp() {

		int yEl = this.getY() - 1;
		int xEl = this.getX();

		if (hasWall(xEl, yEl) == false) {
			this.setY(yEl);
		}

	}

	public void moveDown() {
		int yEl = this.getY() + 1;
		int xEl = this.getX();

		if (hasWall(xEl, yEl) == false) {
			this.setY(yEl);
		}
	}

	public void moveLeft() {
		int yEl = this.getY();
		int xEl = this.getX() - 1;

		if (hasWall(xEl, yEl) == false) {
			this.setX(xEl);
		}
	}

	public void moveRight() {
		int yEl = this.getY();
		int xEl = this.getX() + 1;

		if (hasWall(xEl, yEl) == false) {
			this.setX(xEl);
		}
	}

	public boolean hasWall(int x, int y) {
		if (level.getElements()[x][y] instanceof Wall) {
			return true;
		}
		return false;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	protected void die() {
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
