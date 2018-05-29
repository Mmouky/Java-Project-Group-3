package model.element;

import model.Element;

import java.awt.*;

public class Items extends Element {

    private Items items;

    public Items(int x, int y, Image sprite, Items items) {
        super(x, y, sprite);
        this.items = items;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
