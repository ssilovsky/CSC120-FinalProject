import java.awt.*;
import javax.swing.*;


public class MinimapGraphic extends JFrame {


    MinimapGraphic() {
        this.setVisible(true); // make it visible
        this.setSize(800, 600); // set the size of frame
        this.setTitle("Map");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // prevent closing window while we have combat open
        this.setResizable(false); // keep size constant
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setLayout(new GridLayout(9, 9));
 
    }
}
