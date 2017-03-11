package Game.Tanks;

import Game.GameStruct.game.State;
import Game.GameStruct.game.TanksConstruction;
import Game.display.ShowBackground;
import Game.display.ShowPicture;

import java.util.Dictionary;


/**
 * Created by andre on 19.02.2017.
 */
public abstract class Tank implements Runnable
{
    private int speed;
    protected int x;
    protected int y;
    private int lifes;
    protected Dictionary<String, String> images;
    protected String currentImage;
    private State state;
    //protected  boolean burning = false;


    public Tank(int x, int y, String curimage, int speed, int lifes)
    {
        this.currentImage = curimage;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.lifes = lifes;
    }

    //private  void setCurrentImage(String img){currentImage = img;}
    public  String getCurrentImage(){return currentImage;}

    public int getLifes(){return lifes;}
    //public void setLifes(int lif){lifes = lif;}
    public int getSpeed(){return speed;}
    public int getX(){return x;}
    public int getY(){return y;}
    public State getState(){return state;}
    public Dictionary<String, String> getImages(){return images;}
    protected void setState(State st){state = st;}

    public void checkState()
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
        if((state == State.UP && y <= 0) || (state == State.DOWN && y >= height - 20)
                || (state == State.LEFT && x <= 0) || (state == State.RIGHT && x >= width - 20))
            return false;
        else return true;
    }

    protected void borderClash()
    {
        if (state == State.UP) y += speed;
        else if (state == State.DOWN) y -= speed;
        else if (state == State.LEFT) x += speed;
        else if (state == State.RIGHT) x -= speed;
    }
    public  void wound()
    {
        lifes--;
    }

    public void blowUp()
    {
        this.state = state.BURNING;
    }

    public void destroy()
    {
        blowUp();
        checkState();
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException ex){System.out.print("Interгupted Exception");}
        //TanksConstruction.destroyTank(this);
    }

    public void run()
    {
        while(getState() != state.BURNING)
        {
            move(0);
            try {
                Thread.sleep(50);
            }
            catch (InterruptedException ex){System.out.print("Interгupted Exception"); continue;}
        }
        if (getLifes() == 1)
        {
            destroy();
            //TanksConstruction.destroyTank(this);
        }
        else
        {
            lifes --;
            run();
        }
    }

    public abstract void move(int ke);
}
