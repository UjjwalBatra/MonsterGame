package model;

public class Wall extends Stationary {

    public Wall(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate, false);
    }

    @Override
    public void draw() {
        System.out.print("W");
    }

}
