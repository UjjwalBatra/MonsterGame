package controller;

import model.Map;
import model.Monster;
import model.Movable;
import model.Player;

public class Game
{


    public static void main(String[] args) {

        Map map = new Map();
        Movable player = new Player(map, 0 , 0);
        Movable monster = new Monster(map, 4, 4);

        new KeyPressAction(map, monster, player);

        Runnable runnable = new Runnable() {

            @Override
            public void run() {

                ((Monster) monster).start();
            }
        };

        runnable.run();
        
    }
}
