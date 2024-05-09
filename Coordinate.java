public class Coordinate {
    private int x;
    private int y;
    private Tile[][] grid = new Tile[x][y];

    /**
     * Coordinate constructor
     * 
     * @param x int, X coordinate
     * @param y int, Y coordinate
     * 
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        this.grid = new Tile[x][y];
    }

    /**
     * Getter for the 2D array grid
     * 
     * @return gird Tile[][] object, gets the grid of the area
     */
    public Tile[][] getGrid() {
        return this.grid;
    }

    /**
     * Getter for Tile value on grid
     * 
     * @param x
     * @param y
     * @return Tile value from enum
     */
    public Tile getTile(int x, int y) {
        return this.grid[x][y];
    }

    /**
     * Builds the grid so the default value is empty
     */
    public void build() {
        for (this.x = 0; this.x < this.grid.length; this.x++) {
            for (this.y = 0; this.y < this.grid[x].length; this.y++) {
                this.grid[this.x][this.y] = Tile.EMPTY;
            }
        }
    }

    /**
     * Sets the Tile value from the Tile enum
     * 
     * @param x    int X coordinate
     * @param y    int Y coordinate
     * @param tile Tile
     */
    public void setTile(int x, int y, Tile tile) {
        grid[x][y] = tile;
    }

    /**
     * Example / Testing
     * 
     * @param args
     */
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
