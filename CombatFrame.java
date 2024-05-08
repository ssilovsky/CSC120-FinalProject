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
        // this.setLayout(new OverlayLayout(this));

        
        // ImageIcon sharky = new ImageIcon("Images/Minnow.jpg");
        // JLabel background = new JLabel();
        // background.setIcon(sharky);
        // this.add(background);

        JLabel text = new JLabel("Text");
        this.add(text);


        
    }

    /**
     * Changes the Icon of the JLabel for the enemy graphic
     * @param label
     * @param foe
     */
    public void changeEnemy(JLabel label, Enemy foe){
       
        //starting area images
        ImageIcon minnow = new ImageIcon("Images/Minnow.jpg");
        ImageIcon remora = new ImageIcon("Images/Remora.jpg");
        ImageIcon cuttlefish = new ImageIcon("Images/Cuttlefish.jpg");
        ImageIcon rockcrab = new ImageIcon("Images/Rock Crab.jpg");
        ImageIcon orca = new ImageIcon("Images/Orca.jpg");

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
