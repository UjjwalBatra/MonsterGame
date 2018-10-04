package model;

import java.io.Serializable;

public class Wall extends Stationary implements Serializable {

    public Wall(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate, false);
    }

    @Override
    public void draw() {
        System.out.print("W");
    }

}
