package Game.GameStruct.game.Levels;

import Game.Tanks.EnemyTank1;
import Game.Tanks.EnemyTank2;
import Game.display.Display;

import java.util.ArrayList;

/**
 * Created by andre on 20.02.2017.
 */
public class Level2 extends Level
{
    private int enemy1count = 4;
    private int enemy2count = 2;
    private int others = 5;
    private int enemy1Speed = 2;
    private int enemy2Speed = 3;
    private int enemy1Lifes = 1;
    private int enemy2Lifes = 1;
    //private BufferedImage MAP = null;

    public Level2(){
        super("Кнопочка//Play.bmp");
        super.setEnemyTanks1(createEnemy1());
        super.setEnemyTanks2(createEnemy2());
        super.setOthers(createOthers());
    }

    private ArrayList<EnemyTank1> createEnemy1(){
        ArrayList<EnemyTank1> et1 = new ArrayList<>();
        for(int i = 0; i< enemy1count; i++){
            et1.add(new EnemyTank1(Display.getWindow().getWidth()/enemy1count*i + Display.getWindow().getWidth()/enemy1count/2, 30, enemy1Speed, enemy1Lifes));
        }
        return et1;
    }

    private ArrayList<EnemyTank2> createEnemy2(){
        ArrayList<EnemyTank2> et2 = new ArrayList<>();
        for(int i = 0; i< enemy2count; i++){
            et2.add(new EnemyTank2(Display.getWindow().getWidth()/enemy2count*i + Display.getWindow().getWidth()/enemy2count/2, 60, enemy2Speed, enemy2Lifes));
        }
        return et2;
    }

    private ArrayList<Object> createOthers(){
        for(int i = 0; i< others; i++){

        }
        return null;
    }

    //файл типа карта для уровня) исходя из неё будет заполнение
}