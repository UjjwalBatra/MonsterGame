package controller;
import model.Map;
import model.Monster;
import model.Movable;
import model.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPressAction extends Frame implements KeyListener {

    Label l;
    TextArea area;
    Movable player;
    Movable monster;
    Map map;

    public KeyPressAction(Map map, Movable monster, Movable player)
    {
        this.map = map;
        this.player = player;
        this.monster = monster;

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

        }
        else if(key == KeyEvent.VK_RIGHT)
        {
            player.move(map, "right");


        }
        else if(key == KeyEvent.VK_UP)
        {
            player.move(map, "up");


        }
        else if(key == KeyEvent.VK_DOWN)
        {
            player.move(map, "down");


        }

    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void keyTyped(KeyEvent e)
    {

    }

}
