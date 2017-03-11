package Game.Tanks;

import Game.GameStruct.game.State;
import Game.OtherObjects.OtherObject;
import Game.display.Display;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
                checkState();
                y -= getSpeed();
            } else if (ke == KeyEvent.VK_DOWN) {
                setState(State.DOWN);
                checkState();
                y += getSpeed();
            } else if (ke == KeyEvent.VK_LEFT) {
                setState(State.LEFT);
                checkState();
                x -= getSpeed();
            } else if (ke == KeyEvent.VK_RIGHT) {
                setState(State.RIGHT);
                checkState();
                x += getSpeed();
            }
        }
        else
        {
            borderClash();
        }
    }
    public boolean isMyTankKilled(ArrayList<Tank> tanks)
    {
        for (Tank tank:tanks)
        {
            if ( ((tank.getX()<= x) && (x <= tank.getX() + 20) && (tank.getY() <= y) && (y <= tank.getY()+20)) ||
                    ((tank.getX() <= x + 20) && (x + 20 <= tank.getX() + 20) && (tank.getY() <= y) && (y <= tank.getY()+20)) ||
                    ((tank.getX()<= x) && (x <= tank.getX() + 20) && (tank.getY() <= y +20) && (y + 20 <= tank.getY() + 20)) ||
                    ((tank.getX()<= x + 20) && (x + 20 <= tank.getX() +20) && (tank.getY() <= y + 20) && (y + 20 <= tank.getY()+20))
                    )
            {
                if(getLifes() == 1) {
                    tank.destroy();
                    this.destroy();
                    return true;
                }
                else {
                    wound();
                    for (int i = 0; i<5; i++){
                        borderClash();
                    }
                }
                tank.destroy();
                break;
            }
        }
        return false;
    }

    public boolean isAppleCollision(ArrayList<OtherObject> tanks)
    {
        return false;
    }
}
