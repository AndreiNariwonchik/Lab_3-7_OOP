package Game.Tanks;

import Game.GameStruct.game.Game;

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

    @Override
    public void move(int widthX, int widthY, int ke)
    {
        if(ke == KeyEvent.VK_UP) {
            currentImage = ht.get("UP");
            y -= spead;
        }else if(ke == KeyEvent.VK_DOWN){
            currentImage = ht.get("DOWN");
            y+=spead;
        }else if(ke == KeyEvent.VK_LEFT){
            currentImage = ht.get("LEFT");
            x-=spead;
        }else if(ke == KeyEvent.VK_RIGHT){
            currentImage = ht.get("RIGHT");
            x+=spead;
        }
    }

    @Override
    public  void stateCheck()
    {

    }

}
