package model;

public class Player extends Movable {

    public Player(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate);
    }


    @Override
    public void move(Map map, int xCoordinateOld, int yCoordinateOld, int xCoordinateNew, int yCoordinateNew) {

        // moving player forward on the map
        map.getMap()[xCoordinateNew][yCoordinateNew] = map.getMap()[xCoordinateOld][yCoordinateOld];

        //setting new coordinates of the player
        this.setxCorrdinate(xCoordinateNew);
        this.setyCoordinate(yCoordinateNew);

        //making old position of player a cell again
        map.getMap()[xCoordinateOld][yCoordinateOld] = new Cell(xCoordinateOld,yCoordinateOld);
    }

    @Override
    public void draw() {
        System.out.println("P");
    }
}
