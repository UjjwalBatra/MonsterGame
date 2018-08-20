package model;

public class Player extends Movable {

    public Player(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate);
    }


    @Override
    public void move(Map map, int xCoordinateOld, int yCoordinateOld, int xCoordinateNew, int yCoordinateNew) {

    }

    @Override
    public void draw() {
        System.out.println("P");
    }
}
