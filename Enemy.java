public class Enemy {
    private String type;
    private int hp;
    private int attack;
    private int defense;
    
    private int level;
    private int exp; 

    public Enemy(String type, int level, int maxHp, int attack, int defense){
        this.type = type;
        this.level = level;
        this.defense = level * 2;
        this.attack = level * 3;
        this.hp = level * 4;
        this.exp = level * 2;
    }

    /**
     * Getter methods
     */
    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentHealth() {
        return hp;
    }

    public int getAttack(){
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void attack(PlayableChar player) {
        int damage = Math.max(attack - player.getDefense(), 0); // Calculate damage after considering defense
        System.out.println(type + " attacks you for " + damage + " damage!");
        player.takeDamage(damage);
    }

    public void takeDamage(int dmg){
        if (dmg/this.defense < 1) {
            this.hp -= 1;
        }
        this.hp -= dmg/this.defense;
    }
    
}
