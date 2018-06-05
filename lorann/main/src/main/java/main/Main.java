package main;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Scanner;

import controller.ControllerFacade;
import model.ModelFacade;
import model.Sound;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 3
 * @version 1.0
 */
public abstract class Main {

	/**
	 * The main method.
	 *
	 * @throws IOException
	 *             the IO Exception
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) throws IOException {

		ModelFacade model = new ModelFacade();

		System.out.println("Choose a level :");
		int sc = new Scanner(System.in).nextInt();
		System.out.println("Game starting !");

		ViewFacade view = new ViewFacade(model.getLevel());
		final ControllerFacade controller = new ControllerFacade(view, model);
		try {
			controller.start(sc);
		} catch (final SQLException exception) {
			exception.printStackTrace();
		}
		model.addObserver(view.getFrame().getObserver());
	}

}
