package model;

import controller.Game;

public abstract class Movable extends Entity {

    public Movable(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate);
        Game.map.getMap()[xCorrdinate][yCoordinate] = this;
    }

    public abstract void move(String direction);

}
