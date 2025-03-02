import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class banner extends Applet implements Runnable {
    String message = "Hellooooooooooooozzzzz ";
    int x = 0; 
    Thread th;

    public void init() {
        th = new Thread(this);
        th.start();
    }

    public void paint(Graphics g) {
        g.setFont(new Font("Ariel", Font.BOLD, 20));
        g.setColor(Color.RED);
        g.drawString(message, x, 100);
    }

    public void run() {
        while (true) {
            try {
                x += 5; // Move text left
                if (x > getWidth()) { 
                   x=0;
                }
                repaint();
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
