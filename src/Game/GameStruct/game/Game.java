package Game.GameStruct.game;


import Game.GameStruct.game.Levels.Game_completed;
import Game.GameStruct.game.Levels.Level;
import Game.GameStruct.game.Levels.Level1;
import Game.GameStruct.game.Levels.Level2;
import Game.Tanks.MyTank;
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
    private ArrayList<Level> levels = new ArrayList<>();
    private int appleCount;


    public static final int WIDTH = 800;
    public static  final  int HEIGHT = 600;
    public static final String TITLE = "Tanks";
    public static final int CLEAR_COLOR = 0xff000000;
    public static final float UPDATE_RATE = 40.0f;
    public static  final float UPDATE_INTERVAL = Time.SECOND/UPDATE_RATE;
    public static final long IDLE_TIME = 1;

    private boolean running = false;
    private Thread gameThread;
    private Thread checkLevel;
    private Graphics2D graphics;

    private Input input;

    public Game()
    {
        running = false;
        Display.create(WIDTH,HEIGHT,TITLE,CLEAR_COLOR);
        graphics = Display.getGraphics();
        input = new Input();
        Display.addInputListener(input);
        levels.add(new Level1());
        levels.add(new Level2());
        levels.add(new Game_completed());
        checkLevel = new Thread();
        currentLevel = levels.get(0);
        appleCount = currentLevel.getApplesCount();
    }

    private void changeRunningState()
    {
        if (running)
        {
            System.out.print("From change Running"); running = !running;
        }
        else running = !running;
    }

    private void newLevel()
    {
        for (int i = 0; i < levels.size();i++)
        {
            if((levels.get(i).equals(currentLevel)) && (levels.get(i) != levels.get(levels.size()-2)))
            {
                try{Thread.sleep(1000);}
                catch (InterruptedException ex){}

                for (Tank t:GameResource.getEnemies())
                {
                        GameResource.getEnemyThreads().get(t).stop();
                        try
                        {
                            Thread.sleep(10);
                        }
                        catch (InterruptedException exc){return;}
                }
                GameResource.getEnemies().clear();
                GameResource.getOthers().clear();
                currentLevel = levels.get(i+1);
                appleCount = currentLevel.getApplesCount();
                changeRunningState();
                run();
                return;
            }
            else {
                for (Tank t:GameResource.getEnemies())
                {
                    GameResource.getEnemyThreads().get(t).stop();
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException exc){return;}
                }
                GameResource.getEnemies().clear();
                GameResource.getOthers().clear();
                System.out.print("last level");
                currentLevel = levels.get(levels.size() - 1);
                render();
                //stop();//протестить надо ещё
                return;
            }
        }
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
        System.out.print("Game was stopped!");
        cleanUp();
    }

    private void wantRepeat()
    {
        changeRunningState();
        System.out.print("Want you repeat this level?");
        Scanner scan  = new Scanner(System.in);
        if(scan.nextInt() == 1){changeRunningState(); run();}
        else{stop();}
    }

    private void update()
    {
        if(((MyTank)GameResource.getMyTank()).isMyTankKilled(GameResource.getEnemies()))
        {
                render();
                wantRepeat();
        }
        else
        if(((MyTank)GameResource.getMyTank()).isAppleCollision(GameResource.getOthers()))
        {
            appleCount--;
            if (appleCount == 0)
            {
                newLevel();
            }
        }
        else
        if (input.getKey(KeyEvent.VK_ESCAPE)){
            System.out.println("lalka");
        } else
        if(input.getKey(KeyEvent.VK_UP)){
            GameResource.getMyTank().move(KeyEvent.VK_UP);
        }else
        if(input.getKey(KeyEvent.VK_DOWN)){
            GameResource.getMyTank().move(KeyEvent.VK_DOWN);
        }else
        if(input.getKey(KeyEvent.VK_LEFT)){
            GameResource.getMyTank().move(KeyEvent.VK_LEFT);
        }else
        if(input.getKey(KeyEvent.VK_RIGHT)){
            GameResource.getMyTank().move(KeyEvent.VK_RIGHT);
        }
        //if(currentLevel.isCompleted)newLevel();

        //эта штука анализирует столкновения объектов, движение, жизни, вызывая необходимые методы типа взрыв танка,
    }

    private void render()
    {
        Display.clear();
        graphics.setColor(new Color(0x120000));
        ShowPicture.showPicture(graphics, GameResource.getEnemies(),GameResource.getMyTank(), GameResource.getOthers());
        Display.swapBuffers();
    }

    public void run()
    {
        TanksConstruction.createTanks(currentLevel, graphics);
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
            //if (i==500 || i ==1500){changeRunning();}
            //i++;
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
        //newLevel();
    }

    private void cleanUp()
    {
        Display.destroy();
    }
}
