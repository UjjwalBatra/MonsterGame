package server.model;

import server.exception.ObjectHittingWallException;
import server.exception.ObjectOutOfMapException;
import server.exception.PlayerDeadException;

public abstract class Movable extends Entity {


    public Movable(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate);
        Map.getPlayingArea().getMap()[xCorrdinate][yCoordinate] = this;
    }

    public void move(String direction) throws ObjectOutOfMapException, ObjectHittingWallException, InterruptedException, PlayerDeadException {

        int xCoordinateNew = 0;
        int yCoordinateNew = 0;

        if (direction.equals("left")) {
            xCoordinateNew = getXCorrdinate() - 1;
            yCoordinateNew = getYCoordinate();
        } else if (direction.equals("right")) {
            xCoordinateNew = getXCorrdinate() + 1;
            yCoordinateNew = getYCoordinate();
        } else if (direction.equals("up")) {
            xCoordinateNew = getXCorrdinate();
            yCoordinateNew = getYCoordinate() - 1;
        } else if (direction.equals("down")) {
            xCoordinateNew = getXCorrdinate();
            yCoordinateNew = getYCoordinate() + 1;
        } else return;


        //with these conditions, player/monster will pass through the middle block on map on each side
        if ((getXCorrdinate() == 0 && getYCoordinate() == 4) && (xCoordinateNew == -1 && yCoordinateNew == 4)) {
            xCoordinateNew = 8;
            yCoordinateNew = 4;
        }

        if ((getXCorrdinate() == 8 && getYCoordinate() == 4) && (xCoordinateNew == 9 && yCoordinateNew == 4)) {
            xCoordinateNew = 0;
            yCoordinateNew = 4;
        }

        if ((getXCorrdinate() == 4 && getYCoordinate() == 0) && (xCoordinateNew == 4 && yCoordinateNew == -1)) {
            xCoordinateNew = 4;
            yCoordinateNew = 8;
        }

        if ((getXCorrdinate() == 4 && getYCoordinate() == 8) && (xCoordinateNew == 4 && yCoordinateNew == 9)) {
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
            Monster.getMonster().eat(getYCoordinate(), getXCorrdinate());
            Map.getPlayingArea().drawMap();

            //initiate player death sequence if any
            throw new PlayerDeadException(((Player) this).name + " died at time");

        } else if (this instanceof Monster && nextCell instanceof Player) {
            ((Monster) this).eat(xCoordinateNew, yCoordinateNew);
        }

        // moving it forward on the map
        Map.getPlayingArea().getMap()[yCoordinateNew][xCoordinateNew] = this;

        //making old position of player a cell again
        Map.getPlayingArea().getMap()[getYCoordinate()][getXCorrdinate()] = new Cell(getXCorrdinate(), getYCoordinate());

        //updating coordinates
        this.setxCoordinate(xCoordinateNew);
        this.setyCoordinate(yCoordinateNew);

        Map.getPlayingArea().drawMap();

        Thread.sleep(500);
    }

}
