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
        Movable monster = Monster.getMonster();

        map.drawMap();

        new KeyPressAction(player);


        Runnable runnable = new Runnable() {

            @Override
            public void run() {

                ((Monster) monster).start();
            }
        };

        runnable.run();
        
    }
}
