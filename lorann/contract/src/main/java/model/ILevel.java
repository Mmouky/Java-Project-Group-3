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
	 * 			  the score
	 */
	int getScore();

	/**
	 * Set the score
	 * 
	 * @param score
	 * 				the score
	 */
	void setScore(int score);

	/**
	 * Add a score
	 * 
	 * @param score
	 * 				the score
	 */
	void addScore(int score);

	/**
	 * Get elements of the level
	 * 
	 * @return
	 * 		  the array of the element of the level
	 */
	IElement[][] getElements();

	/**
	 * Set elements of the level
	 * 
	 * @param elements
	 * 					set the element of the level
	 */
	void setElements(IElement[][] elements);

	/**
	 * Add elements on the level
	 * 
	 * @param element
	 *                add the element to the level
	 */
	void addElements(IElement element);

	/**
	 * Get Lorann
	 * 
	 * @return IMobile
	 * 				   get Lorann
	 */
	IMobile getLorann();

	/**
	 * Set Lorann
	 * 
	 * @param lorann
	 * 				 set Lorann
	 */
	void setLorann(IMobile lorann);

	/**
	 * Get Spell
	 * 
	 * @return IMobile
	 * 					get spells
	 */
	IMobile getSpell();

	/**
	 * Set spell
	 * 
	 * @param spell
	 * 				set spells
	 */
	void setSpell(IMobile spell);


	ArrayList<IMobile> getMonsters();

	/**
	 * Set monsters
	 * @param monsters
	 * 				   set Mosnters
	 */
	void setMonsters(ArrayList<IMobile> monsters);
}
