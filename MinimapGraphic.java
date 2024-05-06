import java.awt.*;
import javax.swing.*;


public class MinimapGraphic extends JFrame {


    MinimapGraphic() {
        this.setVisible(true); // make it visible
        this.setSize(800, 800); // set the size of frame
        this.setTitle("Map");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // prevent closing window while we have combat open
        this.setResizable(false); // keep size constant
        this.getContentPane().setBackground(new Color(0, 200, 200));
     
        // this.setLayout(new GridLayout(9,9));
      
        ImageIcon icon = new ImageIcon("snarkshark.jpeg"); 
        JLabel snark = new JLabel("Hi");
        snark.setIcon(icon);

        snark.setHorizontalAlignment(SwingConstants.CENTER);
        snark.setVerticalAlignment(SwingConstants.CENTER);
        this.add(snark);

    }


    public static void main(String[] args) {
        MinimapGraphic minimap = new MinimapGraphic();


}
}