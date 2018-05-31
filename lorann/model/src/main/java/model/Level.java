package model;

public class Level implements ILevel {

	private IElement[][] elements = new IElement[20][12];

	public Level() {
	}

	public IElement[][] getElements() {
		return elements;
	}

	@Override
	public void setElements(IElement[][] elements) {
		this.elements = elements;
	}

	@Override
	public void addElements(IElement element) {
		int x = element.getX();
		int y = element.getY();
		elements[x][y] = element;
	}
	
	

}
