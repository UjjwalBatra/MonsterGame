/*
 *
 * @project - MonsterGame
 * @author - ujjwalbatra on 16/09/18
 *
 */

package model;

import exception.GameException;
import exception.PlayerRunningOverPlayerException;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemotePlayer extends Remote {

    /*
    *
    * move player on the map
    *
    */
    public void move(String direction) throws RemoteException, GameException, InterruptedException, PlayerRunningOverPlayerException;

    public Map getMap() throws RemoteException;

}
