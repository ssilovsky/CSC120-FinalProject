import java.awt.*;
import javax.swing.*;

public class Map extends JFrame {
    private int x;
    private int y;


    /**
     * 
     * Map class constructor
     * 
     * @param x int, x coordinate for the player circle
     * @param y int, x coordinate for the player circle
     * 
     */

    public Map(int x, int y) {
        this.setTitle("Map");
        setBounds(300, 500, 430, 430);
        setVisible(true);
        this.x = x;
        this.y = y;

    }
  
    /**
     * 
     * Draws the grid of the map
     * 
     * @param g Graphics, object of the rectangles
     * 
     */
    public void drawGrid(Graphics g) {
        for (int x = 40; x <= 360; x += 40)
            for (int y = 40; y <= 360; y += 40)
                g.drawRect(x, y, 40, 40);
    }


    /**
     * 
     * Draw the player circle
     * 
     * @param g Graphics, object of the circle
     * 
     */
    public void drawPlayer(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillOval((45 + (40 * this.x)), (45 + (40 * this.y)), 30, 30);

    }

    /**
     * 
     * Combines all the drawings
     * 
     * @param g Graphics, objects of the drawings
     * 
     */
    public void paint(Graphics g) {
        super.paint(g);
        drawGrid(g);
        drawPlayer(g);
    }

    public static void main(String args[]) {
        PlayableChar p = new PlayableChar("null", 10, 10);
        p.goEast();
        p.goSouth();
        p.goEast();
        Map application = new Map(p.getLocationX(), p.getLocationY());
        application.getContentPane().setBackground(Color.DARK_GRAY);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
