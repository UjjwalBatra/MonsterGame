package model;

public class Player extends Movable {

    public Player(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate);
    }


    @Override
    public void move(Map map, int xCoordinateNew, int yCoordinateNew) {

        // moving player forward on the map
        map.getMap()[xCoordinateNew][yCoordinateNew] = this;

        //making old position of player a cell again
        map.getMap()[getxCorrdinate()][getyCoordinate()] = new Cell(getxCorrdinate(),getyCoordinate());

        //updating coordinates of the player
        this.setxCorrdinate(xCoordinateNew);
        this.setyCoordinate(yCoordinateNew);


    }

    @Override
    public void draw() {
        System.out.println("P");
    }
}
