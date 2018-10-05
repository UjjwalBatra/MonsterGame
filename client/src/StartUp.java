/*
 *
 * @project - MonsterGame
 * @author - ujjwalbatra on 16/09/18
 *
 */


import model.Entity;
import model.RemoteMap;
import model.RemotePlayer;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class StartUp {

    private static final String ipAddress = "//10.132.118.191";
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();

            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }

//            RemotePlayer player2 = (RemotePlayer) Naming.lookup(ipAddress + ":2097/Player2");
//
//            player2.move("left");
//            player2.move("left");
//            player2.getMap().drawMap();

            RemoteMap map = (RemoteMap) Naming.lookup(ipAddress + ":3000/Map");
            RemotePlayer player3 = (RemotePlayer) Naming.lookup(ipAddress + ":2098/Player3");

            Entity [][] array = map.getMap();

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j]);
                }
                System.out.println();
            }

            player3.move("right");
            player3.move("right");


            RemotePlayer player4 = (RemotePlayer) Naming.lookup(ipAddress + ":2099/Player4");

            player4.move("left");
            player4.move("left");
//            player4.getMap().drawMap();


        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }
}
