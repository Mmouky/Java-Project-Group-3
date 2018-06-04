package model;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Observable;

import javax.imageio.ImageIO;

import model.dao.LorannDAO;
import model.element.EBonus;
import model.element.Empty;
import model.element.EnergyBall;
import model.element.Money;
import model.element.Monster;
import model.element.characters.ELorann;
import model.element.characters.ESpell;
import model.element.characters.Lorann;
import model.element.characters.Spell;
import model.element.door.Door;
import model.element.door.EDoor;
import model.element.wall.EWall;
import model.element.wall.Wall;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
 * @version 1.0
 */
public final class ModelFacade extends Observable implements IModel {

	/**
	 * The background sprite
	 */
	public Image background;
	/**
	 * The corner wall sprite
	 */
	public Image bone;
	/**
	 * The crystal ball sprite
	 */
	public Image crystal_ball;
	/**
	 * The fireball sprite 1
	 */
	public Image fireball_1;
	/**
	 * The fireball sprite 2
	 */
	public Image fireball_2;
	/**
	 * The fireball sprite 3
	 */
	public Image fireball_3;
	/**
	 * The fireball sprite 4
	 */
	public Image fireball_4;
	/**
	 * The fireball sprite 5
	 */
	public Image fireball_5;
	/**
	 * The gate closed sprite
	 */
	public Image gate_closed;
	/**
	 * The gate opened sprite
	 */
	public Image gate_open;
	/**
	 * The horizontal wall sprite
	 */
	public Image horizontal_bone;
	/**
	 * The Lorann down sprite
	 */
	public Image lorann_b;
	/**
	 * The Lorann right sprite
	 */
	public Image lorann_r;
	/**
	 * The Lorann down-left sprite
	 */
	public Image lorann_bl;
	/**
	 * The Lorann down-right sprite
	 */
	public Image lorann_br;
	/**
	 * The Lorann left sprite
	 */
	public Image lorann_l;
	/**
	 * The Lorann up sprite
	 */
	public Image lorann_u;
	/**
	 * The Lorann up-left sprite
	 */
	public Image lorann_ul;
	/**
	 * The Lorann up-right sprite
	 */
	public Image lorann_ur;
	/**
	 * The monster 1 sprite
	 */
	public Image monster_1;
	/**
	 * The monster 2 sprite
	 */
	public Image monster_2;
	/**
	 * The monster 3 sprite
	 */
	public Image monster_3;
	/**
	 * The monster 4 sprite
	 */
	public Image monster_4;
	/**
	 * The money sprite
	 */
	public Image purse;
	/**
	 * The vertical wall sprite
	 */
	public Image vertical_bone;

	/**
	 * The level id
	 */
	private int idLevel = 1;

	/**
	 * Move up boolean
	 */
	private Boolean up = false;
	/**
	 * Move left boolean
	 */
	private Boolean left = false;
	/**
	 * Move right boolean
	 */
	private Boolean right = false;
	/**
	 * Move down boolean
	 */
	private Boolean down = false;

	/**
	 * The level
	 */
	private ILevel level;

	/**
	 * Instantiates a new model facade.
	 *
	 * @param level
	 * 				the level of the game
	 */
	public ModelFacade(ILevel level) {
		this.level = level;
		try {
			background = getSprite("background");
			bone = getSprite("bone");
			crystal_ball = getSprite("crystal_ball");
			fireball_1 = getSprite("fireball_1");
			fireball_2 = getSprite("fireball_2");
			fireball_3 = getSprite("fireball_3");
			fireball_4 = getSprite("fireball_4");
			fireball_5 = getSprite("fireball_5");
			gate_closed = getSprite("gate_closed");
			gate_open = getSprite("gate_open");
			horizontal_bone = getSprite("horizontal_bone");
			lorann_b = getSprite("lorann_b");
			lorann_r = getSprite("lorann_r");
			lorann_bl = getSprite("lorann_bl");
			lorann_br = getSprite("lorann_br");
			lorann_l = getSprite("lorann_l");
			lorann_u = getSprite("lorann_u");
			lorann_ul = getSprite("lorann_ul");
			lorann_ur = getSprite("lorann_ur");
			monster_1 = getSprite("monster_1");
			monster_2 = getSprite("monster_2");
			monster_3 = getSprite("monster_3");
			monster_4 = getSprite("monster_4");
			purse = getSprite("purse");
			vertical_bone = getSprite("vertical_bone");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IModel#getEntryById(int)
	 */
	public InputStream getEntryById(final int id) throws SQLException {
		return LorannDAO.getEntryById(id).getBinaryStream();
	}

	/**
	 * Add elements to the level
	 * 
	 * @param txt
	 * 			level file
	 */
	public void addElementToLevel(String txt) throws SQLException, IOException {

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 20; j++) {
				char c = txt.charAt(j + (20 * i));

				if (c == 'x') {
					level.addElements(new Empty(j, i, background));
				} else if (c == '-') {
					level.addElements(new Wall(j, i, horizontal_bone, EWall.HORIZONTAL));
				} else if (c == 'O') {
					level.addElements(new Wall(j, i, bone, EWall.CORNER));
				} else if (c == 'B') {
					level.addElements(new EnergyBall(j, i, crystal_ball, EBonus.ENABLE, this));
				} else if (c == 'M') {
					level.addElements(new Money(j, i, purse, EBonus.ENABLE, this));
				} else if (c == 'D') {
					level.addElements(new Door(j, i, gate_closed, EDoor.CLOSE, this));
				} else if (c == '|') {
					level.addElements(new Wall(j, i, vertical_bone, EWall.VERTICAL));
				}
				System.out.println(level.getElements()[j][i]);
			}

		}

		level.setLorann(new Lorann((int) LorannDAO.getLorannPosition(idLevel).getX(),
				(int) LorannDAO.getLorannPosition(idLevel).getY(), lorann_b, level, ELorann.NONE, this));
		level.getMonsters().add(new Monster((int) LorannDAO.getMonster1Position(idLevel).getX(),
				(int) LorannDAO.getMonster1Position(idLevel).getY(), monster_1, level, this));
		level.getMonsters().add(new Monster((int) LorannDAO.getMonster2Position(idLevel).getX(),
				(int) LorannDAO.getMonster2Position(idLevel).getY(), monster_2, level, this));
		level.getMonsters().add(new Monster((int) LorannDAO.getMonster3Position(idLevel).getX(),
				(int) LorannDAO.getMonster3Position(idLevel).getY(), monster_3, level, this));
		level.getMonsters().add(new Monster((int) LorannDAO.getMonster4Position(idLevel).getX(),
				(int) LorannDAO.getMonster4Position(idLevel).getY(), monster_4, level, this));

		level.setSpell(new Spell((int) LorannDAO.getLorannPosition(idLevel).getX(),
				(int) LorannDAO.getLorannPosition(idLevel).getY(), fireball_1, level, ESpell.INACTIVE,
				((Lorann) level.getLorann()).getLastMove(), this));

		System.out.println("ca compile");

		refresh();

	}

	/**
	 * Refresh panel
	 */
	public void refresh() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					((Monster) level.getMonsters().get(0)).pattern();
					((Monster) level.getMonsters().get(1)).pattern1();
					((Monster) level.getMonsters().get(2)).pattern2();
					((Monster) level.getMonsters().get(3)).pattern3();

					Spell spell = ((Spell) level.getSpell());
					if (spell.geteSpell() == ESpell.ACTIVE) {
						spell.changeSprite();
					}
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					Lorann lorann = (Lorann) level.getLorann();
					if (lorann.geteLorann() == ELorann.NONE) {
						lorann.changeSprite();
					}
					if (right == true) {
						lorann.moveRight();
					}
					if (left == true) {
						lorann.moveLeft();
					}
					if (up == true) {
						lorann.moveUp();
					}
					if (down == true) {
						lorann.moveDown();
					}
					setChanged();
					notifyObservers();
				}
			}
		});

		t.start();
		t2.start();

	}

	/**
	 * 
	 * Read the file of the level on the database
	 * 
	 * @param id
	 * 			id of the level
	 */
	public String readFile(int id) {
		idLevel = id;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(getEntryById(id)));
			try {
				String line = br.readLine();
				String msg = "";

				while (line != null) {
					msg += line;
					line = br.readLine();
				}
				br.close();
				return msg;

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "ERROR";

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IModel#getSpriteByName(char)
	 */
	public InputStream getSpriteByName(final String def) throws SQLException {
		return LorannDAO.getSpriteByName(def).getBinaryStream();
	}

	/**
	 * Get sprite
	 * 
	 * @param def
	 * 			name of the sprite
	 * @return image
	 * @throws IOException
	 * 				the IO exception
	 * @throws SQLException
	 * 				the SQL exception
	 */
	public Image getSprite(String def) throws IOException, SQLException {
		InputStream is = new BufferedInputStream(getSpriteByName(def));
		Image image = ImageIO.read(is);
		return image;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			this.up = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.down = true;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.left = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Spell spell = ((Spell) level.getSpell());
			if (spell.geteSpell() == ESpell.INACTIVE) {
				spell.seteSpell(ESpell.ACTIVE);
			}
			spell.setX(level.getLorann().getX());
			spell.setY(level.getLorann().getY());
			spell.seteLorann(((Lorann) level.getLorann()).getLastMove());
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		Lorann lorann = ((Lorann) level.getLorann());
		if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			this.up = false;
			lorann.setLastMove(ELorann.UP);
		} else if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			this.down = false;
			lorann.setLastMove(ELorann.DOWN);
		} else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.right = false;
			lorann.setLastMove(ELorann.RIGHT);
		} else if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			this.left = false;
			lorann.setLastMove(ELorann.LEFT);
		}
		if (this.up == false && this.down == false && this.right == false && this.left == false) {
			lorann.seteLorann(ELorann.NONE);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLevel(ILevel level) {
		this.level = level;
	}

	@Override
	public ILevel getLevel() {
		return level;
	}

	@Override
	public Image getBackground() {
		return background;
	}

	@Override
	public void setBackground(Image background) {
		this.background = background;
	}

	@Override
	public Image getBone() {
		return bone;
	}

	@Override
	public void setBone(Image bone) {
		this.bone = bone;
	}

	@Override
	public Image getCrystal_ball() {
		return crystal_ball;
	}

	@Override
	public void setCrystal_ball(Image crystal_ball) {
		this.crystal_ball = crystal_ball;
	}

	@Override
	public Image getFireball_1() {
		return fireball_1;
	}

	@Override
	public void setFireball_1(Image fireball_1) {
		this.fireball_1 = fireball_1;
	}

	@Override
	public Image getFireball_2() {
		return fireball_2;
	}

	@Override
	public void setFireball_2(Image fireball_2) {
		this.fireball_2 = fireball_2;
	}

	@Override
	public Image getFireball_3() {
		return fireball_3;
	}

	@Override
	public void setFireball_3(Image fireball_3) {
		this.fireball_3 = fireball_3;
	}

	@Override
	public Image getFireball_4() {
		return fireball_4;
	}

	@Override
	public void setFireball_4(Image fireball_4) {
		this.fireball_4 = fireball_4;
	}

	@Override
	public Image getFireball_5() {
		return fireball_5;
	}

	@Override
	public void setFireball_5(Image fireball_5) {
		this.fireball_5 = fireball_5;
	}

	@Override
	public Image getGate_closed() {
		return gate_closed;
	}

	@Override
	public void setGate_closed(Image gate_closed) {
		this.gate_closed = gate_closed;
	}

	@Override
	public Image getGate_open() {
		return gate_open;
	}

	@Override
	public void setGate_open(Image gate_open) {
		this.gate_open = gate_open;
	}

	@Override
	public Image getHorizontal_bone() {
		return horizontal_bone;
	}

	@Override
	public void setHorizontal_bone(Image horizontal_bone) {
		this.horizontal_bone = horizontal_bone;
	}

	@Override
	public Image getLorann_b() {
		return lorann_b;
	}

	@Override
	public void setLorann_b(Image lorann_b) {
		this.lorann_b = lorann_b;
	}

	@Override
	public Image getLorann_r() {
		return lorann_r;
	}

	@Override
	public void setLorann_r(Image lorann_r) {
		this.lorann_r = lorann_r;
	}

	@Override
	public Image getLorann_bl() {
		return lorann_bl;
	}

	@Override
	public void setLorann_bl(Image lorann_bl) {
		this.lorann_bl = lorann_bl;
	}

	@Override
	public Image getLorann_br() {
		return lorann_br;
	}

	@Override
	public void setLorann_br(Image lorann_br) {
		this.lorann_br = lorann_br;
	}

	@Override
	public Image getLorann_l() {
		return lorann_l;
	}

	@Override
	public void setLorann_l(Image lorann_l) {
		this.lorann_l = lorann_l;
	}

	@Override
	public Image getLorann_u() {
		return lorann_u;
	}

	@Override
	public void setLorann_u(Image lorann_u) {
		this.lorann_u = lorann_u;
	}

	@Override
	public Image getLorann_ul() {
		return lorann_ul;
	}

	@Override
	public void setLorann_ul(Image lorann_ul) {
		this.lorann_ul = lorann_ul;
	}

	@Override
	public Image getLorann_ur() {
		return lorann_ur;
	}

	@Override
	public void setLorann_ur(Image lorann_ur) {
		this.lorann_ur = lorann_ur;
	}

	@Override
	public Image getMonster_1() {
		return monster_1;
	}

	@Override
	public void setMonster_1(Image monster_1) {
		this.monster_1 = monster_1;
	}

	@Override
	public Image getMonster_2() {
		return monster_2;
	}

	@Override
	public void setMonster_2(Image monster_2) {
		this.monster_2 = monster_2;
	}

	@Override
	public Image getMonster_3() {
		return monster_3;
	}

	@Override
	public void setMonster_3(Image monster_3) {
		this.monster_3 = monster_3;
	}

	@Override
	public Image getMonster_4() {
		return monster_4;
	}

	@Override
	public void setMonster_4(Image monster_4) {
		this.monster_4 = monster_4;
	}

	@Override
	public Image getPurse() {
		return purse;
	}

	@Override
	public void setPurse(Image purse) {
		this.purse = purse;
	}

	@Override
	public Image getVertical_bone() {
		return vertical_bone;
	}

	@Override
	public void setVertical_bone(Image vertical_bone) {
		this.vertical_bone = vertical_bone;
	}

}
