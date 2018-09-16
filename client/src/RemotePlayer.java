/*
 *
 * @project - MonsterGame
 * @author - ujjwalbatra on 16/09/18
 *
 */

import java.rmi.Remote;

public interface RemotePlayer extends Remote {
    public void move(String direction) throws Exception;
}
