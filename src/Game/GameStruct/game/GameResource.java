package Game.GameStruct.game;


import Game.OtherObjects.OtherObject;
import Game.Tanks.Tank;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;


/**
 * Created by andrei on 02.03.17.
 */
public abstract class GameResource
{
    private static Dictionary<Tank, Thread> enemyThreads = new Hashtable<>();
    private static ArrayList<Tank> enemies = new ArrayList<>();
    private static ArrayList<OtherObject> others = new ArrayList<>();
    private static Tank myTank = null;

    public static Dictionary<Tank, Thread> getEnemyThreads(){return enemyThreads;}
    public static ArrayList<Tank> getEnemies(){return enemies;}
    public static ArrayList<OtherObject> getOthers(){return others;};
    public static Tank getMyTank(){return myTank;}
    public static void  setMyTank(Tank tank){myTank = tank;}
}
