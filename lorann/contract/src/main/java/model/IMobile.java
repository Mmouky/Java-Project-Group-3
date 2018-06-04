package model;

import java.awt.Point;

import showboard.IPawn;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
 * @version 1.0
 */
public interface IMobile extends IPawn, IElement {

	/**
	 * Move up.
	 */
	void moveUp();

	/**
	 * Move left.
	 */
	void moveLeft();

	/**
	 * Move down.
	 */
	void moveDown();

	/**
	 * Move right.
	 */
	void moveRight();

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	@Override
	int getX();

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	@Override
	int getY();

	ILevel getLevel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.showboard.IPawn#getPosition()
	 */
	@Override
	Point getPosition();

	/**
	 * Set the level
	 * 
	 * @param level
	 */
	void setLevel(ILevel level);

}
