package model;

public class Map {
    private Entity map[][];

    public Map() {
        map = new Entity[9][9];
        addEdgesAndWalls();
    }

    //adding edges and walls to the map
    private void addEdgesAndWalls() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == 0 || j == 0 || i == 8 || j == 8 || i == 4 || j == 4) map[i][j] = new Cell(i, j);
                else map[i][j] = new Wall(i, j);
            }
        }
    }

    public Entity[][] getMap() {
        return map;
    }

    //printing current position of player/monster/map on console
    public void drawMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j].draw();
            }
            System.out.println();
        }
    }
}
