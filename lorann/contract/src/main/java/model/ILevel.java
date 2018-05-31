package model;

public interface ILevel {

	void addScore(int score);

	IElement[][] getElements();

	void setElements(IElement[][] elements);

	void addElements(IElement element);

	IMobile getLorann();

	void setLorann(IMobile lorann);

	IMobile getMonster1();

	void setMonster1(IMobile monster);

	IMobile getMonster2();

	void setMonster2(IMobile monster);

	IMobile getMonster3();

	void setMonster3(IMobile monster);

	IMobile getMonster4();

	void setMonster4(IMobile monster);

}
