package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.IElement;
import model.ILevel;
import showboard.BoardFrame;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView, KeyListener {

	private BoardFrame frame;
	private ILevel level;

	/**
	 * Instantiates a new view facade.
	 */
	public ViewFacade(final ILevel level) {
		frame = new BoardFrame("Lorann");
		frame.setDimension(new Dimension(20, 12));
		frame.setDisplayFrame(
				new Rectangle(0, 0, (int) frame.getDimension().getWidth(), (int) frame.getDimension().getHeight()));
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
	public void addElement(IElement element) {
		System.out.println(element);
		frame.addSquare(element, element.getX(), element.getY());
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
