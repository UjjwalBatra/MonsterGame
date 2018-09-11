package model;

public class Player extends Movable {


    public Player(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate);
    }


    @Override
    public void draw() {
        System.out.print("P");
    }
}
