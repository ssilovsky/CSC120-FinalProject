import java.util.ArrayList;
import com.google.common.graph.*;

public class Area {
    String name;
    String desc;
    ArrayList<Enemy> enemyList;
  
    public Area(String name, String desc) {
      this.name = name;
      this.desc = desc;
      this.enemyList = new ArrayList<Enemy>();
    }
   
    public void leaveArea(){
      
    }
    
    public String toString() {
      return name + " " + desc;
    }
    

    // MAP BUILDER
  public static void buildMap() {
    // Create the area objects for our map
    Area kelp = new Area("Kelp Forest", "DESC GOES HERE");
    Area thermal = new Area("Thermal Vents", "DESC GOES HERE");
    Area end = new Area("Final Zone", "DESC GOES HERE");
    Area secret = new Area("Secret Area", "DESC GOES HERE");

    ImmutableGraph<Area> map = GraphBuilder.undirected()
        .<Area>immutable()
        .putEdge(kelp, thermal)
        .putEdge(thermal, end)
        .putEdge(end, secret)
        .build();

        System.out.println(map);
        System.out.println(kelp);
  }

  public static void main(String[] args) {
   buildMap();
  }
  }
