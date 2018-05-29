package model;

import model.Element;

public class Level {

    private Element[][]elements = new Element[12][20];

    public Level(){
    }

    public Element[][] getElements() {
        return elements;
    }

    public void setElements(Element[][] elements) {
        this.elements = elements;
    }
}
