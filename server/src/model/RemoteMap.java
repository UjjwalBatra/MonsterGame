package model;/*
 *
 * @project - MonsterGame
 * @author - ujjwalbatra on 05/10/18
 *
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMap extends Remote {
    public Entity[][] getMap() throws RemoteException;
    public void drawMap() throws RemoteException;
}
