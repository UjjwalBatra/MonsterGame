package controller;

import model.Map;
import model.Monster;
import model.Movable;
import model.Player;

public class Game
{


    public static void main(String[] args) {

        Map map = Map.getPlayingArea();
        Movable player = new Player(0 , 0);
        Movable monster = new Monster(4, 4);

        map.drawMap();

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
