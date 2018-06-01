package model;

import java.util.ArrayList;

public class Level implements ILevel {

	private int score;

	private IElement[][] elements = new IElement[20][12];

	private IMobile lorann;

	private IMobile spell;

	private ArrayList<IMobile> monsters = new ArrayList<IMobile>();

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void addScore(int score) {
		this.score += score;
		System.out.println(this.score);
	}

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

	public ArrayList<IMobile> getMonsters() {
		return monsters;
	}

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
