import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class MultipleLines extends Applet {
    int[][] lines = new int[3][4]; // Maximum 3 lines allowed
    int lineCount = 0;
    int start_point_x, start_point_y, end_point_x, end_point_y;
    boolean drawing_flag = false;
    String warningMessage = ""; 

    public void init() {
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        for (int i = 0; i < lineCount; i++) {
            g.drawLine(lines[i][0], lines[i][1], lines[i][2], lines[i][3]);
        }
        
        // warining msg
        g.setColor(Color.RED);
        g.drawString(warningMessage, 20, 40);
    }

    private class MouseHandler implements MouseListener {
        public void mousePressed(MouseEvent e) {
            start_point_x = e.getX();
            start_point_y = e.getY();
            drawing_flag = true;
        }

        public void mouseReleased(MouseEvent e) {
            end_point_x = e.getX();
            end_point_y = e.getY();

            if (drawing_flag) {
                if (lineCount < 3) {
                    lines[lineCount][0] = start_point_x;
                    lines[lineCount][1] = start_point_y;
                    lines[lineCount][2] = end_point_x;
                    lines[lineCount][3] = end_point_y;
                    lineCount++;
                    //warningMessage = ""; // Clear warning lw 2a2l
                } else {
                    warningMessage = "3 lines only plz";
                }
                repaint();
            }
            drawing_flag = false;
        }

        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }

    private class MouseMotionHandler implements MouseMotionListener {
        public void mouseDragged(MouseEvent e) {
            end_point_x = e.getX();
            end_point_y = e.getY();
            repaint();
        }

        public void mouseMoved(MouseEvent e) {}
    }
}
