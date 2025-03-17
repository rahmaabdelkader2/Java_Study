import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class DrawLine extends Applet {
    int start_point_x, start_point_y, end_point_x, end_point_y;
    boolean drawing_flag = false;

    public void init() {
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawLine(start_point_x, start_point_y, end_point_x, end_point_y);
    }

    // Inner class
    private class MouseHandler implements MouseListener, MouseMotionListener {
        public void mousePressed(MouseEvent e) {
            start_point_x = e.getX();
            start_point_y = e.getY();
            drawing_flag = true;
        }

        public void mouseDragged(MouseEvent e) {
            if (drawing_flag) {
                end_point_x = e.getX();
                end_point_y = e.getY();
                repaint();
            }
        }

        public void mouseReleased(MouseEvent e) {
            end_point_x = e.getX();
            end_point_y = e.getY();
            repaint();
            drawing_flag = false;
        }

        // override 34an interface lazm a3ml implement l kol el functions eli fih
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mouseMoved(MouseEvent e) {}
    }
}
