package controller;

import model.*;

public class Game
{

    public static void main(String[] args) {

        Map map = Map.getPlayingArea();
        Entity player1 = new Player(0 , 0, "aaaaa");
        Entity player2 = new Player(8 , 8,"ccccc");
        Entity player3 = new Player(0 , 8, "xxxxx");
        Entity player4 = new Player(8 , 0, "zzzzz");
        Entity monster = Monster.getMonster();

        map.drawMap();

        new KeyPressAction((Movable) player1);


        Runnable runnable = new Runnable() {

            @Override
            public void run() {

                ((Monster) monster).start();
            }
        };

        runnable.run();
        
    }
}
