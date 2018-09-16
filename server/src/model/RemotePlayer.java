/*
 *
 * @project - MonsterGame
 * @author - ujjwalbatra on 16/09/18
 *
 */

package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemotePlayer extends Remote {
    public void move(String direction) throws Exception;
}
