import java.applet.Applet;
import java.awt.*;

public class LampDrawing extends Applet {
    public void paint(Graphics g) {
 
 
        // top oval of lamp 
        g.setColor(Color.YELLOW);
        // filling oval with color abve
        g.fillOval(100, 80, 150, 30);
    
		// the oval ouline color
		g.setColor(Color.BLACK);
		// the oval outline
        g.drawOval(100, 80, 150, 30);
		
		
		

        // lamp body ( two line +arc )
        g.drawLine(100, 100, 50, 250);  
        g.drawLine(250, 100, 300, 250); 
		
        g.drawArc(50, 230, 250, 40, 0, -180); 

       // 3 ovals in lamps
        g.setColor(Color.YELLOW);
        g.fillOval(150, 140, 40, 60);
        g.fillOval(100, 160, 40, 40);
        g.fillOval(200, 160, 40, 40);
        g.setColor(Color.BLACK);
        g.drawOval(150, 140, 40, 60);
        g.drawOval(100, 160, 40, 40);
        g.drawOval(200, 160, 40, 40);
		
		
		// Lamp stand
        g.setColor(Color.BLACK);
        g.drawLine(170, 270, 150, 320);
        g.drawLine(180, 270, 200, 320);

     
       // Base
        g.drawRect(125, 320, 100, 20);
    }
}
