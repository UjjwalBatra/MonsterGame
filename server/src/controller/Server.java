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

    public static void main(String[] args) {

        Entity player1 = new Player(0, 0, "Player1");
        RemotePlayer player2 = new Player(8, 8, "Player2");
        RemotePlayer player3 = new Player(0, 8, "Player3");
        RemotePlayer player4 = new Player(8, 0, "Player4");

        Entity monster = Monster.getMonster();
        Map.getPlayingArea().drawMap();

        Runnable runnable = () -> ((Monster) monster).start();

        runnable.run();

        new KeyPressAction((Movable) player1);

        try {
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }

            RemotePlayer stub = (RemotePlayer) UnicastRemoteObject.exportObject(player2);
            RemotePlayer stub2 = (RemotePlayer) UnicastRemoteObject.exportObject(player3);
            RemotePlayer stub3 = (RemotePlayer) UnicastRemoteObject.exportObject(player4);
            Registry registry1 = LocateRegistry.createRegistry(2097);
            Registry registry2 = LocateRegistry.createRegistry(2098);
            Registry registry3 = LocateRegistry.createRegistry(2099);

            registry1.bind("Player2", stub);
            registry2.bind("Player3", stub2);
            registry3.bind("Player4", stub3);
            System.err.println("Server Ready");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }

    }

}
