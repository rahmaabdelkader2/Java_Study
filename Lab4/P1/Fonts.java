import java.awt.Toolkit;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
  
// public class Fonts extends Applet {
    String[] available_fonts;
    public void init() {
        available_fonts = Toolkit.getDefaultToolkit().getFontList();
    }
    public void paint(Graphics g) {
        for (int i = 0; i < available_fonts.length; i++) {
            Font f = new Font(available_fonts[i],Font.BOLD, 20);
            g.setFont(f);
            g.drawString(available_fonts[i], 0, 20 + 20 * i);
        }
    }
}

// public class Fonts extends Applet {
    // String[] available_fonts;
    // public void init() {
        // GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        // available_fonts = env.getAvailableFontFamilyNames();
    // }
    // public void paint(Graphics g) {
        // for (int i = 0; i < available_fonts.length; i++) {
            // Font f = new Font(available_fonts[i],Font.BOLD, 20);
            // g.setFont(f);
            // g.drawString(available_fonts[i], 0, 20 + 20 * i);}}
// }