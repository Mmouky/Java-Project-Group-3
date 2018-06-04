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
public class Money extends Element {

	/**
	 * The eBonus
	 */
	private EBonus eBonus;

	/**
	 * The model
	 */
	private ModelFacade model;

	/**
	 * Instantiates a money
	 * 
	 * @param x
	 * @param y
	 * @param sprite
	 * @param eBonus
	 * @param model
	 */
	public Money(int x, int y, Image sprite, EBonus eBonus, ModelFacade model) {
		super(x, y, sprite);
		this.model = model;
		this.eBonus = eBonus;
	}

	@Override
	public String toString() {
		return "Money";
	}

	/**
	 * Get eBonus
	 * 
	 * @return EBonus
	 */
	public EBonus geteBonus() {
		return eBonus;
	}

	/**
	 * Set eBonus
	 * 
	 * @param eBonus
	 */
	public void seteBonus(EBonus eBonus) {
		this.eBonus = eBonus;
		if (eBonus == EBonus.ENABLE) {
			this.setImage(model.getPurse());
		} else if (eBonus == EBonus.DISABLE) {
			this.setImage(model.getBackground());
		}
	}

}
