package Game;

import Game.display.Display;
import Game.GameStruct.game.Game;


public class Main {

    public static void main( String[] args)
    {
       // BufferedImage image = ImageIO.read();
        Display.create(385,385,"Tanks", 0xff110000);
        Game tanks = new Game();
        tanks.start();
    }
}
