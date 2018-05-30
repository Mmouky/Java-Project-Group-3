package view;

import model.ILevel;
import showboard.BoardFrame;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {

	private BoardFrame frame;
	private ILevel level;

	/**
	 * Instantiates a new view facade.
	 */
	public ViewFacade(ILevel level) {
		frame = new BoardFrame("Lorann");
		this.level = level;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.IView#displayMessage(java.lang.String)
	 */

	public BoardFrame getFrame() {
		return frame;
	}

	public void setFrame(BoardFrame frame) {
		this.frame = frame;
	}

	@Override
	public void displayMessage(String message) {
		//frame.addSquare(level.getElements()[0][0], 0, 0);
	}

}
