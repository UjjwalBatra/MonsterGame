package model;

public class Monster extends Movable {

    public Monster(Map map, int xCorrdinate, int yCoordinate) {
        super(map, xCorrdinate, yCoordinate);
    }


    public void start()
    {

    }
    @Override
    public void move(Map map, String direction) {

        map.drawMap();
    }

    @Override
    public void draw() {
        System.out.print("M");
    }
}
