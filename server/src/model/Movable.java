package model;

import exception.*;

import java.io.Serializable;
import java.rmi.RemoteException;

public abstract class Movable extends Entity  {

    private Map map;
    private Entity entity[][];
    private Monster monster = Monster.getMonster();

    public Movable(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);

        this.map = Map.getPlayingArea();
        entity = this.map.getMap();


        this.entity[xCoordinate][yCoordinate] = this;
    }

    synchronized public void move(String direction) throws RemoteException, GameException, InterruptedException, PlayerRunningOverPlayerException {

        int xCoordinateNew;
        int yCoordinateNew;
        int xCoordinate = this.getXCoordinate();
        int yCoordinate = this.getYCoordinate();

        if (direction.equals("left")) {
            xCoordinateNew = xCoordinate - 1;
            yCoordinateNew = yCoordinate;
        } else if (direction.equals("right")) {
            xCoordinateNew = xCoordinate + 1;
            yCoordinateNew = yCoordinate;
        } else if (direction.equals("up")) {
            xCoordinateNew = xCoordinate;
            yCoordinateNew = yCoordinate - 1;
        } else if (direction.equals("down")) {
            xCoordinateNew = xCoordinate;
            yCoordinateNew = yCoordinate + 1;
        } else return;


        //with these conditions, player/monster will pass through the middle block on map on each side
        if ((xCoordinate == 0 && yCoordinate == 4) && (xCoordinateNew == -1 && yCoordinateNew == 4)) {
            xCoordinateNew = 8;
            yCoordinateNew = 4;
        }

        if ((xCoordinate == 8 && yCoordinate == 4) && (xCoordinateNew == 9 && yCoordinateNew == 4)) {
            xCoordinateNew = 0;
            yCoordinateNew = 4;
        }

        if ((xCoordinate == 4 && yCoordinate == 0) && (xCoordinateNew == 4 && yCoordinateNew == -1)) {
            xCoordinateNew = 4;
            yCoordinateNew = 8;
        }

        if ((xCoordinate == 4 && yCoordinate == 8) && (xCoordinateNew == 4 && yCoordinateNew == 9)) {
            xCoordinateNew = 4;
            yCoordinateNew = 0;
        }

        //check if it moved out of the map
        if (xCoordinateNew < 0 || yCoordinateNew < 0 || xCoordinateNew > 8 || yCoordinateNew > 8)
            throw new ObjectOutOfMapException("Object Running Out of the Map");

        //check if new coordinate is a cell
        if (entity[xCoordinateNew][yCoordinateNew] instanceof Wall)
            throw new ObjectHittingWallException("Object is trying to enter a wall.");


        //if it is a monster runnig over a player then kill the player,
        //if it is a player running over a monster, then die.
        //stop player from running into another player
        Entity nextCell = entity[xCoordinateNew][yCoordinateNew];

        if (this instanceof Player && nextCell instanceof Monster) {
            monster.eat(xCoordinate, yCoordinate);
            map.drawMap();

            //initiate player death sequence if any
            throw new PlayerDeadException(((Player) this).getName() + " died at time");

        } else if (this instanceof Monster && nextCell instanceof Player) {
            ((Monster) this).eat(xCoordinateNew, yCoordinateNew);
        } else if (nextCell instanceof Player)
            throw new PlayerRunningOverPlayerException("Player is running over another player");

        // moving it forward on the map
        entity[yCoordinateNew][xCoordinateNew] = this;

        //making old position of player a cell again
        entity[yCoordinate][xCoordinate] = new Cell(xCoordinate, yCoordinate);

        //updating coordinates
        this.setxCoordinate(xCoordinateNew);
        this.setyCoordinate(yCoordinateNew);

        map.drawMap();

        Thread.sleep(500);
    }


}
