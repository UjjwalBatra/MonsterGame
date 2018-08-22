package model;

public abstract class Movable extends Entity {

    public Movable(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate);
    }

    public abstract void move(Map map, String direction);

}
