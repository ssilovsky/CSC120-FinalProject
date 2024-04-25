import java.util.HashMap;
import java.util.Map;

public class Coordinate {
    private int x;
    private int y;
    Coordinate(int x, int y) { this.x = x ; this.y = y; }

    public static void main(String[] args) {
        int width = 9;
        int height = 9;
    
        Map<Coordinate,Tile> map = new HashMap<Coordinate,Tile>();
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                map.put(new Coordinate(x,y),Tile.EMPTY);
            }
        }
    
        map.put(new Coordinate(0,0), Tile.ENEMY);
        map.put(new Coordinate(0,1), Tile.ENEMY);

        System.out.println(map);
    
    }
}
enum Tile {
    EMPTY,
    ENEMY,
    ITEM
}



