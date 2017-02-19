package Game.utils;

/**
 * Created by andre on 19.02.2017.
 */
public class Time
{
    public static final long SECOND = 1000000000l;
    public static long get()
    {
        return System.nanoTime();
    }
}
