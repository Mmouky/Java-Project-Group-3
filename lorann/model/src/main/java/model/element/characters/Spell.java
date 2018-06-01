package model.element.characters;

import java.awt.Image;

import model.ILevel;
import model.ModelFacade;
import model.element.Character;

public class Spell extends Character {

	private ModelFacade model;
	private ESpell eSpell;
	private ELorann eLorann;

	public Spell(int x, int y, Image sprite, ILevel level, ESpell eSpell, ELorann eLorann, ModelFacade model) {
		super(x, y, sprite, level, model);
		this.model = model;
		this.seteLorann(eLorann);
		this.seteSpell(eSpell);
	}

	public ESpell geteSpell() {
		return eSpell;
	}

	public void seteSpell(ESpell eSpell) {
		this.eSpell = eSpell;
		if (eSpell == ESpell.INACTIVE) {
			setImage(model.background);
		} else {
			setImage(model.fireball_1);
		}
	}

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

	public ELorann geteLorann() {
		return eLorann;
	}

	public void seteLorann(ELorann eLorann) {
		this.eLorann = eLorann;
	}

}
