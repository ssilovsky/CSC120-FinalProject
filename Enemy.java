/**
* This is the enemy class.
* @author  Lucy Auger, Megan Li, Sophia Silovsky
* @version 1.0
* @since   2024-05-09
*/
public class Enemy {
    private String type;
    private int hp;
    private int attack;
    private int defense;
    private int level;
    private int exp; 

    /**
     * Enemy Constructor 
     * @param type
     * @param level
     */
    public Enemy(String type, int level){
        this.type = type;
        this.level = level;
        // scaling formula modified from http://yanfly.moe/tools/enemylevelcalculator/ 
        this.defense = (4 * (1 + (level - 1) * (5/100)) + (4 * (level - 1)));
        this.attack = (5 * (1 + (level - 1) * (5/100)) + (5 * (level - 1)));
        this.hp = (4 * (1 + (level - 1) * (15/100)) + (4 * (level - 1)));
        this.exp = (2 * (1 + (level - 1) * (5/100)) + (2 * (level - 1)));
    }

    /**
     * Getter methods
     */

    /**
     * Get type of enemy
     * @return type, String
     */
    public String getType() {
        return this.type;
    }

    /**
     * Get level of the enemy
     * @return level, int
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Get the current enemy hp
     * @return hp, int
     */
    public int getCurrentHealth() {
        return this.hp;
    }
  
    /**
     * Get the enemy attack
     * @return attack, int
     */
    public int getAttack(){
        return this.attack;
    }

    /**
     * Get enemy defense
     * @return defense, int
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * Get the enemy exp
     * @return exp, int
     */
    public int getExp(){
        return this.exp;
    }

  
    // *** COMBAT *** //
    /**
     * Enemy take damage and decrease that much health
     * @param dmg int
     */
    public void takeDamage(int dmg){
        if (dmg/this.defense < 1) {
            this.hp -= 1;
        }
        this.hp -= Math.round(dmg/this.defense + this.level*Math.random()); 
    }

    /**
     * Heals enemy so it can appear in another tile
     */
    public void healEnemy(){
        this.hp = 4*this.level;
    }
    
    /**
     * Allows the player to examine how close to death the enemy is
     */
    public void examine(){
        if (this.hp <1) {
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
  
    /**
     * Tester for Enemy.java
     * @param args
     */
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
