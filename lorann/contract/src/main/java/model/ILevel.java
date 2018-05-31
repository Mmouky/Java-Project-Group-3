package model;

import java.util.ArrayList;

public interface ILevel {

	void addScore(int score);

	IElement[][] getElements();

	void setElements(IElement[][] elements);

	void addElements(IElement element);

	IMobile getLorann();

	void setLorann(IMobile lorann);

	ArrayList<IMobile> getMonsters();

	void setMonsters(ArrayList<IMobile> monsters);
}
