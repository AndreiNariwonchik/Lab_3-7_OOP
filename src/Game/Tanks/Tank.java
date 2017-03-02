package Game.Tanks;

import Game.GameStruct.game.State;

import java.util.Dictionary;

/**
 * Created by andre on 19.02.2017.
 */
public abstract class Tank
{
    protected int spead;
    protected int x;
    protected int y;
    protected int lifes;
    protected Dictionary<String, String> images;
    protected String currentImage;
    protected State state;
    //protected  boolean burning = false;


    public Tank(int x, int y, String curimage, int spead, int lifes)
    {
        this.currentImage = curimage;
        this.x = x;
        this.y = y;
        this.spead = spead;
        this.lifes = lifes;
    }

    //private  void setCurrentImage(String img){currentImage = img;}
    public  String getCurrentImage(){return currentImage;}

    public int getX(){return x;}
    public int getY(){return y;}
    public State getState(){return state;}
    public Dictionary<String, String> getImages(){return images;}

    public void chekState()
    {
        if (state == state.BURNING)
        {
            currentImage = images.get("BURNING");
        }
        else if (state == State.DOWN)
        {
               currentImage = images.get("DOWN");
        }
        else if (state == State.UP)
        {
            currentImage = images.get("UP");
        }
        else if (state == State.RIGHT)
        {
            currentImage = images.get("RIGHT");
        }
        else if (state == State.LEFT)
        {
            currentImage = images.get("LEFT");
        }
    }

    public boolean borderCheck(int width, int height)
    {
        if((state == State.UP && y <= 10) || (state == State.DOWN && y >= height - 10)
                || (state == State.LEFT && x <= 10) || (state == State.RIGHT && y >= height-10))
            return false;
        else return true;
    }

    public void blowUp()
    {
        this.state = state.BURNING;
    }

    public abstract void move(int widthX, int widthY, int ke);
    public abstract  void stateCheck();
}
