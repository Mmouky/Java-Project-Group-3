package view;

import showboard.BoardFrame;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IView {

	/**
	 * Display message.
	 *
	 * @param message
	 *            the message
	 */
	void displayMessage(String message);

	/**
	 * Add an element to the frame
	 */
	void addElement();

	/**
	 * Get the frame
	 * @return BoardFrame
	 */
	BoardFrame getFrame();
	
}
