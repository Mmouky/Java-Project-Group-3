package model;

import java.awt.Point;

import showboard.IPawn;

public interface IMobile extends IPawn, IElement {

	/**
	 * Move up.
	 */
	boolean moveUp();

	/**
	 * Move left.
	 */
	boolean moveLeft();

	/**
	 * Move down.
	 */
	boolean moveDown();

	/**
	 * Move right.
	 */
	boolean moveRight();

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.showboard.IPawn#getPosition()
	 */
	@Override
	Point getPosition();

}
