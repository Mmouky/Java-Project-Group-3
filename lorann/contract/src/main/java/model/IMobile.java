package model;

import java.awt.Point;

import showboard.IPawn;

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

	void setLevel(ILevel level);

}
