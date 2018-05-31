package model;

import java.awt.*;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

import model.dao.ExampleDAO;
import model.element.*;
import model.element.characters.ELorann;
import model.element.characters.Lorann;
import model.element.door.Door;
import model.element.door.EDoor;
import model.element.monsters.Monster1;
import model.element.monsters.Monster2;
import model.element.monsters.Monster3;
import model.element.monsters.Monster4;
import model.element.wall.EWall;
import model.element.wall.Wall;

import javax.swing.*;
import javax.imageio.ImageIO;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade extends Observable implements IModel {

	public Image background;
	public Image bone;
	public Image crystal_ball;
	public Image fireball_1;
	public Image fireball_2;
	public Image fireball_3;
	public Image fireball_4;
	public Image fireball_5;
	public Image gate_closed;
	public Image gate_open;
	public Image horizontal_bone;
	public Image lorann_b;
	public Image lorann_r;
	public Image lorann_bl;
	public Image lorann_br;
	public Image lorann_l;
	public Image lorann_u;
	public Image lorann_ul;
	public Image lorann_ur;
	public Image monster_1;
	public Image monster_2;
	public Image monster_3;
	public Image monster_4;
	public Image purse;
	public Image vertical_bone;

	/**
	 * Instantiates a new model facade.
	 */

	private ILevel level;

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
	 * @see model.IModel#getExampleById(int)
	 */

	@Override
	public Example getExampleById(final int id) throws SQLException {
		return ExampleDAO.getExampleById(id);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IModel#getEntryById(int)
	 */
	public InputStream getEntryById(final int id) throws SQLException {
		return ExampleDAO.getEntryById(id).getBinaryStream();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IModel#getExampleByName(java.lang.String)
	 */

	@Override
	public Example getExampleByName(final String name) throws SQLException {
		return ExampleDAO.getExampleByName(name);
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see model.IModel#getAllExamples()
	 */

	@Override
	public List<Example> getAllExamples() throws SQLException {
		return ExampleDAO.getAllExamples();
	}
	public void getElement(String txt) throws SQLException, IOException {

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

		level.setLorann(new Lorann(6, 3, lorann_b, level,ELorann.NONE,this));
		level.setMonster1(new Monster1(12, 7, monster_1, level));
		level.setMonster2(new Monster2(2, 5, monster_2, level));
		level.setMonster3(new Monster3(10, 7, monster_3, level));
		level.setMonster4(new Monster4(4, 10, monster_4, level));

		System.out.println("ca compile");

	}

	public String readFile(int id) {

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
		return ExampleDAO.getSpriteByName(def).getBinaryStream();
	}

	public Image getSprite(String def) throws IOException, SQLException {
		InputStream is = new BufferedInputStream(getSpriteByName(def));
		Image image = ImageIO.read(is);
		return image;
	}

	@Override
	public void setLevel(ILevel level) {
		this.level = level;
	}

	@Override
	public ILevel getLevel() {
		return level;
	}

	public Image getBackground() {
		return background;
	}

	public void setBackground(Image background) {
		this.background = background;
	}

	public Image getBone() {
		return bone;
	}

	public void setBone(Image bone) {
		this.bone = bone;
	}

	public Image getCrystal_ball() {
		return crystal_ball;
	}

	public void setCrystal_ball(Image crystal_ball) {
		this.crystal_ball = crystal_ball;
	}

	public Image getFireball_1() {
		return fireball_1;
	}

	public void setFireball_1(Image fireball_1) {
		this.fireball_1 = fireball_1;
	}

	public Image getFireball_2() {
		return fireball_2;
	}

	public void setFireball_2(Image fireball_2) {
		this.fireball_2 = fireball_2;
	}

	public Image getFireball_3() {
		return fireball_3;
	}

	public void setFireball_3(Image fireball_3) {
		this.fireball_3 = fireball_3;
	}

	public Image getFireball_4() {
		return fireball_4;
	}

	public void setFireball_4(Image fireball_4) {
		this.fireball_4 = fireball_4;
	}

	public Image getFireball_5() {
		return fireball_5;
	}

	public void setFireball_5(Image fireball_5) {
		this.fireball_5 = fireball_5;
	}

	public Image getGate_closed() {
		return gate_closed;
	}

	public void setGate_closed(Image gate_closed) {
		this.gate_closed = gate_closed;
	}

	public Image getGate_open() {
		return gate_open;
	}

	public void setGate_open(Image gate_open) {
		this.gate_open = gate_open;
	}

	public Image getHorizontal_bone() {
		return horizontal_bone;
	}

	public void setHorizontal_bone(Image horizontal_bone) {
		this.horizontal_bone = horizontal_bone;
	}

	public Image getLorann_b() {
		return lorann_b;
	}

	public void setLorann_b(Image lorann_b) {
		this.lorann_b = lorann_b;
	}

	public Image getLorann_r() {
		return lorann_r;
	}

	public void setLorann_r(Image lorann_r) {
		this.lorann_r = lorann_r;
	}

	public Image getLorann_bl() {
		return lorann_bl;
	}

	public void setLorann_bl(Image lorann_bl) {
		this.lorann_bl = lorann_bl;
	}

	public Image getLorann_br() {
		return lorann_br;
	}

	public void setLorann_br(Image lorann_br) {
		this.lorann_br = lorann_br;
	}

	public Image getLorann_l() {
		return lorann_l;
	}

	public void setLorann_l(Image lorann_l) {
		this.lorann_l = lorann_l;
	}

	public Image getLorann_u() {
		return lorann_u;
	}

	public void setLorann_u(Image lorann_u) {
		this.lorann_u = lorann_u;
	}

	public Image getLorann_ul() {
		return lorann_ul;
	}

	public void setLorann_ul(Image lorann_ul) {
		this.lorann_ul = lorann_ul;
	}

	public Image getLorann_ur() {
		return lorann_ur;
	}

	public void setLorann_ur(Image lorann_ur) {
		this.lorann_ur = lorann_ur;
	}

	public Image getMonster_1() {
		return monster_1;
	}

	public void setMonster_1(Image monster_1) {
		this.monster_1 = monster_1;
	}

	public Image getMonster_2() {
		return monster_2;
	}

	public void setMonster_2(Image monster_2) {
		this.monster_2 = monster_2;
	}

	public Image getMonster_3() {
		return monster_3;
	}

	public void setMonster_3(Image monster_3) {
		this.monster_3 = monster_3;
	}

	public Image getMonster_4() {
		return monster_4;
	}

	public void setMonster_4(Image monster_4) {
		this.monster_4 = monster_4;
	}

	public Image getPurse() {
		return purse;
	}

	public void setPurse(Image purse) {
		this.purse = purse;
	}

	public Image getVertical_bone() {
		return vertical_bone;
	}

	public void setVertical_bone(Image vertical_bone) {
		this.vertical_bone = vertical_bone;
	}

}
