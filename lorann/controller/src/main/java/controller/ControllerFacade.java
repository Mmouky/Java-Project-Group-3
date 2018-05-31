package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.sql.SQLException;
import java.util.logging.Level;

import model.IModel;
import view.IView;
import model.*;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller
 * component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {

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

	/**
	 * Start.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void start() throws SQLException, IOException {

		model.getElement(model.readFile(5));
		view.addElement();

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


}
