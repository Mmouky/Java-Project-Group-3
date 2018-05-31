package model.element;

import java.awt.Image;

import model.Element;

public class Empty extends Element {

	public Empty(int x, int y, Image sprite) {
		super(x, y, sprite);
	}
	
	 @Override
	    public String toString() {
	        return "Empty";
	    }

}
