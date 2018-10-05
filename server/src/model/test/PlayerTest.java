
/*
 *
 * @project - MonsterGame
 * @author - ujjwalbatra on 22/08/18
 *
 */

package model.test;
import exception.ObjectHittingWallException;
import exception.ObjectOutOfMapException;
import model.Cell;
import model.Map;
import model.Movable;
import model.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Map map;
    Movable player;

    @BeforeEach
    void setUp() {
        map = Map.getPlayingArea();
        player = new Player(0, 0, "chunmun");
    }

    @Test
    public void checkPlayerMovement() throws RemoteException {

        player.setxCoordinate(4);
        player.setyCoordinate(4);

        assertThrows(ObjectHittingWallException.class, () -> {
           player.move("right");

           assertEquals(5, player.getYCoordinate());
           assertEquals(4, player.getXCoordinate());

           assertTrue(map.getMap()[4][4] instanceof Cell);
           assertTrue(map.getMap()[4][5] instanceof Player);

           player.move("left");
           player.move("left");

           assertTrue(map.getMap()[4][4] instanceof Cell);
           assertTrue(map.getMap()[4][5] instanceof Cell);
           assertTrue(map.getMap()[4][3] instanceof Player);

           player.move("right");
           player.move("down");

           assertTrue(map.getMap()[4][3] instanceof Cell);
           assertTrue(map.getMap()[4][4] instanceof Cell);
           assertTrue(map.getMap()[5][4] instanceof Player);

           player.move("up");
           player.move("up");

       });


        assertTrue(map.getMap()[5][4] instanceof Cell);
        assertTrue(map.getMap()[4][4] instanceof Cell);
        assertTrue(map.getMap()[3][4] instanceof Player);
    }

    @Test
    public void checkIfPlayerRunOutOfMap() {

        assertThrows(ObjectOutOfMapException.class, () ->{
            player.move("left");
        });

        assertEquals(0, player.getYCoordinate());
        assertEquals(0, player.getXCoordinate());
    }

    @Test
    public void checkIfPlayerRunIntoWall(){

        assertThrows(ObjectHittingWallException.class, () ->{
            player.move("right");
            player.move("down");

            assertEquals(1, player.getYCoordinate());
            assertEquals(0, player.getXCoordinate());

            player.move("down");
            player.move("down");
            player.move("down");
        });

        assertEquals(1, player.getYCoordinate());
        assertEquals(0, player.getXCoordinate());

    }

    @AfterEach
    void tearDown() {
    }
}