package Game;

import Game.display.Display;
import  Game.GameStruct.game.Game;


public class Main {

    public static void main( String[] args)
    {
        Display.create(500,500,"Tanks", 0xff11AA00);
        Game tanks = new Game();
        tanks.start();
    }
}
