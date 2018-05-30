package model;

import java.awt.Image;

import showboard.ISquare;

public interface IElement extends ISquare {

	int getX();

	int getY();

	void setX(int x);

	void setY(int y);

	void setImage(Image image);
	
}
