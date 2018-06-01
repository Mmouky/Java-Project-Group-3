package view;

import model.IElement;
import showboard.BoardFrame;

import java.awt.*;

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
    void addElement();

    BoardFrame getFrame();
}
