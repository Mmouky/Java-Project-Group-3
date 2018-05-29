package model;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

import model.dao.ExampleDAO;


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
