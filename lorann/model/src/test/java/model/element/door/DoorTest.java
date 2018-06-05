package model.element.door;

import model.Level;
import model.ModelFacade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class DoorTest {

    Door door;
    Door doorO;
    Image sprite;
    EDoor eDoor;
    ModelFacade modelFacade;

    @Before
    public void setUp() throws Exception {
        modelFacade = new ModelFacade();
        door = new Door(0,0, sprite, eDoor, modelFacade);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isTheDooorClose() throws Exception{
        door.seteDoor(EDoor.CLOSE);
      if(door.geteDoor() == EDoor.CLOSE){
          System.out.println("It's Close !");
      }else{
          System.out.println("It's Not Close");
      }
    }

    @Test
    public void isTheDoorOpen() throws Exception {
        door.seteDoor(EDoor.OPEN);
        if(door.geteDoor() == EDoor.OPEN){
            System.out.println("It's Open !");
        }else{
            System.out.println("It's Not Open");
        }
    }
}