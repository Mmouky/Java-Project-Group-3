package model;

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

    public void addElements(Element element){
        int x = element.getX();
        int y = element.getY();
        elements[x][y] = element;
        
    }

    public void Loader(){

    }

    public void Generator(){

    }



}
