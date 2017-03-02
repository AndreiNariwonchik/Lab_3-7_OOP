package Game.Tanks;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.StringTokenizer;

import Game.utils.ResourceLoader;

/**
 * Created by andre on 19.02.2017.
 */
public class EnemyTank1 extends Tank
{
    Dictionary<String,String> ht = new Hashtable<>(4);

    public EnemyTank1(int x, int y, int life)
    {
        super(x, y, "Enemy1//Down//Hunter1D.bmp",2, life);

        ht.put("UP", "Enemy1//Up//Hunter1U.bmp");
        ht.put("DOWN", "Enemy1//Down//Hunter1D.bmp");
        ht.put("LEFT", "Enemy1//Left//Hunter1L.bmp");
        ht.put("RIGHT", "Enemy1//Right//Hunter1R.bmp");
        ht.put("BURNING", "FireTank//FireTank1.bmp");
        super.images = ht;
    }

    @Override
    public void move(int widthX, int widthY, int ke)
    {
        while(super.getState() != state.BURNING)
        {

        }

    }

    @Override
    public  void stateCheck()
    {

    }
}
