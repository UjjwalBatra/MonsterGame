package model;

import exception.GameException;
import exception.ObjectHittingWallException;
import exception.ObjectOutOfMapException;
import exception.PlayerDeadException;

import java.rmi.RemoteException;

public abstract class Movable extends Entity implements RemotePlayer{
    public Movable() {
    }

    public Movable(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        Map.getPlayingArea().getMap()[xCoordinate][yCoordinate] = this;
    }

    synchronized public void move(String direction) throws RemoteException, GameException, InterruptedException {

        int xCoordinateNew = 0;
        int yCoordinateNew = 0;

        if (direction.equals("left")) {
            xCoordinateNew = getXCoordinate() - 1;
            yCoordinateNew = getYCoordinate();
        } else if (direction.equals("right")) {
            xCoordinateNew = getXCoordinate() + 1;
            yCoordinateNew = getYCoordinate();
        } else if (direction.equals("up")) {
            xCoordinateNew = getXCoordinate();
            yCoordinateNew = getYCoordinate() - 1;
        } else if (direction.equals("down")) {
            xCoordinateNew = getXCoordinate();
            yCoordinateNew = getYCoordinate() + 1;
        } else return;


        //with these conditions, player/monster will pass through the middle block on map on each side
        if ((getXCoordinate() == 0 && getYCoordinate() == 4) && (xCoordinateNew == -1 && yCoordinateNew == 4)) {
            xCoordinateNew = 8;
            yCoordinateNew = 4;
        }

        if ((getXCoordinate() == 8 && getYCoordinate() == 4) && (xCoordinateNew == 9 && yCoordinateNew == 4)) {
            xCoordinateNew = 0;
            yCoordinateNew = 4;
        }

        if ((getXCoordinate() == 4 && getYCoordinate() == 0) && (xCoordinateNew == 4 && yCoordinateNew == -1)) {
            xCoordinateNew = 4;
            yCoordinateNew = 8;
        }

        if ((getXCoordinate() == 4 && getYCoordinate() == 8) && (xCoordinateNew == 4 && yCoordinateNew == 9)) {
            xCoordinateNew = 4;
            yCoordinateNew = 0;
        }

        //check if it moved out of the map
        if (xCoordinateNew < 0 || yCoordinateNew < 0 || xCoordinateNew > 8 || yCoordinateNew > 8)
            throw new ObjectOutOfMapException("Object Running Out of the Map");

        //check if new coordinate is a cell
        if (Map.getPlayingArea().getMap()[xCoordinateNew][yCoordinateNew] instanceof Wall)
            throw new ObjectHittingWallException("Object is trying to enter a wall.");


        //if it is a monster runnig over a player then kill the player,
        //if it is a player running over a monster, then die.

        Entity nextCell = Map.getPlayingArea().getMap()[xCoordinateNew][yCoordinateNew];

        if (this instanceof Player && nextCell instanceof Monster) {
            Monster.getMonster().eat(getYCoordinate(), getXCoordinate());
            Map.getPlayingArea().drawMap();

            //initiate player death sequence if any
            throw new PlayerDeadException(((Player) this).name + " died at time");

        } else if (this instanceof Monster && nextCell instanceof Player) {
            ((Monster) this).eat(xCoordinateNew, yCoordinateNew);
        }

        // moving it forward on the map
        Map.getPlayingArea().getMap()[yCoordinateNew][xCoordinateNew] = this;

        //making old position of player a cell again
        Map.getPlayingArea().getMap()[getYCoordinate()][getXCoordinate()] = new Cell(getXCoordinate(), getYCoordinate());

        //updating coordinates
        this.setxCoordinate(xCoordinateNew);
        this.setyCoordinate(yCoordinateNew);

        Map.getPlayingArea().drawMap();

        Thread.sleep(500);
    }

}
