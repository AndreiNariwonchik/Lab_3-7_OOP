package Game.GameStruct.game;

import Game.GameStruct.game.Levels.Level;
import Game.OtherObjects.Apple;
import Game.OtherObjects.OtherObject;
import  Game.Tanks.*;
import Game.display.Display;
import Game.display.ShowBackground;
import Game.utils.ResourceLoader;
import java.awt.*;


/**
 * Created by andrei on 01.03.17.
 */
public abstract class TanksConstruction
{
   /* private static void showEnemies(Graphics2D graphics)
    {
        for (int i = 0; i < GameResource.getEnemies().size(); i++)
        {
            graphics.drawImage(ResourceLoader.loadImage(GameResource.getEnemies().get(i).getImages().get("DOWN")),
                    (GameResource.getEnemies().get(i).getX()), (GameResource.getEnemies().get(i).getY()),null);
        }
        for (int i = 0; i<GameResource.getOthers().size();i++)
        {
            graphics.drawImage(ResourceLoader.loadImage(GameResource.getOthers().get(i).getImage()),
                    (GameResource.getOthers().get(i).getX()), (GameResource.getOthers().get(i).getY()),null);
        }

        graphics.drawImage(ResourceLoader.loadImage(GameResource.getMyTank().getImages().get("UP")),
                (GameResource.getMyTank().getX()), (GameResource.getMyTank().getY()),null);

    }
*/
    public static void createTanks(Level level, Graphics2D graphics)
    {
        for (int i = 0; i < level.getEnemyTanks1().size(); i++)
        {
            Tank t = level.getEnemyTanks1().get(i);
            GameResource.getEnemies().add(t);
            GameResource.getEnemyThreads().put(t, new Thread(t));
            GameResource.getEnemyThreads().get(t).start();
        }

        for (int i = 0; i < level.getEnemyTanks2().size(); i++)
        {
            Tank t = level.getEnemyTanks2().get(i);
            GameResource.getEnemies().add(t);
            GameResource.getEnemyThreads().put(t, new Thread(t));
            GameResource.getEnemyThreads().get(t).start();
        }

        for (int i = 0; i<level.getOthers().size(); i++)
        {
            OtherObject ob = level.getOthers().get(i);
            GameResource.getOthers().add(ob);
        }
        GameResource.setMyTank(new MyTank((int)(Display.getWindow().getWidth()/2), Display.getWindow().getHeight() - 20, 2));
    }

    public static void destroyTank(Tank tank)
    {
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException ex){}
        GameResource.getEnemies().remove(tank);
        GameResource.getEnemyThreads().get(tank).stop();
    }

    public static void destroyApple(OtherObject apple)
    {
        GameResource.getOthers().remove(apple);
    }

}
