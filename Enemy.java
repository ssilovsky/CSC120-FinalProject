public class Enemy {

    private String type;
    public int hp;
    private int defense;
    private int attack;
    private int level;
    private int exp; 

    public Enemy(String type, int level){
        this.type = type;
        this.level = level;
        this.defense = level * 2;
        this.attack = level * 3;
        this.hp = level * 4;
        this.exp = level * 2;
    }


    public void takeDamage(int dmg){

        if (dmg/this.defense < 1) {
            this.hp -= 1;
        }
        this.hp -= dmg/this.defense;
    }

    public int getAttack(){
        return this.attack;
    }


    public String getType(){
        return this.type;
    }

    public void examine(){
        if (this.HP <1) {
            System.out.println("The " + this.type + " is dead!");
        }
        if (this.hp == 1) {
            System.out.println("The " + this.type + " is almost dead!");
        } 
        if (this.hp > 1 && this.hp <= 5) {
            System.out.println("The " + this.type + " is looking rough.");
        } 
        if (this.hp > 5 ) {
            System.out.println("The " + this.type + " is looking strong.");
        }
    }
    public static void main(String[] args) {
        Enemy e = new Enemy("Silly", 2);
        System.out.println(e.hp);
        e.takeDamage(1);
        e.examine();
        System.out.println(e.hp);
        e.takeDamage(2);
        e.examine();
        System.out.println(e.hp);
        e.takeDamage(20);
        e.examine();
        System.out.println(e.hp);

    }
}
