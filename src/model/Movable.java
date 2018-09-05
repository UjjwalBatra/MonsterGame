package model;

import model.exception.ObjectHittingWallException;
import model.exception.ObjectOutOfMapException;

public abstract class Movable extends Entity {


    public Movable(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate);
        Map.getPlayingArea().getMap()[xCorrdinate][yCoordinate] = this;
    }

    public void move(String direction) throws ObjectOutOfMapException, ObjectHittingWallException {

        int xCoordinateNew = 0;
        int yCoordinateNew = 0;

        if (direction.equals("left")){
            xCoordinateNew = getxCorrdinate();
            yCoordinateNew = getyCoordinate() - 1;
        } else if (direction.equals("right")){
            xCoordinateNew = getxCorrdinate();
            yCoordinateNew = getyCoordinate() + 1;
        } else if (direction.equals("up")){
            xCoordinateNew = getxCorrdinate() - 1;
            yCoordinateNew = getyCoordinate();
        } else if (direction.equals("down")){
            xCoordinateNew = getxCorrdinate() + 1;
            yCoordinateNew = getyCoordinate();
        } else return;

        if ((getxCorrdinate() == 4 && getyCoordinate() == 0) && (xCoordinateNew == 4 && yCoordinateNew == -1)) {
            xCoordinateNew = 4;
            yCoordinateNew = 8;
        }

        if ((getxCorrdinate() == 4 && getyCoordinate() == 8) && (xCoordinateNew == 4 && yCoordinateNew == 9)) {
            xCoordinateNew = 4;
            yCoordinateNew = 0;
        }

        if ((getxCorrdinate() == 0 && getyCoordinate() == 4) && (xCoordinateNew == -1 && yCoordinateNew == 4)) {
            xCoordinateNew = 8;
            yCoordinateNew = 4;
        }

        if ((getxCorrdinate() == 8 && getyCoordinate() == 4) && (xCoordinateNew == 9 && yCoordinateNew == 4)) {
            xCoordinateNew = 0;
            yCoordinateNew = 4;
        }

        //check if it moved out of the map
        if (xCoordinateNew < 0 || yCoordinateNew < 0 || xCoordinateNew > 8 || yCoordinateNew > 8 ) throw new ObjectOutOfMapException("Object Running Out of the Map");

        //check if new coordinate is a cell
        if (Map.getPlayingArea().getMap()[xCoordinateNew][yCoordinateNew] instanceof Wall) throw  new ObjectHittingWallException("Object is trying to enter a wall.");

        // moving it forward on the map
        Map.getPlayingArea().getMap()[xCoordinateNew][yCoordinateNew] = this;

        //making old position of player a cell again
        Map.getPlayingArea().getMap()[getxCorrdinate()][getyCoordinate()] = new Cell(getxCorrdinate(),getyCoordinate());

        //updating coordinates
        this.setxCorrdinate(xCoordinateNew);
        this.setyCoordinate(yCoordinateNew);

        Map.getPlayingArea().drawMap();

    }

}
