package model.element.characters;

import java.awt.Image;

import model.ILevel;
import model.ModelFacade;
import model.element.Character;

public class Spell extends Character {

	private ModelFacade model;
	private ESpell eSpell;

	public Spell(int x, int y, Image sprite, ILevel level, ESpell eSpell, ModelFacade model) {
		super(x, y, sprite, level);
		this.model = model;
		this.seteSpell(eSpell);
	}

	public ESpell geteSpell() {
		return eSpell;
	}

	public void seteSpell(ESpell eSpell) {
		this.eSpell = eSpell;
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
	}

}
