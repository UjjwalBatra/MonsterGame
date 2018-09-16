package server.controller;


import server.model.Movable;
import server.exception.ObjectHittingWallException;
import server.exception.ObjectOutOfMapException;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPressAction extends Frame implements KeyListener {

    Label l;
    TextArea area;
    Movable player;

    public KeyPressAction(Movable player) {
        this.player = player;

        l = new Label();
        l.setBounds(20, 50, 100, 20);
        area = new TextArea();
        //area.SetBounds(20,80,300,300);
        area.addKeyListener(this);

        add(l);
        add(area);
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        try {
            if (key == KeyEvent.VK_LEFT) {
                player.move("left");
                //System.out.println("Left arrow pressed");

            } else if (key == KeyEvent.VK_RIGHT) {
                player.move("right");


            } else if (key == KeyEvent.VK_UP) {
                player.move("up");


            } else if (key == KeyEvent.VK_DOWN) {
                player.move("down");

            }
        } catch (ObjectOutOfMapException ex){

        } catch (ObjectHittingWallException ex){

        } catch (InterruptedException ex){

        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

}
