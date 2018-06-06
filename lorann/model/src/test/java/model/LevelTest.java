package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LevelTest {

    protected int score = 0;
    Level level;

    @Before
    public void setUp() throws Exception {
        level = new Level();
        level.setScore(0);

        IElement[][] elements = new IElement[12][20];
        level.setElements(elements);
    }

    @Test
    public void setScore() {
        assertEquals("Test the score", this.score, level.getScore());
    }

    @Test
    public void isTheElementIsNotNull() {
        assertNotNull("The Array is not null", level.getElements());
    }

    @Test
    public void setSpell() {
    }
}