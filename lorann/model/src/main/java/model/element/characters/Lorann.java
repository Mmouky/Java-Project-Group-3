package model.element.characters;

import java.awt.Image;

import model.ILevel;
import model.ModelFacade;
import model.element.Character;

public class Lorann extends Character {

	private ELorann eLorann;
	private ModelFacade model;


	public Lorann(int x, int y, Image sprite, ILevel level, ELorann eLorann, ModelFacade model) {
		super(x, y, sprite, level);
		this.model = model;
		this.seteLorann(eLorann);
	}

	public void attack() {

	}

	@Override
	protected void die() {
		super.die();
	}

	@Override
	public String toString() {
		return "Lorann";
	}

	public ELorann geteLorann() {
		return eLorann;
	}

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
		} else if (eLorann == ELorann.NONE) {

		}
	}

	public void changeSprite() {
		if (this.getImage().equals(model.lorann_b)) {
			this.setImage(model.lorann_u);
		} else if (this.getImage().equals(model.lorann_u)) {
			this.setImage(model.lorann_b);
		}
	}



}
