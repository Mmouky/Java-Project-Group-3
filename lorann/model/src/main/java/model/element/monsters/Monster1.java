package model.element.monsters;

import java.awt.Image;


import model.*;
import model.element.Monster;
import model.element.characters.Lorann;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Monster1 extends Monster {

	public Monster1(int x, int y, Image sprite, ILevel level) {
		super(x, y, sprite, level);
	}

	private boolean isDetected() {
		return true;
	}

	;

	private void PathFinding() {

	}

	;

	private void Attack() {

	}

	;

	private void Sleep() {

	}
	;



    @Override
	public String toString() {
		return "Monstre 1";
	}

}
