package model;

import java.io.Serializable;

public class Cell extends Stationary implements Serializable {

    public Cell(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate, true);
    }

    @Override
    public void draw() {
        System.out.print("=");
    }

}
