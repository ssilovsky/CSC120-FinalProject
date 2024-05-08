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
    }

    /**
     * Changes the Icon of the JLabel for the enemy graphic
     * 
     * @param label
     * @param foe
     */
    public void changeEnemy(JLabel label, Enemy foe) {

        // starting area images


        // kelp forest images

        // thermal vent images

        // final area images

        // set the images based on enemy
        foe.getType();
        if (foe.getType() == "Minnow") {
            ImageIcon minnow = new ImageIcon("Images/Minnow.jpg");
            label.setIcon(minnow);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Remora") {
            ImageIcon remora = new ImageIcon("Images/Remora.jpg");
            label.setIcon(remora);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Cuttlefish") {
            ImageIcon cuttlefish = new ImageIcon("Images/Cuttlefish.jpg");
            label.setIcon(cuttlefish);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Rock Crab") {
            ImageIcon rockcrab = new ImageIcon("Images/Rock Crab.jpg");
            label.setIcon(rockcrab);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Catfish") {
            ImageIcon catfish = new ImageIcon("Images/Catfish");
            label.setIcon(catfish);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Orca") {
            ImageIcon orca = new ImageIcon("Images/Orca.jpg");
            label.setIcon(orca);
            this.add(label);
            label.repaint();
        }

    }

    public static void main(String[] args) {
        CombatFrame c = new CombatFrame();
        JLabel jlab = new JLabel();
        Enemy min = new Enemy("Minnow", 1);
        Enemy rem = new Enemy("Orca", 1);
        Enemy cut = new Enemy("Cuttlefish", 1);
        c.changeEnemy(jlab, rem);

    }
}
