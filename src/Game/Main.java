package Game;

import Game.display.Display;
import  Game.GameStruct.game.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class Main {

    public static void main( String[] args)
    {
       // BufferedImage image = ImageIO.read();
        Display.create(500,500,"Tanks", 0xff110000);
        Game tanks = new Game();
        tanks.start();
    }
}
