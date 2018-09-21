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

            RemotePlayer player = (RemotePlayer) Naming.lookup("//localhost:1099/Player2");

            player.move("left");
            player.move("left");
            player.move("left");
            player.move("left");


        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }
}
