package model;

import java.util.ArrayList;

public interface ILevel {

	int getScore();

	void setScore(int score);

	void addScore(int score);

	IElement[][] getElements();

	void setElements(IElement[][] elements);

	void addElements(IElement element);

	IMobile getLorann();

	void setLorann(IMobile lorann);

	IMobile getSpell();

	void setSpell(IMobile spell);

	ArrayList<IMobile> getMonsters();

	void setMonsters(ArrayList<IMobile> monsters);
}
