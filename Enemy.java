public class Enemy {

    private String type;
    private int hp;
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
        this.hp -= dmg/this.defense;
    }

    public int getAttack(){
        return this.attack;
    }

    public void examine(Player p ){
        if (Player p.level > this.level, this.hp < 10) {
            System.out.println("This " + this.type + " is pretty weak!");

        }
  
    }
}
