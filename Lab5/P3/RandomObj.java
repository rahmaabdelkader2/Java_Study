import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

// el runnable di interface w el thread class mynf34 a extend aktr mn class we el runnable dah interface
public class RandomObj extends Applet implements Runnable {
    int x = 0, y =0; 
    int dx = 10, dy = 10; 
    int ball_radius = 30; 
	boolean right = true; 
    boolean up = true; 

    Thread th;

    public void init() {
        th = new Thread(this);
        th.start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, ball_radius, ball_radius); 
    }

    public void run() {
        while (true) {
            try {
          
      
                if (right) {
                    x += dx;
                } else {
                    x -= dx; 
                }

                if (up) {
					y -= dy;
                } else {
                    y += dy; 
                }
               
			   
			   if (x >= getWidth() - ball_radius) {
                    right=false;
                }
				else if(x<=0){
					right=true;
				}
			   
              
                if ( y >= getHeight() - ball_radius) {
                    up=true;
                }
				else if (y<=0){
					up=false;
				}

                repaint();
                Thread.sleep(50);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
