package controller;

import java.io.IOException;
import java.sql.SQLException;

import model.IModel;
import view.IView;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
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
		view.getFrame().addKeyListener(model);
	}

	/**
	 * Start.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void start() throws SQLException, IOException {

		model.addElementToLevel(model.readFile(6));
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
