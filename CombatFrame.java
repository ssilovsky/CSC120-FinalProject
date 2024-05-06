import java.awt.*;
import javax.swing.*;

public class CombatFrame extends JFrame {

    CombatFrame() {
        this.setVisible(true); // make it visible
        this.setSize(750, 500); // set the size of frame
        this.setTitle("COMBAT!");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // prevent closing window while we have combat open
        this.setResizable(false); // keep size constant
        this.getContentPane().setBackground(new Color(0, 50, 70));
   
        // ImageIcon sharky = new ImageIcon("Images/sharky.jpg");
        // JLabel background = new JLabel();
        // background.setIcon(sharky);
        // this.add(background);

        
    }

    /**
     * Changes the Icon of the JLabel for the enemy graphic
     * @param label
     * @param foe
     */
    public void changeEnemy(JLabel label, Enemy foe){
       
        //starting area images
        ImageIcon minnow = new ImageIcon("Images/snarkshark.jpeg");
        ImageIcon remora = new ImageIcon("Images/remora.png");
        ImageIcon cuttlefish = new ImageIcon("Images/cuttlefish.png");

        //kelp forest images

        //thermal vent images

        //final area images

        // set the images based on enemy
        if(foe.getType() == "Minnow"){
            label.setIcon(minnow);
            this.add(label);
        }
        else if(foe.getType() == "Remora"){
            label.setIcon(remora);
            this.add(label);
        }
        else if(foe.getType() == "Cuttlefish"){
            label.setIcon(cuttlefish);
            this.add(label);
        }
    }

    public static void main(String[] args) {
        CombatFrame c = new CombatFrame();
        Enemy min = new Enemy("Minnow", 1);
        JLabel jlab = new JLabel();
        c.changeEnemy(jlab, min);

}
}
