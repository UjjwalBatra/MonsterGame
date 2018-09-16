package controller;/*
 *
 * @project - MonsterGame
 * @author - ujjwalbatra on 16/09/18
 *
 */

import model.Entity;
import model.Player;
import model.RemotePlayer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends Player {
    //todo : is it fine if my server main class doent extend the rmi implementation class?

    public static void main(String[] args) {
        try {
            Player player2 = new Player(8, 8, "Player2");
            Player player3 = new Player(0, 8, "Player3");
            Player player4 = new Player(8, 0, "Player4");

            //todo : how do I make all the players available on different ports?

            RemotePlayer stub = (RemotePlayer) UnicastRemoteObject.exportObject(player2, 0);
            Registry registry = LocateRegistry.getRegistry();

            registry.bind("Player 2", stub);
            System.err.println("Server Ready");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }

        Entity player1 = new Player(0 , 0, "Player1");



    }

}
