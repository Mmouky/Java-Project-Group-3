package model.element;

import java.awt.Image;

import model.Element;
import model.ModelFacade;

public class Money extends Element {

	private EBonus eBonus;
	private ModelFacade model;

	public Money(int x, int y, Image sprite, EBonus eBonus, ModelFacade model) {
		super(x, y, sprite);
		this.model = model;
		this.eBonus = eBonus;
	}

	@Override
	public String toString() {
		return "Money";
	}

	public EBonus geteBonus() {
		return eBonus;
	}

	public void seteBonus(EBonus eBonus) {
		this.eBonus = eBonus;
		if (eBonus == EBonus.ENABLE) {
			this.setImage(model.getPurse());
		} else if (eBonus == EBonus.DISABLE) {
			this.setImage(model.getBackground());
		}
	}
	
}
