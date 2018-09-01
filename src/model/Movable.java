package model;

public abstract class Movable extends Entity {


    public Movable(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate);
        Map.getPlayingArea().getMap()[xCorrdinate][yCoordinate] = this;
    }

    public void move(String direction) {

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

        //check if it moved out of the map
        if (xCoordinateNew < 0 || yCoordinateNew < 0 || xCoordinateNew > 8 || yCoordinateNew > 8 ) return;

        //check if new coordinate is a cell
        if (Map.getPlayingArea().getMap()[xCoordinateNew][yCoordinateNew] instanceof Wall) return;

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
