package model;

public class Player extends Movable {

    public Player(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate);
    }


    @Override
    public void move(Map map, String direction) {

        int xCoordinateNew;
        int yCoordinateNew;

        if (direction.equals("left")){
            xCoordinateNew = getxCorrdinate();
            yCoordinateNew = getyCoordinate() - 1;
        } else if (direction.equals("right")){
            xCoordinateNew = getxCorrdinate();
            yCoordinateNew = getyCoordinate() + 1;
        } else if (direction.equals("up")){
            xCoordinateNew = getxCorrdinate() + 1;
            yCoordinateNew = getyCoordinate();
        } else {
            xCoordinateNew = getxCorrdinate();
            yCoordinateNew = getyCoordinate() - 1;
        }
        // moving player forward on the map
        map.getMap()[xCoordinateNew][yCoordinateNew] = this;

        //making old position of player a cell again
        map.getMap()[getxCorrdinate()][getyCoordinate()] = new Cell(getxCorrdinate(),getyCoordinate());

        //updating coordinates of the player
        this.setxCorrdinate(xCoordinateNew);
        this.setyCoordinate(yCoordinateNew);


    }

    @Override
    public void draw() {
        System.out.println("P");
    }
}
