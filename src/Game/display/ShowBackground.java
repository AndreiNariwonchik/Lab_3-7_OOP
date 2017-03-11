package Game.display;

import Game.GameStruct.game.GameResource;
import Game.OtherObjects.OtherObject;
import Game.Tanks.Tank;
import Game.utils.ResourceLoader;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by andrei on 10.03.17.
 */
public class ShowBackground
{
    public static void showBackground(Graphics2D graphics, OtherObject backgr)
    {
            graphics.drawImage(ResourceLoader.loadImage(backgr.getImage()),
                    backgr.getX(), backgr.getY(),null);
    }
}
