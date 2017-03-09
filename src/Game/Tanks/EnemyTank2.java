package Game.Tanks;

import Game.GameStruct.game.State;
import Game.display.Display;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by andrei on 03.03.17.
 */
public class EnemyTank2 extends Tank implements Runnable
{
    Dictionary<String, String> ht = new Hashtable<>(4);

    public EnemyTank2(int x, int y, int speed, int life) {
        super(x, y, "Enemy2//Down//Tank1D.bmp", speed, life);
        setState(State.DOWN);
        ht.put("UP", "Enemy2//Up//Tank1U.bmp");
        ht.put("DOWN", "Enemy2//Down//Tank1D.bmp");
        ht.put("LEFT", "Enemy2//Left//Tank1L.bmp");
        ht.put("RIGHT", "Enemy2//Right//Tank1R.bmp");
        ht.put("BURNING", "FireTank//FireTank1.bmp");
        super.images = ht;
    }

    /*public void run(){
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
    public void move(int ke) {
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
