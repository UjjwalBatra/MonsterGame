package controller;/*
 *
 * @project - MonsterGame
 * @author - ujjwalbatra on 16/09/18
 *
 */

import model.Player;
import model.RemotePlayer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends Player {

    public static void main(String[] args) {
        try {
            Player player2 = new Player(8, 8, "Player2");
            RemotePlayer stub = (RemotePlayer) UnicastRemoteObject.exportObject(player2, 0);
            Registry registry = LocateRegistry.getRegistry();

            registry.bind("Player 2", stub);
            System.err.println("Server Ready");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
