package model;

import java.awt.*;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

import model.dao.ExampleDAO;
import model.element.*;
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
	/**
	 * Instantiates a new model facade.
	 */

	private ILevel level;

	public ModelFacade(ILevel level) {
		this.level = level;
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

		Image background = getSprite("background");
		Image bone = getSprite("bone");
		Image crystal_ball = getSprite("crystal_ball");
		Image fireball_1 = getSprite("fireball_1");
		Image fireball_2 = getSprite("fireball_2");
		Image fireball_3 = getSprite("fireball_3");
		Image fireball_4 = getSprite("fireball_4");
		Image fireball_5 = getSprite("fireball_5");
		Image gate_closed = getSprite("gate_closed");
		Image gate_open = getSprite("gate_open");
		Image horizontal_bone = getSprite("horizontal_bone");
		Image lorann_b = getSprite("lorann_b");
		Image lorann_bl = getSprite("lorann_bl");
		Image lorann_br = getSprite("lorann_br");
		Image lorann_l = getSprite("lorann_l");
		Image lorann_u = getSprite("lorann_u");
		Image lorann_ul = getSprite("lorann_ul");
		Image lorann_ur = getSprite("lorann_ur");
		Image monster_1 = getSprite("monster_1");
		Image monster_2 = getSprite("monster_2");
		Image monster_3 = getSprite("monster_3");
		Image monster_4 = getSprite("monster_4");
		Image purse = getSprite("purse");
		Image vertical_bone = getSprite("vertical_bone");

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
					level.addElements(new EnergyBall(j, i, crystal_ball));
				} else if (c == 'M') {
					level.addElements(new Money(j, i, purse));
				} else if (c == 'D') {
					level.addElements(new Door(j, i, gate_closed));
				} else if (c == '|') {
					level.addElements(new Wall(j, i, vertical_bone, EWall.VERTICAL));
				}
				System.out.println(level.getElements()[j][i]);
			}

		}

		level.setLorann(new Lorann(6, 3, lorann_b, level));
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

}
