package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.IElement;
import model.ILevel;
import model.IMobile;
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
		frame.addKeyListener(this);
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
	public void addElement() {
		for (int i = 0; i < level.getElements().length; i++) {
			for (int j = 0; j < level.getElements()[i].length; j++) {
				frame.addSquare(level.getElements()[i][j], level.getElements()[i][j].getX(),
						level.getElements()[i][j].getY());
			}
		}

		frame.addPawn(level.getLorann());
		frame.addPawn(level.getMonster1());
		frame.addPawn(level.getMonster2());
		frame.addPawn(level.getMonster3());
		frame.addPawn(level.getMonster4());

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			level.getLorann().moveRight();
			frame.repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			level.getLorann().moveUp();
			frame.repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			level.getLorann().moveDown();
			frame.repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			level.getLorann().moveLeft();
			frame.repaint();
		}
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
