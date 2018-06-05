package model;

import model.element.wall.EWall;
import model.element.wall.Wall;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ElementTest {

    Element element;
    Image sprite;
    EWall eWall;
    Wall wall;
    int x = 0;
    int y = 0;


    @Before
    public void setUp() throws Exception {
        sprite = new ModelFacade().vertical_bone;
        wall = new Wall(10,5, sprite, eWall);
        System.out.println("I am the set-up");
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isTheElementGetTheSpriteReturnTrue() {
        if(sprite != null){
            System.out.println("There is a Sprite");
        }else{
            System.out.println("There's no Sprite");
        }
    }

    @Test
    public void isThePositionIsTheSame() {
        // wall = new Wall(10,5, sprite, eWall);

        if(wall.getX() == x){
            System.out.println("Ther is a wall");
        }else{
            System.out.println("There isn't a wall");
        }
    }
}