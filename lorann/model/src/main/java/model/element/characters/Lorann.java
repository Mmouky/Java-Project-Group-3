package model.element.characters;

import java.awt.Image;

import model.ILevel;
import model.ModelFacade;
import model.element.Mobile;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
 * @version 1.0
 */

public class Lorann extends Mobile {

	/**
	 * The movement of Lorann
	 */
	private ELorann eLorann;

	/**
	 * The last movement of Lorann
	 */
	private ELorann lastMove;

	/**
	 * The model
	 */
	private ModelFacade model;

	/**
	 * Instantiates a new Lorann.
	 * 
	 * @param x
	 *            the position x
	 * @param y
	 *            the position y
	 * @param sprite
	 *            the sprite
	 * @param level
	 *            the level
	 * @param eLorann
	 *            the ELorann
	 * @param model
	 *            the model
	 */
	public Lorann(int x, int y, Image sprite, ILevel level, ELorann eLorann, ModelFacade model) {
		super(x, y, sprite, level, model);
		this.model = model;
		this.seteLorann(eLorann);
	}

	@Override
	public String toString() {
		return "Lorann";
	}

	/**
	 * Get the ELorann
	 * 
	 * @return ELorann
	 */
	public ELorann geteLorann() {
		return eLorann;
	}

	/**
	 * Set the ELorann
	 * 
	 * @param eLorann
	 *            the ELorann
	 * 
	 */
	public void seteLorann(ELorann eLorann) {
		this.eLorann = eLorann;

		if (eLorann == ELorann.LEFT) {
			this.setImage(model.lorann_l);
		} else if (eLorann == ELorann.RIGHT) {
			this.setImage(model.lorann_r);
		} else if (eLorann == ELorann.UP) {
			this.setImage(model.lorann_u);
		} else if (eLorann == ELorann.DOWN) {
			this.setImage(model.lorann_b);
		} else if (eLorann == ELorann.RIGHT_UP) {
			this.setImage(model.lorann_ur);
		} else if (eLorann == ELorann.LEFT_UP) {
			this.setImage(model.lorann_ul);
		} else if (eLorann == ELorann.RIGHT_DOWN) {
			this.setImage(model.lorann_br);
		} else if (eLorann == ELorann.LEFT_DOWN) {
			this.setImage(model.lorann_bl);
		}
	}

	/**
	 * Change the sprite for the Lorann rotation
	 */
	public void changeSprite() {
		if (this.getImage().equals(model.lorann_b)) {
			this.setImage(model.lorann_bl);
		} else if (this.getImage().equals(model.lorann_bl)) {
			this.setImage(model.lorann_l);
		} else if (this.getImage().equals(model.lorann_l)) {
			this.setImage(model.lorann_ul);
		} else if (this.getImage().equals(model.lorann_ul)) {
			this.setImage(model.lorann_u);
		} else if (this.getImage().equals(model.lorann_u)) {
			this.setImage(model.lorann_ur);
		} else if (this.getImage().equals(model.lorann_ur)) {
			this.setImage(model.lorann_r);
		} else if (this.getImage().equals(model.lorann_r)) {
			this.setImage(model.lorann_br);
		} else if (this.getImage().equals(model.lorann_br)) {
			this.setImage(model.lorann_b);
		}
	}

	/**
	 * 
	 * Get the last move of Lorann
	 * 
	 * @return ELorann
	 */
	public ELorann getLastMove() {
		return lastMove;
	}

	/**
	 * Set the last move of Lorann
	 * 
	 * @param lastMove
	 */
	public void setLastMove(ELorann lastMove) {
		this.lastMove = lastMove;
	}

}
