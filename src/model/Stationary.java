package model;

public abstract class Stationary extends Entity{

    private boolean passThrough;

    public Stationary(Entity currentPosition, boolean passThrough) {
        super(currentPosition);
        this.passThrough = passThrough;
    }


}
