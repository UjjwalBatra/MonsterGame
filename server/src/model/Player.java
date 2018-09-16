package model;

public class Player extends Movable {

    String name;

    public Player() {}

    public Player(int xCoordinate, int yCoordinate, String name) {
        super(xCoordinate, yCoordinate);
        this.name = name;
    }

    public void deathSequence() {

    }

    @Override
    public void draw() {
        System.out.print("P");
    }
}
