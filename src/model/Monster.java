package model;

public class Monster extends Movable {

    private static final Monster monster = new Monster(4,4);

    public Monster(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate);
    }

    public void start()
    {

    }
    @Override
    public void move(String direction) {

        Map map = Map.getPlayingArea();

        map.drawMap();
    }

    @Override
    public void draw() {
        System.out.print("M");
    }

    public static Monster getMonster() {
        return monster;
    }
}
