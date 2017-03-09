package Game.GameStruct.game;

import Game.GameStruct.game.Levels.Level;
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

    //public static void createTanks(int enemy1Сount, int enemy2Count, Graphics2D graphics)
    public static void createTanks(Level level, Graphics2D graphics)
    {
        //for (int i = 0; i < enemy1Сount; i++)
        for (int i = 0; i < level.getEnemyTanks1().size(); i++)
        {
            GameResource.getEnemies().add(level.getEnemyTanks1().get(i));
        }
        for (int i = 0; i < level.getEnemyTanks2().size(); i++)
        {
            GameResource.getEnemies().add(level.getEnemyTanks2().get(i));
        }

        System.out.print(Display.getWindow().getWidth());
        GameResource.setMyTank(new MyTank((int)(Display.getWindow().getWidth()/2), Display.getWindow().getHeight() - 20, 2));
        showEnemies(graphics);
    }
}
