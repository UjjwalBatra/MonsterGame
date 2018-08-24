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
    public static Movable player;
    public static Movable monster;
    public static Map map;

    public Game()
    {
        map = new Map();
        player = new Player(0,0);
        monster = new Monster(4,4);

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
            player.move("left");
            //System.out.println("Left arrow pressed");
            map.drawMap();

        }
        else if(key == KeyEvent.VK_RIGHT)
        {
            player.move( "right");
            map.drawMap();

        }
        else if(key == KeyEvent.VK_UP)
        {
            player.move( "up");
            map.drawMap();

        }
        else if(key == KeyEvent.VK_DOWN)
        {
            player.move("down");
            map.drawMap();

        }

    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void keyTyped(KeyEvent e)
    {

    }



    public static void main(String[] args) {

        new Game();
        System.out.println("testing");

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
