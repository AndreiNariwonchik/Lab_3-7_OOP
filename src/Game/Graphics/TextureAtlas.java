package Game.Graphics;

import Game.utils.ResourceLoader;

import java.awt.image.BufferedImage;

/**
 * Created by andre on 19.02.2017.
 */
public class TextureAtlas//Загрузка большой картины с танками
{
    BufferedImage image;

    public TextureAtlas(String imageName) {
        image = ResourceLoader.loadImage(imageName);
    }

    public BufferedImage cut(int x,int y, int w, int h) //вырезать кусок изображение
    {
        return image.getSubimage(x,y,w,h);
    }
}
