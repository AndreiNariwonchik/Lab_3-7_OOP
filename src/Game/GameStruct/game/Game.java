package Game.GameStruct.game;

import Game.Tanks.Tank;
import Game.display.Display;
import Game.display.ShowPicture;
import Game.utils.Time;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

import Game.IO.Input;

/**
 * Created by andre on 19.02.2017.
 */
public class Game implements Runnable
{
    private Level currentLevel;

    public static final int WIDTH = 800;
    public static  final  int HEIGHT = 600;
    public static final String TITLE = "Tanks";
    public static final int CLEAR_COLOR = 0xff000000;
    public static final float UPDATE_RATE = 60.0f;
    public static  final float UPDATE_INTERVAL = Time.SECOND/UPDATE_RATE;
    public static final long IDLE_TIME = 1;

    private boolean running = false;
    private Thread gameThread;
    private Graphics2D graphics;

    private Input input;

    //temp
    private float spead = 3;
    private float x = 350;
    private float y = 250;
    //private float delta = 0;
    private float radius = 50;
    //temp end

    public Game()
    {
        running = false;
        Display.create(WIDTH,HEIGHT,TITLE,CLEAR_COLOR);
        graphics = Display.getGraphics();
        input = new Input();
        Display.addInputListener(input);
    }

    public synchronized void start()
    {
        if (running)
            return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public  synchronized void stop()
    {
        if (!running)
            return;
        running = false;
        try {
            gameThread.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        cleanUp();
    }

    private void update()
    {
        //for (Tank en : GameResource.getEnemies())
        //{
        //    en.move(Display.getWindow().getWidth(), Display.getWindow().getHeight(), 0);
        //}


        if(input.getKey(KeyEvent.VK_UP)){
            GameResource.getMyTank().move(Display.getWindow().getWidth(), Display.getWindow().getHeight(), KeyEvent.VK_UP);
        }else
        if(input.getKey(KeyEvent.VK_DOWN)){
            GameResource.getMyTank().move(Display.getWindow().getWidth(), Display.getWindow().getHeight(), KeyEvent.VK_DOWN);
        }else
        if(input.getKey(KeyEvent.VK_LEFT)){
            GameResource.getMyTank().move(Display.getWindow().getWidth(), Display.getWindow().getHeight(), KeyEvent.VK_LEFT);
        }else
        if(input.getKey(KeyEvent.VK_RIGHT)){
            GameResource.getMyTank().move(Display.getWindow().getWidth(), Display.getWindow().getHeight(), KeyEvent.VK_RIGHT);
        }

        //эта штука анализирует столкновения объектов, движение, жизни, вызывая необходимые методы типа взрыв танка,
    }

    private void render()
    {
        Display.clear();
        graphics.setColor(new Color(0x120000));
        //graphics.drawImage(ResourceLoader.loadImage(t.getImages().get("DOWN")), (int)x,(int)y,null,null);
        ShowPicture.showPicture(graphics, GameResource.getEnemies(),GameResource.getMyTank());
        Display.swapBuffers();
    }

    public void run()
    {
        TanksConstruction.createTanks(18,18, graphics);
        //можно будет создать класс CreateLevel c методом в котором вызываться будет CreateTanks
        //стратегией будет разное движение вражеских танков путём переопределения метода Move танков
        int fps = 0;
        int upd = 0;
        int updl =0;

        long count = 0;
        float delta = 0;//количество Update
        long lastTime = Time.get();
        while (running)
        {
            long now = Time.get();
            long elapsedTime = now - lastTime;
            lastTime = now;

            count+=elapsedTime;

            boolean render = false;
            delta += (elapsedTime/UPDATE_INTERVAL);
            while(delta > 1)
            {
                update();//перерисовка
                upd++;
                delta--;
                if(render){
                    updl++;
                }
                else{
                    render = true;
                }
            }
            if(render){
                render();//Вычисления
                fps++;
            }
            else {
                try {
                    Thread.sleep(IDLE_TIME);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(count>Time.SECOND)
            {
                Display.setTitle(TITLE + " || Fps:"  +  fps + " | Upd: " + upd + " | Updl: " + updl);
                upd = 0;
                fps = 0;
                updl = 0;
                count = 0;
            }
        }
    }

    private void cleanUp()
    {
        Display.destroy();
    }
}
