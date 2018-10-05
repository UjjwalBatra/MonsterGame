package model;

import java.io.Serializable;

public class Player extends Movable implements Serializable {

    private String name;

    public Player(int xCoordinate, int yCoordinate, String name) {
        super(xCoordinate, yCoordinate);
        this.name = name;
    }

    public void deathSequence() {

    }

    public String getName() {
        return name;
    }

    @Override
    public void draw() {
        System.out.print("P");
    }

}
