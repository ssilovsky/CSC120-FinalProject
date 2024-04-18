import java.util.ArrayList;

public class Area {
    // private ArrayList<NPC> npcList;
    // private ArrayList<Enemy> enemyList;
    private boolean canLeave;

    public Area() {
        this.canLeave = false;

    }

    public boolean getcanLeave(){
        if (this.canLeave) {
            System.out.println("You can leave yet.");
        } else {
            System.out.println("You cannot leave yet.");
        }
        return this.canLeave;
    }

}
