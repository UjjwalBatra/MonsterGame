package model;

public abstract class Movable extends Entity {

    public Movable(Entity currentPosition) {
        super(currentPosition);
    }

    public abstract void move(Entity oldPosition, Entity newPosition);

}
