package view;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.ILevel;
import model.IMobile;
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
	public ViewFacade(final ILevel level) {
		frame = new BoardFrame("Lorann");
		frame.setSize(1000, 700);
		frame.setDimension(new Dimension(20, 12));
		frame.setDisplayFrame(
				new Rectangle(0, 0, (int) frame.getDimension().getWidth(), (int) frame.getDimension().getHeight()));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
				System.out.println(level.getElements()[i][j]);
				frame.addSquare(level.getElements()[i][j], level.getElements()[i][j].getX(),
						level.getElements()[i][j].getY());
			}
		}

		for (IMobile monster : level.getMonsters()) {
			frame.addPawn(monster);
		}

		frame.addPawn(level.getSpell());

		frame.addPawn(level.getLorann());

		frame.repaint();

	}

	@Override
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

}
