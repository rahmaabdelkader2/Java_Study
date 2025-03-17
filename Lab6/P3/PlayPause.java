import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Button;


public class PlayPause extends Applet implements Runnable {
	int x = 0, y =0;  // ball positions
    int dx = 10, dy = 10;  //movements
    int ball_radius = 30; 
	boolean right = true; 
    boolean up = true; 
	
	
    private Thread th;
    boolean moving_flag = false;
    private Button startButton, pauseButton;

    public void init() {

        startButton = new Button("Start");
        pauseButton = new Button("Pause");

        add(startButton);
        add(pauseButton);


        // anonymous class 
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!moving_flag) {
                    moving_flag = true;
                    th = new Thread(PlayPause.this);
                    th.start();
                }
            }
        });
        
		// anonymous class 
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moving_flag = false;
                th.suspend();
            }
        });
    }

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, 30, 30);
    }

     public void run() {
        while (true) {
            try {
          
                if (right) {
                    x += dx;} 
				else {
                    x -= dx;}
                if (up) {
				y -= dy;}
                else {
				y += dy;}
                
              
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