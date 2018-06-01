package model.element;

import java.awt.Image;
import java.util.Random;

import model.Element;
import model.ILevel;
import model.ModelFacade;
import model.element.characters.Lorann;
import model.element.wall.EWall;
import model.element.wall.Wall;

public class Monster extends Character {

    int ax = 1;
    int ay = -1;

	public Monster(int x, int y, Image sprite, ILevel level, ModelFacade model) {
		super(x, y, sprite, level, model);
	}

	public void pattern() {
		Lorann lorann = ((Lorann) getLevel().getLorann());
		if (lorann.getX() < getX()) {
			moveLeft();
		} else if (lorann.getX() > getX()) {
			moveRight();
		}
		if (lorann.getY() < getY()) {
			moveUp();
		} else if (lorann.getY() > getY()) {
			moveDown();
		}
	}


	public void pattern1(){
		Lorann lorann = ((Lorann) getLevel().getLorann());
		if(lorann.getX() == getX()) {
            if (lorann.getY() < getY()) {
                moveUp();
            }
        }
        if(lorann.getX() == getX()) {
            if (lorann.getY() > getY()) {
                moveDown();
            }
        }
        if(lorann.getY() == getY()) {
            if (lorann.getX() > getX()) {
                moveRight();
            }
        }
        if(lorann.getY() == getY()) {
            if (lorann.getX() < getX()) {
                moveLeft();
            }
        }
	}

	public void pattern2(){
	    int random = new Random().nextInt(4);
	    switch (random){
            case(0):
                moveLeft();
                break;
            case(1):
                moveRight();
                break;
            case(2):
                moveDown();
                break;
            case(3):
                moveUp();
                break;
        }
    }

    public void pattern3(){
        int xP = getX();
        int yP = getY();

        if(ax == 1 && ay == -1){
            moveDown();
            moveRight();
            int x2 = getX();
            int y2 = getY();
            if(xP == x2) {
                ax = -1;
                moveLeft();
            }
            if(yP == y2){
                ay = 1;
                moveUp();
            }
        }else
        if(ax == 1 && ay == 1){
            moveUp();
            moveRight();
            int x2 = getX();
            int y2 = getY();
            if(xP == x2) {
                ax = -1;
                moveLeft();
            }
            if(yP == y2){
                ay = -1;
                moveDown();
            }
        }else
        if(ax == -1 && ay == -1){
            moveDown();
            moveLeft();
            int x2 = getX();
            int y2 = getY();
            if(xP == x2) {
                ax = 1;
                moveRight();
            }
            if(yP == y2){
                ay = 1;
                moveUp();
            }
        }else
        if(ax == -1 && ay == 1){
            moveUp();
            moveLeft();
            int x2 = getX();
            int y2 = getY();
            if(xP == x2) {
                ax = 1;
                moveRight();
            }
            if(yP == y2){
                ay = -1;
                moveDown();
            }
        }

    }

	@Override
	public String toString() {
		return "Monster";
	}
}
