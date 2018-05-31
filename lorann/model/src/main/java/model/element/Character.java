package model.element;

import java.awt.Image;
import java.awt.Point;

import model.Element;
import model.IElement;
import model.ILevel;
import model.IMobile;
import model.element.door.Door;
import model.element.door.EDoor;
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

		checkCase(xEl, yEl);

	}

	public void moveDown() {
		int yEl = this.getY() + 1;
		int xEl = this.getX();
		checkCase(xEl, yEl);
	}

	public void moveLeft() {
		int yEl = this.getY();
		int xEl = this.getX() - 1;
		checkCase(xEl, yEl);
	}

	public void moveRight() {
		int yEl = this.getY();
		int xEl = this.getX() + 1;
		checkCase(xEl, yEl);
	}

	public void checkCase(int x, int y) {
		if (hasWall(x, y) == false) {
			this.setY(y);
			this.setX(x);
			checkEnergyBall(x, y);
			checkMoney(x, y);
		}
	}

	public void checkEnergyBall(int x, int y) {
		if (level.getElements()[x][y] instanceof EnergyBall) {
			for (int i = 0; i < level.getElements().length; i++) {
				for (int j = 0; j < level.getElements()[i].length; j++) {
					IElement element = level.getElements()[i][j];
					if (element instanceof Door) {
						((Door) element).seteDoor(EDoor.OPEN);
						((EnergyBall) level.getElements()[x][y]).seteBonus(EBonus.DISABLE);
					}
				}
			}
		}
	}

	public void checkMoney(int x, int y) {
		if (level.getElements()[x][y] instanceof Money) {
			Money money = (Money) level.getElements()[x][y];
			if (money.geteBonus() == EBonus.ENABLE) {
				level.addScore(100);
				money.seteBonus(EBonus.DISABLE);
			}
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
