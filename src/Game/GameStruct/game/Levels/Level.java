package Game.GameStruct.game.Levels;

import Game.OtherObjects.Apple;
import Game.OtherObjects.OtherObject;
import Game.Tanks.EnemyTank1;
import Game.Tanks.EnemyTank2;
import Game.display.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by andrei on 09.03.17.
 */
public abstract class Level
{
    public boolean isCompleted;
    private OtherObject  map;
    private List<EnemyTank1> enemyTanks1;
    private List<EnemyTank2> enemyTanks2;
    private List<OtherObject> others;
    private int applesCount;

    protected Level(OtherObject mp){
        map = mp;
        isCompleted = false;
    }

    public int getApplesCount(){return applesCount;}
    protected void setApplesCount(int count){applesCount = count;}
    public OtherObject getMap(){return map;};
    public List<EnemyTank1> getEnemyTanks1(){return enemyTanks1;};
    public List<EnemyTank2> getEnemyTanks2(){return enemyTanks2;};
    public List<OtherObject> getOthers(){return others;};
    protected void setEnemyTanks1(List<EnemyTank1> et1){enemyTanks1 = et1;};
    protected void setEnemyTanks2(List<EnemyTank2> et2){enemyTanks2 = et2;};
    protected void setOthers(List<OtherObject> ot){others = ot;};

    protected void createOthers() {
        ArrayList<OtherObject> oth = new ArrayList<>();
        Random r1 = new Random();
        Random r2 = new Random();
        for (int i = 0; i < applesCount; i++) {
            if (i % 2 == 1) {
                oth.add(new Apple("//Apple//NewApple.jpg", 5 + 59 * r2.nextInt(6), 5 + 59 * r1.nextInt(6)));
            } else {
                oth.add(new Apple("//Apple//NewApple.jpg", 5 + 59 * r1.nextInt(6), 5 + 59 * r2.nextInt(6)));
            }
        }

        for (int i = 0; i < (Display.getWindow().getWidth()) / 30 - 1; i++) {
            for (int j = 0; j < (int) (Display.getWindow().getHeight() / 30) - 1; j++) {
                if (i % 2 == 0 && j % 2 == 0)
                    oth.add(new Apple("//Apple//field.png", 30 + 30 * i, 30 + 30 * j));
            }
        }
        others = oth;
    }
}
