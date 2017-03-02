package Game.GameStruct.game;

import Game.Tanks.Tank;

import java.util.ArrayList;

/**
 * Created by andrei on 02.03.17.
 */
public abstract class GameResource
{
    private static ArrayList<Tank> enemies = new ArrayList<>();
    private static Tank myTank = null;

    public static ArrayList<Tank> getEnemies(){return enemies;}
    public static Tank getMyTank(){return myTank;}
    public static void  setMyTank(Tank tank){myTank = tank;}
}
