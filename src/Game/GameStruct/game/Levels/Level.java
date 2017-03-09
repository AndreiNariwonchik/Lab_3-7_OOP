package Game.GameStruct.game.Levels;

import Game.Tanks.EnemyTank1;
import Game.Tanks.EnemyTank2;
import sun.java2d.pipe.BufferedBufImgOps;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Objects;

/**
 * Created by andrei on 09.03.17.
 */
public abstract class Level
{
    private String  map;
    private List<EnemyTank1> enemyTanks1;
    private List<EnemyTank2> enemyTanks2;
    private List<Object> others;

    protected Level(String mp){
        map = mp;
    }

    public String getMap(){return map;};
    public List<EnemyTank1> getEnemyTanks1(){return enemyTanks1;};
    public List<EnemyTank2> getEnemyTanks2(){return enemyTanks2;};
    public List<Object> getOthers(){return others;};
    protected void setEnemyTanks1(List<EnemyTank1> et1){enemyTanks1 = et1;};
    protected void setEnemyTanks2(List<EnemyTank2> et2){enemyTanks2 = et2;};
    protected void setOthers(List<Object> ot){others = ot;};
}
