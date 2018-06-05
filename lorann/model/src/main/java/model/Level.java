package model;

import java.util.ArrayList;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
 * @version 1.0
 */
public class Level implements ILevel {

	/**
	 * The score
	 */
	private int score;

	/**
	 * The elements on the map
	 */
	private IElement[][] elements = new IElement[20][12];

	/**
	 * Lorann
	 */
	private IMobile lorann;

	/**
	 * The spell
	 */
	private IMobile spell;

	/**
	 * Monsters
	 */
	private ArrayList<IMobile> monsters = new ArrayList<IMobile>();
	

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public void addScore(int score) {
		this.score += score;
	}

	@Override
	public IElement[][] getElements() {
		return elements;
	}

	@Override
	public void setElements(IElement[][] elements) {
		this.elements = elements;
	}

	@Override
	public void addElements(IElement element) {
		int x = element.getX();
		int y = element.getY();
		elements[x][y] = element;
	}

	@Override
	public IMobile getLorann() {
		return lorann;
	}

	@Override
	public void setLorann(IMobile lorann) {
		this.lorann = lorann;
	}

	@Override
	public ArrayList<IMobile> getMonsters() {
		return monsters;
	}

	@Override
	public void setMonsters(ArrayList<IMobile> monsters) {
		this.monsters = monsters;
	}

	@Override
	public IMobile getSpell() {
		return spell;
	}

	@Override
	public void setSpell(IMobile spell) {
		this.spell = spell;
	}

}
