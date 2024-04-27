public class Enemy {

    private String type;
    public int HP;
    private int defense;
    private int attack;
    private int level;
    private int EXP; 

    public Enemy(String type, int level){
        this.type = type;
        this.level = level;
        this.defense = level * 2;
        this.attack = level * 3;
        this.HP = level * 4;
        this.EXP = level * 2;
    }

    public void takeDamage(int dmg){ // private or public?
        if (dmg/this.defense < 1) {
            this.HP -= 1;
        }
        this.HP -= dmg/this.defense;
    }

    public int getAttack(){
        return this.attack;
    }

    public String getType(){
        return this.type;
    }

    public void examine(){
        if (this.HP <1) {
            System.out.println("\nThe " + this.type + " is dead!");
        }
        if (this.HP == 1) {
            System.out.println("\nThe " + this.type + " is almost dead!");
        } 
        if (this.HP > 1 && this.HP <= 5) {
            System.out.println("\nThe " + this.type + " is looking rough.");
        } 
        if (this.HP > 5 ) {
            System.out.println("\nThe " + this.type + " is looking strong.");
        }
    }
    public static void main(String[] args) {
        Enemy e = new Enemy("Silly", 2);
        System.out.println(e.HP);
        e.takeDamage(1);
        e.examine();
        System.out.println(e.HP);
        e.takeDamage(2);
        e.examine();
        System.out.println(e.HP);
        e.takeDamage(20);
        e.examine();
        System.out.println(e.HP);

    }
}
