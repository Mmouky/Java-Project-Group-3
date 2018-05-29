package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.sql.SQLException;

import model.IModel;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller
 * component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController, KeyListener {

	/** The view. */
	private final IView view;

	/** The model. */
	private final IModel model;

	/**
	 * Instantiates a new controller facade.
	 *
	 * @param view
	 *            the view
	 * @param model
	 *            the model
	 */
	public ControllerFacade(final IView view, final IModel model) {
		this.view = view;
		this.model = model;

	}

	public String readFile(int id) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(model.getEntryById(id)));
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "ERROR";

	}

	public void getElement(String txt) {

		for (int i = 0; i < txt.length(); i++) {
			char c = txt.charAt(i);

			if (c == 'X') {
				System.out.println("Empty");
			}
		}

	}

	/**
	 * Start.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void start() throws SQLException {
		getElement(readFile(1));
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public IView getView() {
		return this.view;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public IModel getModel() {
		return this.model;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
