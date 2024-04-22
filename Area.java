import java.util.ArrayList;
import com.google.common.graph.*;

public class Area {
    String name;
    String desc;
    ArrayList enemyList;
  
    public Area(String name, String desc) {
      this.name = name;
      this.desc = desc;
      // this.enemyList = new ArrayList<Enemy>; // haven't merged in the Enemy class yet**
    }
  
    public void leaveArea(){
      
    }
    
    public String toString() {
      return name;
    }
    

    // MAP BUILDER
  // public static void buildMap() {
  //   // Create the area objects for our map
  //   Area bass = new Area("Kelp Forest", "DESC GOES HERE");
  //   Area mcConnell = new Area("Thermal Vents", "DESC GOES HERE");
  //   Area burton = new Area("Final Zone", "DESC GOES HERE");
  //   Area sabinReed = new Area("Secret Area", "DESC GOES HERE");

  //   ImmutableGraph<Area> map = GraphBuilder.undirected()
  //       .<Area>immutable()
  //       .putEdge(bass, mcConnell)
  //       .putEdge(mcConnell, sabinReed)
  //       .putEdge(sabinReed, burton)
  //       .build();

  //       System.out.println(map);
  // }
  }
