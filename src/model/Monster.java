package model;

public class Monster extends Movable {

    public Monster(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate);
    }


    public void start()
    {

    }
    @Override
    public void move(String direction) {

    }

    @Override
    public void draw() {
        System.out.print("M");
    }
}
