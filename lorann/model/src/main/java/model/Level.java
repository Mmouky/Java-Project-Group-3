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

    public void addElements(int x, int y, Element element){ elements[x][y] = element; }

    public void Loader(){

    }

    public void Generator(){

    }

}
