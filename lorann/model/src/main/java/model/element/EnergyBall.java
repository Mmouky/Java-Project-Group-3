package model.element;

import java.awt.Image;

import model.Element;
import model.ModelFacade;

public class EnergyBall extends Element {

	private EBonus eBonus;
	private ModelFacade model;

	public EnergyBall(int x, int y, Image sprite, EBonus eBonus, ModelFacade model) {
		super(x, y, sprite);
		this.model = model;
		this.seteBonus(eBonus);
	}

	@Override
	public String toString() {
		return "EnergyBall";
	}

	public EBonus geteBonus() {
		return eBonus;
	}

	public void seteBonus(EBonus eBonus) {
		this.eBonus = eBonus;
		if (eBonus == EBonus.ENABLE) {
			this.setImage(model.getCrystal_ball());
		} else if (eBonus == EBonus.DISABLE) {
			this.setImage(model.getBackground());
		}
	}
}
