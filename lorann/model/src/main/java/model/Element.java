package model;

import java.awt.*;

public abstract class Element {

    protected Image sprite;
    protected int x;
    protected int y;

    public Element(int x, int y, Image sprite){
        this.y = y;
        this.x = x;
        this.sprite = sprite;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

}
