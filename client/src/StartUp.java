/*
 *
 * @project - MonsterGame
 * @author - ujjwalbatra on 16/09/18
 *
 */

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartUp {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null);
            System.setSecurityManager(new RMISecurityManager());

            try {
                RemotePlayer player =(RemotePlayer)Naming.lookup("rmi://localhost/Player2");
            } catch (Exception e){

            }


        } catch (Exception e){
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }
}
