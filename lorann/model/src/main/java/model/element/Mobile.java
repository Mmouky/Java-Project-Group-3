package model.element;

import java.awt.Image;
import java.awt.Point;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.swing.JOptionPane;

import model.Element;
import model.IElement;
import model.ILevel;
import model.IMobile;
import model.ModelFacade;
import model.Sound;
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
	 *            position x
	 * @param y
	 *            position y
	 * @param sprite
	 *            sprite of a mobile
	 * @param level
	 *            level of the game
	 * @param model
	 *            the model
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
			monsterCheckSpell(xEl, yEl);
		} else if (this instanceof Spell) {
			spellCheckMonster(xEl, yEl);
			spellCheckLorann(xEl, yEl);
			if (this.getY() != yEl) {
				((Spell) level.getSpell()).seteLorann(ELorann.UP);
			}
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
			monsterCheckSpell(xEl, yEl);
		} else if (this instanceof Spell) {
			spellCheckMonster(xEl, yEl);
			spellCheckLorann(xEl, yEl);
			if (this.getY() != yEl) {
				((Spell) level.getSpell()).seteLorann(ELorann.DOWN);
			}
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
			monsterCheckSpell(xEl, yEl);
		} else if (this instanceof Spell) {
			spellCheckMonster(xEl, yEl);
			spellCheckLorann(xEl, yEl);
			if (this.getX() != xEl) {
				((Spell) level.getSpell()).seteLorann(ELorann.LEFT);
			}
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
			monsterCheckSpell(xEl, yEl);
		} else if (this instanceof Spell) {
			spellCheckMonster(xEl, yEl);
			spellCheckLorann(xEl, yEl);
			if (this.getX() != xEl) {
				((Spell) level.getSpell()).seteLorann(ELorann.RIGHT);
			}
		}
	}

	/**
	 * Monsters check lorann
	 * 
	 * @param x
	 *            position x
	 * @param y
	 *            position y
	 */
	public void monsterCheckLorann(int x, int y) {
		if ((((Monster) this).isAlive())) {
			if (level.getLorann().getPosition().equals(new Point(x, y))) {
				this.die();
			}
		}
	}

	/**
	 * Monsters check spell
	 * 
	 * @param x
	 *            position x
	 * @param y
	 *            position y
	 */
	public void monsterCheckSpell(int x, int y) {
		if ((((Monster) this).isAlive())) {
			if (level.getSpell().getPosition().equals(new Point(x, y))
					&& ((Spell) level.getSpell()).geteSpell() == ESpell.ACTIVE) {
				((Monster) this).setAlive(false);
				((Spell) level.getSpell()).seteSpell(ESpell.INACTIVE);
				level.addScore(100);
				soundDeathMonster();
			}
		}
	}

	/**
	 * The spell check monsters
	 * 
	 * @param x
	 *            position x
	 * @param y
	 *            position y
	 */
	public void spellCheckMonster(int x, int y) {
		if (((Spell) this).geteSpell() == ESpell.ACTIVE) {
			for (IMobile iMobile : level.getMonsters()) {
				if (iMobile.getPosition().equals(new Point(x, y))) {
					if ((((Monster) iMobile).isAlive())) {
						((Monster) iMobile).setAlive(false);
						((Spell) this).seteSpell(ESpell.INACTIVE);
						level.addScore(100);
						soundDeathMonster();
					}
				}
			}
		}
	}

	/**
	 * Play sound when a monster die
	 */
	public void soundDeathMonster() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				Sound kill = new Sound("lorann//sounds//kill.wav");
				InputStream is = new ByteArrayInputStream(kill.getSamples());
				kill.play(is);
			}
		});
		t.start();
	}

	/**
	 * The spell check Lorann
	 * 
	 * @param x
	 *            position x
	 * @param y
	 *            position y
	 */
	public void lorannCheckSpell(int x, int y) {
		if (level.getSpell().getPosition().equals(new Point(x, y))) {
			((Spell) level.getSpell()).seteSpell(ESpell.INACTIVE);
		}
	}

	/**
	 * The spell check Lorann
	 * 
	 * @param x
	 *            position x
	 * @param y
	 *            position y
	 */
	public void spellCheckLorann(int x, int y) {
		if (((Spell) this).geteSpell() == ESpell.ACTIVE) {
			if (level.getLorann().getPosition().equals(new Point(x, y))) {
				((Spell) this).seteSpell(ESpell.INACTIVE);
			}
		}
	}

	/**
	 * Lorann's check
	 *
	 * @param x
	 *            position x
	 * @param y
	 *            position y
	 */
	public void checkLorann(int x, int y) {
		lorannCheckEnnemy(x, y);
		lorannCheckSpell(x, y);
		checkEnd(x, y);
		loranncheckEnergyBall(x, y);
		checkMoney(x, y);
	}

	/**
	 * Check walls
	 *
	 * @param x
	 *            position x
	 * @param y
	 *            position y
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
	 *            position x
	 * @param y
	 *            position y
	 */
	public void loranncheckEnergyBall(int x, int y) {
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
							Thread t = new Thread(new Runnable() {

								@Override
								public void run() {
									Sound energy_ball = new Sound("lorann//sounds//energy_ball.wav");
									InputStream is = new ByteArrayInputStream(energy_ball.getSamples());
									energy_ball.play(is);
								}
							});
							t.start();
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
	 *            position x
	 * @param y
	 *            position y
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
	 *            position x
	 * @param y
	 *            position y
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
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				Sound win = new Sound("lorann//sounds//win.wav");
				InputStream is = new ByteArrayInputStream(win.getSamples());
				win.play(is);
			}
		});
		t.start();
		JOptionPane.showMessageDialog(null, "VICTORY ! SCORE : " + level.getScore());
		System.exit(0);
	}

	/**
	 * Check money
	 *
	 * @param x
	 *            position x
	 * @param y
	 *            position y
	 */
	public void checkMoney(int x, int y) {
		if (level.getElements()[x][y] instanceof Money) {
			Money money = (Money) level.getElements()[x][y];
			if (money.geteBonus() == EBonus.ENABLE) {
				level.addScore(650);
				money.seteBonus(EBonus.DISABLE);
				Thread t = new Thread(new Runnable() {

					@Override
					public void run() {
						Sound money = new Sound("lorann//sounds//money.wav");
						InputStream is = new ByteArrayInputStream(money.getSamples());
						money.play(is);
					}
				});
				t.start();
			}
		}
	}

	/**
	 * Has wall
	 *
	 * @param x
	 *            position x
	 * @param y
	 *            position y
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
	 *            check if the mobile is alive
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
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				Sound die = new Sound("lorann//sounds//lose.wav");
				InputStream is = new ByteArrayInputStream(die.getSamples());
				die.play(is);
			}
		});
		t.start();
		this.isAlive = false;
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
	 *            the model
	 */
	public void setModel(ModelFacade model) {
		this.model = model;
	}

}
