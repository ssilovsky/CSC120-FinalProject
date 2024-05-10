/**
* This is the images of the enemies that appear in combat.
* @author  Lucy Auger, Megan Li, Sophia Silovsky
* @version 1.0
* @since   2024-05-09
*/
import java.awt.*;
import javax.swing.*;

public class CombatFrame extends JFrame {

    /**
     * CombatFrame Constructor
     */
    CombatFrame() {
        this.setVisible(true); // make it visible
        this.setSize(750, 500); // set the size of frame
        this.setTitle("COMBAT!");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // prevent closing window while we have combat open
        this.setResizable(true); // can be resized
        this.setMaximumSize(new Dimension(750, 500)); // resizable within certain bounds
        this.getContentPane().setBackground(new Color(0, 50, 70));
    }

    /**
     * Changes the Icon of the JLabel for the enemy graphic
     * 
     * @param label
     * @param foe
     */
    public void changeEnemy(JLabel label, Enemy foe) {

        // set the images based on enemy (only making new instances seem to work, as
        // otherwise they are seeming to get overridden, sadly)
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
            ImageIcon catfish = new ImageIcon("Images/Catfish.jpg");
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
        if (foe.getType() == "Bubbler Seahorse") {
            ImageIcon bubble = new ImageIcon("Images/Bubbler Seahorse.jpg");
            label.setIcon(bubble);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Jellyfish") {
            ImageIcon jellyfish = new ImageIcon("Images/Jellyfish.jpg");
            label.setIcon(jellyfish);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Siren Snapper") {
            ImageIcon siren = new ImageIcon("Images/Siren Snapper.jpg");
            label.setIcon(siren);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Kelp Golem") {
            ImageIcon kelp = new ImageIcon("Images/Kelp Golem.jpg");
            label.setIcon(kelp);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Weed Wraiths") {
            ImageIcon weed = new ImageIcon("Images/Weed Wraiths.jpg");
            label.setIcon(weed);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Manta Ray") {
            ImageIcon manta = new ImageIcon("Images/Manta.jpg");
            label.setIcon(manta);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Vent Vipers"){
            ImageIcon vent = new ImageIcon("Images/Vent Vipers.jpg");
            label.setIcon(vent);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Steam Spitter"){
            ImageIcon steam = new ImageIcon("Images/Steam Spitter.jpg");
            label.setIcon(steam);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Lava Leech"){
            ImageIcon manta = new ImageIcon("Images/Lava Leech.jpg");
            label.setIcon(manta);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Yeti Crab"){
            ImageIcon yeti = new ImageIcon("Images/Yeti Crab.jpg");
            label.setIcon(yeti);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Bigfin Squid"){
            ImageIcon big = new ImageIcon("Images/Bigfin.jpg");
            label.setIcon(big);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Sunfish"){
            ImageIcon sunfish = new ImageIcon("Images/Sunfish.jpg");
            label.setIcon(sunfish);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Marlin"){
            ImageIcon marlin = new ImageIcon("Images/Marlin.jpg");
            label.setIcon(marlin);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Sailfish"){
            ImageIcon sail = new ImageIcon("Images/Sailfish.jpg");
            label.setIcon(sail);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Dolphin"){
            ImageIcon dolphin = new ImageIcon("Images/Dolphin.jpg");
            label.setIcon(dolphin);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Tuna"){
            ImageIcon tuna = new ImageIcon("Images/Tuna.jpg");
            label.setIcon(tuna);
            this.add(label);
            label.repaint();
        }
        if (foe.getType() == "Kraken"){
            ImageIcon kraken = new ImageIcon("Images/Kraken.gif");
            label.setIcon(kraken);
            this.add(label);
            label.repaint();
        }
        label.repaint();
    }

    /**
     * Tester for CombatFrame.java
     * @param args
     */
    public static void main(String[] args) {
        CombatFrame c = new CombatFrame();
        JLabel jlab = new JLabel();
        Enemy cut = new Enemy("Sunfish", 1);
        c.changeEnemy(jlab, cut);
    }
}
