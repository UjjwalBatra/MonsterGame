package controller;

import model.Map;

import model.Monster;
import model.Movable;
import model.Player;

import java.awt.*;
import java.awt.event.*;
public class Game extends Frame implements KeyListener
{
    Label l;
    TextArea area;
    Movable player;
    Movable monster;
    Map map;
    Game()
    {
        Create();
        l = new Label();
        l.setBounds(20,50,100,20);
        area = new TextArea();
        //area.SetBounds(20,80,300,300);
        area.addKeyListener(this);

        add(l);
        add(area);
        setSize(400,400);
        setLayout(null);
        setVisible(true);
    }
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT)
        {
            player.move(map, "left");
            //System.out.println("Left arrow pressed");
            map.drawMap();

        }
        else if(key == KeyEvent.VK_RIGHT)
        {
            player.move(map, "right");
            map.drawMap();

        }
        else if(key == KeyEvent.VK_UP)
        {
            player.move(map, "up");
            map.drawMap();

        }
        else if(key == KeyEvent.VK_DOWN)
        {
            player.move(map, "down");
            map.drawMap();

        }

    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void Create()
    {
        map = new Map();
        player = new Player(map, 0,0);
        monster = new Monster(map, 4,4);
        map.drawMap();
    }


    public static void main(String[] args) {
        //Map map = new Map();
        //Movable player = new Player(map, 0,0);
        //Movable monster = new Monster(map, 4,4);
        new Game();
        System.out.println("testing");
        //map.drawMap();

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                //direction will be determined by monster itself
                ((Monster) monster).start();
            }
        };

        runnable.run();


    }
}
