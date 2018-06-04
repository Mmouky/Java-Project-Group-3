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

public class Spell extends Mobile {

	/**
	 * The model
	 */
	private ModelFacade model;

	/**
	 * The eSpell
	 */
	private ESpell eSpell;

	/**
	 * The eLorann
	 */
	private ELorann eLorann;

	/**
	 * Instantiates the spell
	 * 
	 * @param x
	 * @param y
	 * @param sprite
	 * @param level
	 * @param eSpell
	 * @param eLorann
	 * @param model
	 */
	public Spell(int x, int y, Image sprite, ILevel level, ESpell eSpell, ELorann eLorann, ModelFacade model) {
		super(x, y, sprite, level, model);
		this.model = model;
		this.seteLorann(eLorann);
		this.seteSpell(eSpell);
	}

	/**
	 * 
	 * Get the ESPell
	 * 
	 * @return ESpell
	 */
	public ESpell geteSpell() {
		return eSpell;
	}

	/**
	 * Set the ESPell
	 * 
	 * @param eSpell
	 */
	public void seteSpell(ESpell eSpell) {
		this.eSpell = eSpell;
		if (eSpell == ESpell.INACTIVE) {
			setImage(model.background);
		} else {
			setImage(model.fireball_1);
		}
	}

	/**
	 * Change the sprite of the spell during the movement
	 */
	public void changeSprite() {
		if (this.getImage().equals(model.fireball_1)) {
			this.setImage(model.fireball_2);
		} else if (this.getImage().equals(model.fireball_2)) {
			this.setImage(model.fireball_3);
		} else if (this.getImage().equals(model.fireball_3)) {
			this.setImage(model.fireball_4);
		} else if (this.getImage().equals(model.fireball_4)) {
			this.setImage(model.fireball_5);
		} else if (this.getImage().equals(model.fireball_5)) {
			this.setImage(model.fireball_1);
		}
		move();
	}

	/**
	 * movement of the spell
	 */
	public void move() {
		if (eLorann == ELorann.DOWN) {
			moveUp();
		} else if (eLorann == ELorann.UP) {
			moveDown();
		} else if (eLorann == ELorann.LEFT) {
			moveRight();
		} else if (eLorann == ELorann.RIGHT) {
			moveLeft();
		}
		System.out.println(eLorann);
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
	 */
	public void seteLorann(ELorann eLorann) {
		this.eLorann = eLorann;
	}

}
