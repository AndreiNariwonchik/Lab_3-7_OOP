package Game.Tanks;

import Game.GameStruct.game.State;
import Game.display.Display;
import java.awt.event.KeyEvent;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by andre on 19.02.2017.
 */
public class MyTank extends Tank
{
    private Dictionary<String,String> ht = new Hashtable<>(4);

    public MyTank(int x, int y, int life)
    {
        super(x, y,"MyTank//Up//Pacman1U.bmp",2, life);
        ht.put("UP", "MyTank//Up//Pacman1U.bmp");
        ht.put("DOWN", "MyTank//Down//Pacman1D.bmp");
        ht.put("LEFT", "MyTank//Left//Pacman1L.bmp");
        ht.put("RIGHT", "MyTank//Right//Pacman1R.bmp");
        ht.put("BURNING", "FireTank//FireTank1.bmp");
        super.images = ht;
    }

    //@Override
    //public  void destroy(){}

    @Override
    public void move(int ke)
    {
        if (borderCheck(Display.getWindow().getWidth(), Display.getWindow().getHeight())) {
            if (ke == KeyEvent.VK_UP) {
                setState(State.UP);
                chekState();
                y -= getSpeed();
            } else if (ke == KeyEvent.VK_DOWN) {
                setState(State.DOWN);
                chekState();
                y += getSpeed();
            } else if (ke == KeyEvent.VK_LEFT) {
                setState(State.LEFT);
                chekState();
                x -= getSpeed();
            } else if (ke == KeyEvent.VK_RIGHT) {
                setState(State.RIGHT);
                chekState();
                x += getSpeed();
            }
        }
        else
        {
            borderClash();
        }

    }
}
