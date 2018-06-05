package model.element;

import java.awt.Image;

import model.Element;
import model.ModelFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
 * @version 1.0
 */
public class EnergyBall extends Element {

	/**
	 * The EBonus
	 */
	private EBonus eBonus;
	/**
	 * The model
	 */
	private ModelFacade model;

	/**
	 * Instantiates the energy ball
	 * 
	 * @param x
	 * 			position x
	 * @param y
	 * 			position y
	 * @param sprite
	 * 			sprite of the energy ball
	 * @param eBonus
	 * 			EBonus of the energyBall
	 * @param model
	 * 			The model
	 */
	public EnergyBall(int x, int y, Image sprite, EBonus eBonus, ModelFacade model) {
		super(x, y, sprite);
		this.model = model;
		this.seteBonus(eBonus);
	}

	@Override
	public String toString() {
		return "EnergyBall";
	}

	/**
	 * Get the EBonus
	 * 
	 * @return EBonus
	 */
	public EBonus geteBonus() {
		return eBonus;
	}

	/**
	 * Set the EBonus
	 * 
	 * @param eBonus
	 * 			EBonus of the energy ball
	 */
	public void seteBonus(EBonus eBonus) {
		this.eBonus = eBonus;
		if (eBonus == EBonus.ENABLE) {
			this.setImage(model.getCrystal_ball());
		} else if (eBonus == EBonus.DISABLE) {
			this.setImage(model.getBackground());
		}
	}
}
