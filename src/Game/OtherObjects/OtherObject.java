package Game.OtherObjects;

/**
 * Created by andrei on 10.03.17.
 */
public abstract class OtherObject
{
    private int X;
    private int Y;
    private String image;
    OtherObject(String im, int x, int y)
    {
        image = im;
        X = x;
        Y = y;
    }

    public int getX(){return X;}
    public int getY(){return Y;}
    public String getImage(){return image;}
}
