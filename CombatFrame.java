import java.awt.*;
import javax.swing.*;

public class CombatFrame extends JFrame {

    CombatFrame() {
        this.setVisible(true); // make it visible
        this.setSize(800, 600); // set the size of frame
        this.setTitle("COMBAT!");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // prevent closing window while we have combat open
        this.setResizable(false); // keep size constant
        this.getContentPane().setBackground(new Color(0, 50, 70));
    }
}
