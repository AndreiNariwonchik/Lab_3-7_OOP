package Game.display;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Arrays;

public abstract class Display {
    private static boolean created = false;
    private static JFrame window;
    private static Canvas content = new Canvas();

    private static BufferedImage buffer;
    private static int[] bufferData;
    private static Graphics bufferGraphics;
    private static int clearColor;

    public static JFrame getWindow() {
        return window;
    }

    public static void create(int width, int height, String title, int _clearColor) {
        if (created) {
            System.out.print("Window was open");
            return;
        } else {
            window = new JFrame(title);
            content = new Canvas();
            Dimension size = new Dimension(width, height);
            content.setPreferredSize(size);
            window.setLocationRelativeTo(null);//окно по середине
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.getContentPane().add(content);
            window.pack();
            window.setVisible(true);
            created = true;

            buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            bufferData = ((DataBufferInt)buffer.getRaster().getDataBuffer()).getData();
            bufferGraphics = buffer.getGraphics();
            clearColor = _clearColor;
        }
    }

    public static float delta = 0;

    public static void clear()
    {
        Arrays.fill(bufferData, clearColor);
    }

    public static void render()
    {
        bufferGraphics.setColor(new Color(0x66FF8800));
        bufferGraphics.fillOval((int)(150+(Math.sin(delta)*200)),250,100,100);
        bufferGraphics.fillRect(90,90,100,50);
        delta+=0.02;
    }

    public static  void swapBuffers()
    {
        Graphics g = content.getGraphics();
        g.drawImage(buffer,0,0,null);

    }
}
