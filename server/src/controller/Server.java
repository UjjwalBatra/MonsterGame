/*
 *
 * @project - MonsterGame
 * @author - ujjwalbatra on 16/09/18
 *
 */

package controller;

import model.*;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    //todo : is it fine if my server main class doesn't extend the rmi implementation class?

    public static void main(String[] args) {

        Entity player1 = new Player(0, 0, "Player1");
        Player player2 = new Player(8, 8, "Player2");
        Player player3 = new Player(0, 8, "Player3");
        Player player4 = new Player(8, 0, "Player4");

        Entity monster = Monster.getMonster();
        Map.getPlayingArea().drawMap();

        Runnable runnable = new Runnable() {

            @Override
            public void run() {

                ((Monster) monster).start();
            }
        };

        runnable.run();

        new KeyPressAction((Movable) player1);

        try {
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }

            //todo : how do I make all the players available on different ports?
            RemotePlayer stub = (RemotePlayer) UnicastRemoteObject.exportObject(player2, 0);
            RemotePlayer stub2 = (RemotePlayer) UnicastRemoteObject.exportObject(player3, 0);
            RemotePlayer stub3 = (RemotePlayer) UnicastRemoteObject.exportObject(player4, 0);
            Registry registry = LocateRegistry.getRegistry();

            registry.bind("Player2", stub);
            registry.bind("Player3", stub2);
            registry.bind("Player4", stub3);
            System.err.println("Server Ready");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }

    }

}
