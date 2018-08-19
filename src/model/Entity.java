package model;

public abstract class Entity {

    private Entity currentPosition = null;

    public Entity(Entity currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Entity getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Entity currentPosition) {
        this.currentPosition = currentPosition;
    }

    public abstract void draw();
}
