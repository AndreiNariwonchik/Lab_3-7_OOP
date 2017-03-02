package Game.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * Created by andre on 19.02.2017.
 */
public class ResourceLoader
{
    public static final String PATH = "resource//";

    public static BufferedImage loadImage(String fileName)
    {
        BufferedImage image = null;
        try
        {
            image = ImageIO.read(new File(PATH + fileName));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return image;
    }
}
