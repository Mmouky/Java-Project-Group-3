package model.element;

import model.Element;

import java.awt.*;

public abstract class Character extends Element {

    private boolean isAlive;

    Character(int x, int y, Image sprite) {
        super(x, y, sprite);
        this.isAlive = true;
    }

    private boolean moveUP(){
        this.x -= 1;
        return true;
    }

    private boolean moveDown(){
        this.x += 1;
        return true;
    }

    private boolean moveLeft(){
        this.y -= 1;
        return true;
    }

    private boolean moveRight(){
        this.y += 1;
        return true;
    }


}
