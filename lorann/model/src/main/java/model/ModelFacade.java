package model;

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

	private Level level;

	public Level getLevel() {
		return level;
	}


	public void setLevel(Level level) {
		this.level = level;
	}


	public ModelFacade() {
		level = new Level();
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


	public void getElement(String txt) {

		for (int i = 0; i < 12; i++){
			for (int j = 0; j < 20; j++){
				char c = txt.charAt(j+(20*i));


					if (c == '-') {
						level.addElements(new Wall(i, j, new ImageIcon("lorann\\sprite\\horizontal_bone.png").getImage(), EWall.HORIZONTAL));
					}
					else if (c == 'O') {
						level.addElements(new Wall(i, j, new ImageIcon("lorann\\sprite\\bone.png").getImage(), EWall.CORNER));
					}
					else if (c == 'B') {
						level.addElements(new EnergyBall(i, j, new ImageIcon("lorann\\sprite\\crystal_ball.png").getImage()));
					}
					else if (c == 'M') {
						level.addElements(new Money(i, j, new ImageIcon("lorann\\sprite\\purse.png").getImage()));
					}
					else if (c == '2') {
						level.addElements(new Monster2(i, j, new ImageIcon("lorann\\sprite\\monster_2.png").getImage()));
					}
					else if (c == '1') {
						level.addElements(new Monster1(i, j, new ImageIcon("lorann\\sprite\\monster_1.png").getImage()));
					}
					else if (c == '3') {
						level.addElements(new Monster3(i, j, new ImageIcon("lorann\\sprite\\monster_3.png").getImage()));
					}
					else if (c == '4') {
						level.addElements(new Monster4(i, j, new ImageIcon("lorann\\sprite\\monster_4.png").getImage()));
					}
					else if (c == 'D') {
						level.addElements(new Door(i, j, new ImageIcon("lorann\\sprite\\gate_closed.png").getImage()));
					}
					else if (c == '|') {
						level.addElements(new Wall(i, j, new ImageIcon("lorann\\sprite\\vertical_bone.png").getImage(), EWall.VERTICAL));
					}
					else if (c == 'L') {
						level.addElements(new Lorann(i, j, new ImageIcon("lorann\\sprite\\lorann_b.png").getImage()));
					}
					System.out.println(level.getElements()[i][j]);
				}


			}
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




}
