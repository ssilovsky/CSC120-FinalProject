import java.util.ArrayList;
import com.google.common.graph.*;

public class Area {
    String name;
    String desc;
    ArrayList<Enemy> enemyList;
  
    public Area(String name, String desc) {
      this.name = name;
      this.desc = desc;
      this.enemyList = new ArrayList<Enemy>(); // haven't merged in the Enemy class yet**
    }
   
    public void leaveArea(){
      
    }
    
    public String toString() {
      return name;
    }
    
    

    // MAP BUILDER
  public static void buildMap() {
    // Create the area objects for our map
    Area kelpForest = new Area("Kelp Forest", "DESC GOES HERE");
    Area hydroThermal = new Area("Thermal Vents", "DESC GOES HERE");
    Area bossArea = new Area("Final Zone", "DESC GOES HERE");
    Area secretArea = new Area("Secret Area", "DESC GOES HERE");

    ImmutableGraph<Area> map = GraphBuilder.undirected()
        .<Area>immutable()
        .putEdge(kelpForest, hydroThermal)
        .putEdge(hydroThermal, bossArea)
        .putEdge(bossArea, secretArea)
        .build();

        System.out.println(map);
  }
  }

  enum Location {
    START,
    KELP,
    THERMAL,
    FINAL,
    SECRET
}

