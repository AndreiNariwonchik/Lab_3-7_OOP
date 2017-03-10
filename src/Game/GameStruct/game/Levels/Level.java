package Game.GameStruct.game.Levels;

import Game.OtherObjects.OtherObject;
import Game.Tanks.EnemyTank1;
import Game.Tanks.EnemyTank2;

import java.util.List;

/**
 * Created by andrei on 09.03.17.
 */
public abstract class Level
{
    public boolean isCompleted;
    private String  map;
    private List<EnemyTank1> enemyTanks1;
    private List<EnemyTank2> enemyTanks2;
    private List<OtherObject> others;

    protected Level(String mp){
        map = mp;
        isCompleted = false;
    }


    public String getMap(){return map;};
    public List<EnemyTank1> getEnemyTanks1(){return enemyTanks1;};
    public List<EnemyTank2> getEnemyTanks2(){return enemyTanks2;};
    public List<OtherObject> getOthers(){return others;};
    protected void setEnemyTanks1(List<EnemyTank1> et1){enemyTanks1 = et1;};
    protected void setEnemyTanks2(List<EnemyTank2> et2){enemyTanks2 = et2;};
    protected void setOthers(List<OtherObject> ot){others = ot;};
}
