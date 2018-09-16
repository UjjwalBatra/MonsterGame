package server.model;

public class Cell extends Stationary {

    public Cell(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate, true);
    }

    @Override
    public void draw() {
        System.out.print("=");
    }
}
