package model;

public abstract class Movable extends Entity {


    public Movable(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate);
        Map.getPlayingArea().getMap()[xCorrdinate][yCoordinate] = this;
    }


    public abstract void move(String direction);

}
