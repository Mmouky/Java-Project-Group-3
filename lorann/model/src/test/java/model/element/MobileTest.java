package model.element;

import model.ILevel;
import model.Level;
import model.ModelFacade;
import model.element.characters.ELorann;
import model.element.characters.ESpell;
import model.element.characters.Lorann;
import model.element.characters.Spell;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class MobileTest {

    int xl = 10;
    int yl = 10;

    Lorann lorann;
    Image sprite;
    ILevel iLevel;
    ELorann eLorann;
    ESpell eSpell;
    ModelFacade model;

    @Before
    public void setUp() throws Exception {

        iLevel = new Level();
        model = new ModelFacade();
        iLevel.setLorann( new Lorann(xl,yl,sprite,iLevel, eLorann, model));
        iLevel.getMonsters().add(new Monster(xl,yl,sprite,iLevel, model));
        iLevel.getMonsters().add(new Monster(xl,yl,sprite,iLevel, model));
        iLevel.getMonsters().add(new Monster(xl,yl,sprite,iLevel, model));
        iLevel.getMonsters().add(new Monster(xl,yl,sprite,iLevel, model));
        iLevel.setSpell(new Spell(xl,yl,sprite, iLevel, eSpell, eLorann, model));


        sprite = new ImageIcon(model.lorann_b).getImage();
        lorann = new Lorann(xl,yl,sprite,iLevel, eLorann, model);

        lorann.setX(xl);
        lorann.setY(yl);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isLorannMovingDown() {
        lorann.moveDown();
        if (lorann.getY() == yl ){
            System.out.println("HE HASEN'T MOOOVE");
        }else {
            System.out.println("HE HAS MOOVE");
        }
    }

    @Test
    public void isLorannMovingUp() {
        lorann.moveUp();
        if (lorann.getY() == yl ){
            System.out.println("HE HASEN'T MOOOVE");
        }else {
            System.out.println("HE HAS MOOVE");
        }
    }

    @Test
    public void isLorannMovingRight() {
        lorann.moveRight();
        if (lorann.getX() == xl){
            System.out.println("HE HASEN'T MOOOVE");
        }else {
            System.out.println("HE HAS MOOVE");
        }
    }

    @Test
    public void isLorannMovingLeft() {
        lorann.moveLeft();
        if (lorann.getX() == xl){
            System.out.println("HE HASEN'T MOOOVE");
        }else {
            System.out.println("HE HAS MOOVE");
        }
    }
}