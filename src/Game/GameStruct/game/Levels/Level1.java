package Game.GameStruct.game.Levels;

import Game.GameStruct.game.State;
import Game.OtherObjects.Background;
import Game.OtherObjects.Apple;
import Game.OtherObjects.OtherObject;
import Game.Tanks.EnemyTank1;
import Game.Tanks.EnemyTank2;
import Game.display.Display;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by andre on 20.02.2017.
 */
public class Level1 extends Level
{
    private int enemy1count = 3;
    private int enemy2count = 2;
    private int apples = 5;

    private int enemy1Speed = 2;
    private int enemy2Speed = 3;
    private int enemy1Lifes = 1;
    private int enemy2Lifes = 1;

    public Level1()
    {
        super(new Background("Background//background1.bmp", 0,0));
        super.setEnemyTanks1(createEnemy1());
        super.setEnemyTanks2(createEnemy2());
        //super.setOthers(createOthers());
        super.setApplesCount(apples);
        super.createOthers();
    }

    private ArrayList<EnemyTank1> createEnemy1()
    {
        ArrayList<EnemyTank1> et1 = new ArrayList<>();
        for(int i = 0; i< enemy1count; i++)
        {
            //et1.add(new EnemyTank1(Display.getWindow().getWidth()/enemy1count*i + Display.getWindow().getWidth()/enemy1count/2, 20, enemy1Speed, enemy1Lifes));
            et1.add(new EnemyTank1(61 + 2*61*i, 5, enemy1Speed, enemy1Lifes, State.DOWN));
        }
        return et1;
    }

    private ArrayList<EnemyTank2> createEnemy2(){
        ArrayList<EnemyTank2> et2 = new ArrayList<>();
        for(int i = 0; i< enemy2count; i++){
            et2.add(new EnemyTank2(120 +120*i, 32, enemy2Speed, enemy2Lifes, State.DOWN));
        }
        return et2;
    }
/*
    private ArrayList<OtherObject> createOthers() {
        ArrayList<OtherObject> oth = new ArrayList<>();
        Random r1 = new Random();
        Random r2 = new Random();
        for (int i = 0; i < apples; i++) {
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
        //oth.add(new Background("Background//background1.bmp", 0,0));
        return oth;
    }
*/
}
