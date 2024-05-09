import java.awt.*;
import javax.swing.*;

public class Map extends JFrame {
    private int x;
    private int y;

    public Map(int x, int y) {
        setBounds(300, 500, 430, 430);
        setVisible(true);
        this.x = x;
        this.y = y;

    }

    public void draw(Graphics g) {
        for (int x = 40; x <= 360; x += 40)
            for (int y = 40; y <= 360; y += 40)
                g.drawRect(x, y, 40, 40);
    }

    public void draw2(Graphics g) {
        g.setColor(Color.MAGENTA);
        this.x++;
        this.y++;
        g.fillOval((45 * this.x), (45 * this.y), 30, 30);
        

    }

    public void paint(Graphics g) {
        super.paint(g);
        draw(g);
        draw2(g);
    }

    public static void main(String args[]) {
        PlayableChar p = new PlayableChar("null", 10, 10);
        p.goSouth();
        p.goSouth();
        p.goSouth();
        Map application = new Map(p.getLocationX(), p.getLocationY());
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
} 