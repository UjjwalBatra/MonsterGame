package model;

public abstract class Stationary extends Entity{

    private boolean passThrough;

    public Stationary(int xCorrdinate, int yCoordinate, boolean passThrough) {
        super(xCorrdinate, yCoordinate);
        this.passThrough = passThrough;
    }

    public boolean isPassThrough() {
        return passThrough;
    }

}
