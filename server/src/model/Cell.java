package model;

public class Cell extends Stationary {

    public Cell(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate, true);
    }

    @Override
    public void draw() {
        System.out.print("=");
    }

    @Override
    public void move(String direction) throws Exception {

    }
}
