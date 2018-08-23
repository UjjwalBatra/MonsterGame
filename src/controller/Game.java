package controller;

import model.Map;

import model.Monster;
import model.Movable;
import model.Player;

public class Game {



    public static void main(String[] args) {
        Map map = new Map();
        Movable player = new Player(map, 0,0);
        Movable monster = new Monster(map, 4,4);
        System.out.println("testing");
        map.drawMap();

    }
}
