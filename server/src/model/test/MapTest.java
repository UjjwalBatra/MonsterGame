/*
 *
 * @project - MonsterGame
 * @author - ujjwalbatra on 22/08/18
 *
 */
package model.test;


import model.Cell;
import model.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    Map map;

    @BeforeEach
    public void setUp() {
        map = Map.getPlayingArea();
    }

    @Test
    public void checkPaths(){
        for (int j = 0; j < map.getMap()[0].length; j++) {
                assertTrue(map.getMap()[0][j] instanceof Cell);
        }
        for (int j = 0; j < map.getMap()[4].length; j++) {
                assertTrue(map.getMap()[4][j] instanceof Cell);
        }
        for (int j = 0; j < map.getMap()[8].length; j++) {
                assertTrue(map.getMap()[8][j] instanceof Cell);
        }
        for (int i = 0; i < map.getMap().length; i++) {
                assertTrue(map.getMap()[i][0] instanceof Cell);
        }
        for (int i = 0; i < map.getMap().length; i++) {
                assertTrue(map.getMap()[i][4] instanceof Cell);
        }
        for (int i = 0; i < map.getMap().length; i++) {
            assertTrue(map.getMap()[i][8] instanceof Cell);
        }

    }

    @Test
    public void checkWalls(){
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                assertTrue(map.getMap()[i][8] instanceof Cell);
            }
        }
        for (int i = 5; i < 8; i++) {
            for (int j = 1; j < 4; j++) {
                assertTrue(map.getMap()[i][8] instanceof Cell);
            }
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 5; j < 8; j++) {
                assertTrue(map.getMap()[i][8] instanceof Cell);
            }
        }
        for (int i = 5; i < 8; i++) {
            for (int j = 5; j < 8; j++) {
                assertTrue(map.getMap()[i][8] instanceof Cell);
            }
        }
    }

    @AfterEach
    public void tearDown() {
    }
}