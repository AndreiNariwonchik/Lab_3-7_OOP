package Game.display;

import Game.GameStruct.game.Game;
import Game.GameStruct.game.GameResource;
import Game.OtherObjects.OtherObject;
import Game.Tanks.Tank;
import Game.utils.ResourceLoader;

import javax.print.attribute.standard.MediaSize;
import java.awt.*;
import java.util.ArrayList;


/**
 * Created by andrei on 02.03.17.
 */
public class ShowPicture
{
    public static void showPicture(Graphics2D graphics, ArrayList<Tank> tanks, Tank myTank, ArrayList<OtherObject> others)
    {
        for (int i = 0; i< others.size(); i++)
        {
             graphics.drawImage(ResourceLoader.loadImage(GameResource.getOthers().get(i).getImage()),
                (GameResource.getOthers().get(i).getX()), (GameResource.getOthers().get(i).getY()),null);
        }
        for (int i = 0; i < GameResource.getEnemies().size(); i++)
        {
            graphics.drawImage(ResourceLoader.loadImage(GameResource.getEnemies().get(i).getCurrentImage()),
                    (GameResource.getEnemies().get(i).getX()), (GameResource.getEnemies().get(i).getY()),null);
        }

        graphics.drawImage(ResourceLoader.loadImage(GameResource.getMyTank().getCurrentImage()),
                (GameResource.getMyTank().getX()), (GameResource.getMyTank().getY()),null);
    }
}
