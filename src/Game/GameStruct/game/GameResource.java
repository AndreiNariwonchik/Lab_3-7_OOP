package Game.GameStruct.game;

import Game.GameStruct.game.Levels.Level;
import Game.GameStruct.game.Levels.Level1;
import Game.Tanks.Tank;

import java.util.ArrayList;


/**
 * Created by andrei on 02.03.17.
 */
public abstract class GameResource
{
    //private static LinkedList<Level> game_levels = new LinkedList<>();
    //private Level curLevel;

    //public static Level getNextLevel(){
    // return game_levels.getFirst();
    //}

    private static ArrayList<Tank> enemies = new ArrayList<>();
    private static ArrayList<Object> others = new ArrayList<>();
    private static Tank myTank = null;

    public static ArrayList<Tank> getEnemies(){return enemies;}
    public static ArrayList<Object> getOthers(){return others;};
    public static Tank getMyTank(){return myTank;}
    public static void  setMyTank(Tank tank){myTank = tank;}
}
