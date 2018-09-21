/*
 *
 * @project - MonsterGame
 * @author - ujjwalbatra on 16/09/18
 *
 */

import model.RemotePlayer;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartUp {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();

            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }

            RemotePlayer player2 = (RemotePlayer) Naming.lookup("//localhost:2097/Player2");

            player2.move("left");
            player2.move("left");

            RemotePlayer player3 = (RemotePlayer) Naming.lookup("//localhost:2098/Player3");

            player3.move("right");
            player3.move("right");

            RemotePlayer player4 = (RemotePlayer) Naming.lookup("//localhost:2099/Player4");

            player4.move("left");
            player4.move("left");


        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }
}
