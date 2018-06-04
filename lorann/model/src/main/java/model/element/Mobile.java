package model.element;

import java.awt.Image;
import java.awt.Point;

import javax.swing.JOptionPane;

import model.Element;
import model.IElement;
import model.ILevel;
import model.IMobile;
import model.ModelFacade;
import model.element.characters.ELorann;
import model.element.characters.ESpell;
import model.element.characters.Lorann;
import model.element.characters.Spell;
import model.element.door.Door;
import model.element.door.EDoor;
import model.element.wall.Wall;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
 * @version 1.0
 */

public abstract class Mobile extends Element implements IMobile {

	/**
	 * Is alive
	 */
	private boolean isAlive;

	/**
	 * The model
	 */
	private ModelFacade model;

	/**
	 * The model
	 */
	private ILevel level;

	/**
	 * Instantiates a mobile
	 * 
	 * @param x
	 * @param y
	 * @param sprite
	 * @param level
	 * @param model
	 */
	public Mobile(int x, int y, Image sprite, ILevel level, ModelFacade model) {
		super(x, y, sprite);
		this.setModel(model);
		this.level = level;
		this.isAlive = true;
	}

	/**
	 * Move up
	 */
	public void moveUp() {

		int yEl = this.getY() - 1;
		int xEl = this.getX();

		checkWall(xEl, yEl);

		if (this instanceof Lorann) {
			checkLorann(xEl, yEl);
			Lorann lorann = (Lorann) this;
			lorann.seteLorann(ELorann.UP);
		} else if (this instanceof Monster) {
			monsterCheckLorann(xEl, yEl);
		} else if (this instanceof Spell) {
			spellCheckMonster(xEl, yEl);
		}

	}

	/**
	 * Move Down
	 */
	public void moveDown() {
		int yEl = this.getY() + 1;
		int xEl = this.getX();
		checkWall(xEl, yEl);
		if (this instanceof Lorann) {
			checkLorann(xEl, yEl);
			Lorann lorann = (Lorann) this;
			lorann.seteLorann(ELorann.DOWN);
		} else if (this instanceof Monster) {
			monsterCheckLorann(xEl, yEl);
		} else if (this instanceof Spell) {
			spellCheckMonster(xEl, yEl);
		}
	}

	/**
	 * Move Left
	 */
	public void moveLeft() {
		int yEl = this.getY();
		int xEl = this.getX() - 1;
		checkWall(xEl, yEl);
		if (this instanceof Lorann) {
			checkLorann(xEl, yEl);
			Lorann lorann = (Lorann) this;
			lorann.seteLorann(ELorann.LEFT);
		} else if (this instanceof Monster) {
			monsterCheckLorann(xEl, yEl);
		} else if (this instanceof Spell) {
			spellCheckMonster(xEl, yEl);
		}
	}

	/**
	 * Move Right
	 */
	public void moveRight() {
		int yEl = this.getY();
		int xEl = this.getX() + 1;
		checkWall(xEl, yEl);
		if (this instanceof Lorann) {
			checkLorann(xEl, yEl);
			Lorann lorann = (Lorann) this;
			lorann.seteLorann(ELorann.RIGHT);
		} else if (this instanceof Monster) {
			monsterCheckLorann(xEl, yEl);
		} else if (this instanceof Spell) {
			spellCheckMonster(xEl, yEl);
		}
	}

	/**
	 * Monsters check lorann
	 * 
	 * @param x
	 * @param y
	 */
	public void monsterCheckLorann(int x, int y) {
		if ((((Monster) this).isAlive())) {
			if (level.getLorann().getPosition().equals(new Point(x, y))) {
				this.die();
			}
		}
	}

	/**
	 * The spell check monsters
	 * 
	 * @param x
	 * @param y
	 */
	public void spellCheckMonster(int x, int y) {
		if (((Spell) this).geteSpell() == ESpell.ACTIVE) {
			for (IMobile iMobile : level.getMonsters()) {
				if (iMobile.getPosition().equals(new Point(x, y))) {
					if ((((Monster) iMobile).isAlive())) {
						((Monster) iMobile).setAlive(false);
						((Spell) this).seteSpell(ESpell.INACTIVE);
						level.addScore(100);
					}
				}
			}
		}
	}

	/**
	 * Lorann's check
	 * 
	 * @param x
	 * @param y
	 */
	public void checkLorann(int x, int y) {
		lorannCheckEnnemy(x, y);
		checkEnd(x, y);
		checkEnergyBall(x, y);
		checkMoney(x, y);
	}

	/**
	 * Check walls
	 * 
	 * @param x
	 * @param y
	 */
	public void checkWall(int x, int y) {
		if (hasWall(x, y) == false) {
			this.setY(y);
			this.setX(x);
		}
	}

	/**
	 * Check energyBall
	 * 
	 * @param x
	 * @param y
	 */
	public void checkEnergyBall(int x, int y) {
		if (level.getElements()[x][y] instanceof EnergyBall) {
			EnergyBall ball = ((EnergyBall) level.getElements()[x][y]);
			if (ball.geteBonus() == EBonus.ENABLE) {
				for (int i = 0; i < level.getElements().length; i++) {
					for (int j = 0; j < level.getElements()[i].length; j++) {
						IElement element = level.getElements()[i][j];
						if (element instanceof Door) {
							((Door) element).seteDoor(EDoor.OPEN);
							ball.seteBonus(EBonus.DISABLE);
							level.addScore(500);

						}
					}
				}
			}
		}
	}

	/**
	 * Lorann check Ennemy
	 * 
	 * @param x
	 * @param y
	 */
	public void lorannCheckEnnemy(int x, int y) {
		for (IMobile iMobile : level.getMonsters()) {
			if ((((Monster) iMobile).isAlive())) {
				if (iMobile.getPosition().equals(new Point(x, y))) {
					this.die();
				}
			}
		}

		if (level.getElements()[x][y] instanceof Door) {
			if (((Door) level.getElements()[x][y]).geteDoor() == EDoor.CLOSE) {
				this.die();
			}
		}
	}

	/**
	 * Check end
	 * 
	 * @param x
	 * @param y
	 */
	public void checkEnd(int x, int y) {
		if ((level.getElements()[x][y] instanceof Door)) {
			if (((Door) level.getElements()[x][y]).geteDoor() == EDoor.OPEN) {
				this.win();
			}
		}
	}

	/**
	 * Check win
	 */
	private void win() {
		JOptionPane.showMessageDialog(null, "VICTORY ! SCORE : " + level.getScore());
		System.exit(0);
	}

	/**
	 * Check money
	 * 
	 * @param x
	 * @param y
	 */
	public void checkMoney(int x, int y) {
		if (level.getElements()[x][y] instanceof Money) {
			Money money = (Money) level.getElements()[x][y];
			if (money.geteBonus() == EBonus.ENABLE) {
				level.addScore(650);
				money.seteBonus(EBonus.DISABLE);
			}
		}
	}

	/**
	 * Has wall
	 * 
	 * @param x
	 * @param y
	 * @return boolean
	 */
	public boolean hasWall(int x, int y) {
		if (level.getElements()[x][y] instanceof Wall) {
			return true;
		}
		return false;
	}

	/**
	 * Is alive
	 * 
	 * @return boolean
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * Set is alive
	 * 
	 * @param isAlive
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
		if (isAlive == false) {
			this.setImage(model.background);
		}
	}

	/**
	 * Die
	 */
	protected void die() {
		this.isAlive = false;
		System.out.println("juimor");
		JOptionPane.showMessageDialog(null, "GAME OVER ! SCORE : " + level.getScore());
		System.exit(0);
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return super.getX();
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return super.getY();
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return new Point(getX(), getY());
	}

	@Override
	public String toString() {
		return "Character";
	}

	@Override
	public ILevel getLevel() {
		return level;
	}

	@Override
	public void setLevel(ILevel level) {
		this.level = level;
	}

	/**
	 * Get model
	 * 
	 * @return ModelFacade
	 */
	public ModelFacade getModel() {
		return model;
	}

	/**
	 * Set model
	 * 
	 * @param model
	 */
	public void setModel(ModelFacade model) {
		this.model = model;
	}

}
