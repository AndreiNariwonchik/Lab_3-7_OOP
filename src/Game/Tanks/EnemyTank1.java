package Game.Tanks;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.StringTokenizer;

import Game.GameStruct.game.State;
import Game.display.Display;
import Game.utils.ResourceLoader;

/**
 * Created by andre on 19.02.2017.
 */
public class EnemyTank1 extends Tank  implements Runnable
{
    Dictionary<String,String> ht = new Hashtable<>(4);

    public EnemyTank1(int x, int y, int speed, int life)
    {
        super(x, y, "Enemy1//Down//Hunter1D.bmp",speed, life);
        setState(State.DOWN);
        ht.put("UP", "Enemy1//Up//Hunter1U.bmp");
        ht.put("DOWN", "Enemy1//Down//Hunter1D.bmp");
        ht.put("LEFT", "Enemy1//Left//Hunter1L.bmp");
        ht.put("RIGHT", "Enemy1//Right//Hunter1R.bmp");
        ht.put("BURNING", "FireTank//FireTank1.bmp");
        super.images = ht;
    }

    /*public void run()
    {
        while(super.getState() != state.BURNING)
        {
            move(0);
            try {
                Thread.sleep(spead*30);
            }
            catch (InterruptedException ex){System.out.print("Interгзеув Учсузешщт"); continue;}
        }
    }*/

    private void isBorderCheckFalse()
    {
        if (getState() == State.DOWN) setState(State.UP);
        else if (getState() == State.UP) setState(State.DOWN);
        else if (getState() == State.LEFT) setState(State.RIGHT);
        else if (getState()== State.RIGHT) setState(State.LEFT);

    }

    @Override
    public void move(int ke)
    {
            if (borderCheck(Display.getWindow().getWidth(),Display.getWindow().getHeight())){
                if (getState() == State.UP) y -= getSpeed();
                else if (getState() == State.DOWN) y += getSpeed();
                else if (getState() == State.LEFT) x -= getSpeed();
                else if (getState() == State.RIGHT) x += getSpeed();
            }
            else
            {
                borderClash();
                isBorderCheckFalse();
                chekState();
            }
    }
}
