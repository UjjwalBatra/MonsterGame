package model;

public class Player extends Movable {

    public Player(Map map, int xCorrdinate, int yCoordinate) {
        super(map, xCorrdinate, yCoordinate);
    }

    @Override
    public void move(Map map, String direction) {

        int xCoordinateNew = 0;
        int yCoordinateNew = 0;

        if (direction.equals("left")){
            xCoordinateNew = getxCorrdinate();
            yCoordinateNew = getyCoordinate() - 1;
            System.out.println(xCoordinateNew + ", " + yCoordinateNew);
        } else if (direction.equals("right")){
            xCoordinateNew = getxCorrdinate();
            yCoordinateNew = getyCoordinate() + 1;
            System.out.println(xCoordinateNew + ", "  + yCoordinateNew);
        } else if (direction.equals("up")){
            xCoordinateNew = getxCorrdinate() - 1;
            yCoordinateNew = getyCoordinate();
            System.out.println(xCoordinateNew + ", "  + yCoordinateNew);
        } else if (direction.equals("down")){
            xCoordinateNew = getxCorrdinate() + 1;
            yCoordinateNew = getyCoordinate();
            System.out.println(xCoordinateNew + ", "  + yCoordinateNew);
        } else return;

        //check if player moved out of the map
        if (xCoordinateNew < 0 || yCoordinateNew < 0 || xCoordinateNew > 8 || yCoordinateNew > 8 ) return;

        //check if new coordinate is a cell
        if (map.getMap()[xCoordinateNew][yCoordinateNew] instanceof Wall) return;

        // moving player forward on the map
        map.getMap()[xCoordinateNew][yCoordinateNew] = this;

        //making old position of player a cell again
        map.getMap()[getxCorrdinate()][getyCoordinate()] = new Cell(getxCorrdinate(),getyCoordinate());

        //updating coordinates of the player
        this.setxCorrdinate(xCoordinateNew);
        this.setyCoordinate(yCoordinateNew);

        map.drawMap();

    }

    @Override
    public void draw() {
        System.out.print("P");
    }
}
