public class Coordinate {
    private int x;
    private int y;
    private Tile[][] grid = new Tile[x][y];

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
        this.grid = new Tile[x][y];
    }

    public Tile[][] getGrid(){
        return this.grid;
    }

    public Tile getTile(int x, int y){
        return this.grid[x][y];
    }

    public void build(){
        for (this.x = 0; this.x < this.grid.length; this.x++){
            for(this.y = 0; this.y < this.grid[x].length; this.y++){
                this.grid[this.x][this.y] = Tile.EMPTY;
            }
        }
    }

    public static void main(String[] args) {
        int width = 9;
        int height = 9;
        Coordinate map = new Coordinate(width, height);
        map.build();
        System.out.println(map.grid[7][1]);
        map.grid[2][2] = Tile.ENEMY;
        System.out.println(map.grid[2][2]);
    }
}

enum Tile {
    EMPTY,
    ENEMY,
    ITEM,
    EXIT,
    ENTRANCE,
    WALL
}



