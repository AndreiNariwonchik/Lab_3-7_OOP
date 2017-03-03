package Game.GameStruct.game;

import  Game.Tanks.*;
import Game.display.Display;
import Game.utils.ResourceLoader;
import java.awt.*;

/**
 * Created by andrei on 01.03.17.
 */
public abstract class TanksConstruction
{
    private static void showEnemies(Graphics2D graphics)
    {
        for (int i = 0; i < GameResource.getEnemies().size(); i++)
        {
            graphics.drawImage(ResourceLoader.loadImage(GameResource.getEnemies().get(i).getImages().get("DOWN")),
                    (GameResource.getEnemies().get(i).getX()), (GameResource.getEnemies().get(i).getY()),null);
        }
        graphics.drawImage(ResourceLoader.loadImage(GameResource.getMyTank().getImages().get("UP")),
                (GameResource.getMyTank().getX()), (GameResource.getMyTank().getY()),null);

    }

    public static void createTanks(int enemy1Сount, int enemy2Count, Graphics2D graphics)
    {
        //рандомная позиция танка, количество танков
        //Random rx;
        //Random ry;

        for (int i = 0; i < enemy1Сount; i++)
        {
            GameResource.getEnemies().add(new EnemyTank1(Display.getWindow().getWidth()/enemy1Сount*i + Display.getWindow().getWidth()/enemy1Сount/2 ,30, 1));
        }
        for (int i = 0; i < enemy2Count; i++)
        {
            GameResource.getEnemies().add(new EnemyTank2(Display.getWindow().getWidth()/enemy2Count*i + Display.getWindow().getWidth()/enemy2Count/2,60, 1));
        }

        System.out.print(Display.getWindow().getWidth());
        GameResource.setMyTank(new MyTank((int)(Display.getWindow().getWidth()/2), Display.getWindow().getHeight() - 20, 2));
        showEnemies(graphics);
    }
}
