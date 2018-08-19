package model;

public abstract class Entity {
    //current
    private int xCorrdinate;
    private int yCoordinate;

    public Entity(int xCorrdinate, int yCoordinate) {
        this.xCorrdinate = xCorrdinate;
        this.yCoordinate = yCoordinate;
    }

    public int getxCorrdinate() {
        return xCorrdinate;
    }

    public void setxCorrdinate(int xCorrdinate) {
        this.xCorrdinate = xCorrdinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public abstract void draw();
}
