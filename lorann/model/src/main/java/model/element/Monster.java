package model.element;

import java.awt.Image;
import java.util.Random;

import model.Element;
import model.ILevel;
import model.ModelFacade;
import model.element.characters.Lorann;
import model.element.wall.EWall;
import model.element.wall.Wall;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
 * @version 1.0
 */
public class Monster extends Mobile {
	/**
	 * The direction in horizontal axe
	 */
	int ax = 1;
	/**
	 * The direction in vertical axe
	 */
	int ay = -1;

	/**
	 * Instantiates a monster
	 * 
	 * @param x
	 * 			position x
	 * @param y
	 * 			position y
	 * @param sprite
	 * 			Sprite of a monster
	 * @param level
	 * 			level of the game
	 * @param model
	 * 			the model
	 */
	public Monster(int x, int y, Image sprite, ILevel level, ModelFacade model) {
		super(x, y, sprite, level, model);
	}

	/**
	 * Pattern 1 for a monster
	 */
	public void pattern() {
		Lorann lorann = ((Lorann) getLevel().getLorann());
		if (lorann.getX() < getX()) {
			moveLeft();
		} else if (lorann.getX() > getX()) {
			moveRight();
		}
		if (lorann.getY() < getY()) {
			moveUp();
		} else if (lorann.getY() > getY()) {
			moveDown();
		}
	}

	/**
	 * Pattern 2 for a monster
	 */
	public void pattern1() {
		Lorann lorann = ((Lorann) getLevel().getLorann());
		if (lorann.getX() == getX()) {
			if (lorann.getY() < getY()) {
				moveUp();
			}
		}
		if (lorann.getX() == getX()) {
			if (lorann.getY() > getY()) {
				moveDown();
			}
		}
		if (lorann.getY() == getY()) {
			if (lorann.getX() > getX()) {
				moveRight();
			}
		}
		if (lorann.getY() == getY()) {
			if (lorann.getX() < getX()) {
				moveLeft();
			}
		}
	}

	/**
	 * Pattern 3 for a monster
	 */
	public void pattern2() {
		int random = new Random().nextInt(4);
		switch (random) {
		case (0):
			moveLeft();
			break;
		case (1):
			moveRight();
			break;
		case (2):
			moveDown();
			break;
		case (3):
			moveUp();
			break;
		}
	}

	/**
	 * Pattern 4 for a monster
	 */
	public void pattern3() {
		int xP = getX();
		int yP = getY();

		if (ax == 1 && ay == -1) {
			moveDown();
			moveRight();
			int x2 = getX();
			int y2 = getY();
			if (xP == x2) {
				ax = -1;
				moveLeft();
			}
			if (yP == y2) {
				ay = 1;
				moveUp();
			}
		} else if (ax == 1 && ay == 1) {
			moveUp();
			moveRight();
			int x2 = getX();
			int y2 = getY();
			if (xP == x2) {
				ax = -1;
				moveLeft();
			}
			if (yP == y2) {
				ay = -1;
				moveDown();
			}
		} else if (ax == -1 && ay == -1) {
			moveDown();
			moveLeft();
			int x2 = getX();
			int y2 = getY();
			if (xP == x2) {
				ax = 1;
				moveRight();
			}
			if (yP == y2) {
				ay = 1;
				moveUp();
			}
		} else if (ax == -1 && ay == 1) {
			moveUp();
			moveLeft();
			int x2 = getX();
			int y2 = getY();
			if (xP == x2) {
				ax = 1;
				moveRight();
			}
			if (yP == y2) {
				ay = -1;
				moveDown();
			}
		}

	}

	@Override
	public String toString() {
		return "Monster";
	}
}
