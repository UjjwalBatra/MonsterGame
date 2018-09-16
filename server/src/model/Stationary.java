package model;

public abstract class Stationary extends Entity{

    private boolean passThrough;

    public Stationary(int xCoordinate, int yCoordinate, boolean passThrough) {
        super(xCoordinate, yCoordinate);
        this.passThrough = passThrough;
    }

    public boolean isPassThrough() {
        return passThrough;
    }

}
