package model;

import java.io.Serializable;

public class Monster extends Movable implements Serializable {

    private Entity player;
    private static final Monster monster = new Monster(4, 4);

    public Monster(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
    }

    public void start() {
        // scan the map, find the player
        //        call shortest path
        //    call move

    }

    public void eat(int y, int x ) {
        Map.getPlayingArea().getMap()[y][x] = new Cell(y, x);
        Map.getPlayingArea().drawMap();
    }


    @Override
    public void draw() {
        System.out.print("M");
    }

    public static Monster getMonster() {
        return monster;
    }
}
