package server.model;

public class Player extends Movable {

    String name;


    public Player(int xCorrdinate, int yCoordinate, String name) {
        super(xCorrdinate, yCoordinate);
        this.name = name;
    }

    public void deathSequence() {

    }

    @Override
    public void draw() {
        System.out.print("P");
    }
}
