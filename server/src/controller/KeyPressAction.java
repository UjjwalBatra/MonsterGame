package controller;


import exception.PlayerRunningOverPlayerException;
import model.Movable;
import exception.ObjectHittingWallException;
import exception.ObjectOutOfMapException;
import exception.PlayerDeadException;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;

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
        } catch (ObjectOutOfMapException ex) {

        } catch (ObjectHittingWallException ex) {

        } catch (InterruptedException ex) {

        } catch (PlayerDeadException ex) {
            //stop players ability to play anymore!!!!!!!!!!!!
        } catch (RemoteException ex) {

        } catch (PlayerRunningOverPlayerException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

}
