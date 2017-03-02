package Game.display;

import Game.GameStruct.game.Game;
import Game.GameStruct.game.GameResource;
import Game.Tanks.Tank;
import Game.utils.ResourceLoader;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by andrei on 02.03.17.
 */
public class ShowPicture
{
    //контроль за state каждого танка здесь
    //вызов метода проверить состояние и изменить curentImage из объектов Tank
    public static void showPicture(Graphics2D graphics, ArrayList<Tank> tanks, Tank myTank)
    {
        for (int i = 0; i < GameResource.getEnemies().size(); i++)
        {
            graphics.drawImage(ResourceLoader.loadImage(GameResource.getEnemies().get(i).getCurrentImage()),
                    (GameResource.getEnemies().get(i).getX()), (GameResource.getEnemies().get(i).getY()),null);
        }
        graphics.drawImage(ResourceLoader.loadImage(GameResource.getMyTank().getCurrentImage()),
                (GameResource.getMyTank().getX()), (GameResource.getMyTank().getY()),null);
    }
}
