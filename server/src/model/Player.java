package model;

public class Player extends Movable  {

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
