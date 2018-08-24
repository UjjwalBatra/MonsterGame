package model;

public abstract class Movable extends Entity {


    public Movable(Map map, int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate);
        map.getMap()[xCorrdinate][yCoordinate] = this;
    }


    public abstract void move(Map map, String direction);

}
