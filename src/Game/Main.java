package Game;

import Game.display.Display;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.event.ActionEvent;
//import java.util.Timer;
import javax.swing.*;

public class Main {

    public static void main( String[] args)
    {
        Display.create(500,500,"Tanks", 0xff11AA00);

        Timer t = new Timer(1000/60, new AbstractAction(){
            public void actionPerformed(ActionEvent e)
            {
               Display.clear();
               Display.render();
               Display.swapBuffers();
            }
        });

        t.setRepeats(true);
        t.start();
	    System.out.print(Display.getWindow().getTitle());
    }
}
