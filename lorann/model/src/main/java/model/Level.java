package model;

import model.element.Empty;

public class Level implements ILevel {

	private int score;

	private IElement[][] elements = new IElement[20][12];

	private IMobile lorann;

	private IMobile monster1;
	private IMobile monster2;
	private IMobile monster3;
	private IMobile monster4;

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

	@Override
	public IMobile getMonster1() {
		return monster1;
	}

	@Override
	public void setMonster1(IMobile monster) {
		this.monster1 = monster;
	}

	@Override
	public IMobile getMonster2() {
		return monster2;
	}

	@Override
	public void setMonster2(IMobile monster) {
		this.monster2 = monster;
	}

	@Override
	public IMobile getMonster3() {
		return monster3;
	}

	@Override
	public void setMonster3(IMobile monster) {
		this.monster3 = monster;
	}

	@Override
	public IMobile getMonster4() {
		return monster4;
	}

	@Override
	public void setMonster4(IMobile monster) {
		this.monster4 = monster;
	}

}
