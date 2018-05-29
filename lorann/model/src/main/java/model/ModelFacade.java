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
						level.addElements(new Wall(i, j, null, EWall.HORIZONTAL));
					}
					else if (c == 'O') {
						level.addElements(new Wall(i, j, null, EWall.CORNER));
					}
					else if (c == 'B') {
						level.addElements(new EnergyBall(i, j, null));
					}
					else if (c == 'M') {
						level.addElements(new Money(i, j, null));
					}
					else if (c == '2') {
						level.addElements(new Monster2(i, j, null));
					}
					else if (c == '1') {
						level.addElements(new Monster1(i, j, null));
					}
					else if (c == '3') {
						level.addElements(new Monster3(i, j, null));
					}
					else if (c == '4') {
						level.addElements(new Monster4(i, j, null));
					}
					else if (c == 'D') {
						level.addElements(new Door(i, j, null));
					}
					else if (c == '|') {
						level.addElements(new Wall(i, j, null, EWall.VERTICAL));
					}
					else if (c == 'L') {
						level.addElements(new Lorann(i, j, null));
					}
					System.out.println(level.getElements()[i][j]);
				}


			}
			System.out.println("ca compile");

		}


/*
		for (int i = 0; i < txt.length(); i++) {
			char c = txt.charAt(i);

			if (c == 'x') {
				System.out.println("Empty");
			}
			else if (c == '-') {
				System.out.println("Wall");
			}
			else if (c == 'O') {
				System.out.println("Corner");
			}
			else if (c == 'B') {
				System.out.println("Energy Ball");
			}
			else if (c == 'M') {
				System.out.println("Money");
			}
			else if (c == '2') {
				System.out.println("Monster");
			}
			else if (c == '1') {
				System.out.println("Monster");
			}
			else if (c == '3') {
				System.out.println("Monster");
			}
			else if (c == '4') {
				System.out.println("Monster");
			}
			else if (c == 'D') {
				System.out.println("Door");
			}
			else if (c == '|') {
				System.out.println("Wall");
			}
			else if (c == 'L') {
				System.out.println("Lorann");
			}
		}
*/


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
