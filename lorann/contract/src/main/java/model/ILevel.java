package model;

import java.util.ArrayList;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
 * @version 1.0
 */
public interface ILevel {

	/**
	 * Get the score
	 * 
	 * @return int
	 */
	int getScore();

	/**
	 * Set the score
	 * 
	 * @param score
	 */
	void setScore(int score);

	/**
	 * Add a score
	 * 
	 * @param score
	 */
	void addScore(int score);

	/**
	 * Get elements of the level
	 * 
	 * @return
	 */
	IElement[][] getElements();

	/**
	 * Set elements of the level
	 * 
	 * @param elements
	 */
	void setElements(IElement[][] elements);

	/**
	 * Add elements on the level
	 * 
	 * @param element
	 */
	void addElements(IElement element);

	/**
	 * Get Lorann
	 * 
	 * @return IMobile
	 */
	IMobile getLorann();

	/**
	 * Set Lorann
	 * 
	 * @param lorann
	 */
	void setLorann(IMobile lorann);

	/**
	 * Get Spell
	 * 
	 * @return IMobile
	 */
	IMobile getSpell();

	/**
	 * Set spell
	 * 
	 * @param spell
	 */
	void setSpell(IMobile spell);

	/**
	 * Get monsters
	 * 
	 * @return ArrayList<IMobile>
	 */
	ArrayList<IMobile> getMonsters();

	/**
	 * Set monsters
	 * @param monsters
	 */
	void setMonsters(ArrayList<IMobile> monsters);
}
