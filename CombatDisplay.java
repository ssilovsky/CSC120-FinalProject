import java.awt.*;
import javax.swing.JFrame;

    
    public class CombatDisplay extends Canvas {
    
        public void paint(Graphics g) {
            Toolkit t = Toolkit.getDefaultToolkit();
            Image i = t.getImage("cat copy.gif");
            g.drawImage(i,0,0,this);
        }
    
        public static void main(String[] args) {
            CombatDisplay img = new CombatDisplay();
            JFrame f = new JFrame();
            f.add(img);
            f.setSize(384,480);
            f.setVisible(true);
        }
    
    }
