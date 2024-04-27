import java.util.ArrayList;
import java.util.List;

public class PlayableChar {
    private final String name;
    private int maxHp;
    private int hp;
    private int exp;
    private int level;
    private int attack;
    private int defense;
    private List<Item> inventory;
    private int locationX;
    private int locationY;
    
   //Combat battleAction;

    /**
     * 
     * @param name
     * @param maxHP
     * @param attack
     * @param defense
     */
    public PlayableChar(String name, int maxHP, int attack, int defense){
        this.name = name;
        this.maxHp = 100;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.level = 1;
        this.exp = 0;
        this.inventory = new List<>();
        this.locationX = 0;
        this.locationY = 0;
        
    }

  // *** NAVIGATION *** //
    public void goNorth(){
        this.locationY += 1;
    }

    public void goSouth(){
        this.locationY -= 1;
    }

    public void goEast(){
        this.locationX += 1;
    }

    public void goWest(){
        this.locationX -= 1;
    }

    /**
     * Getter methods
     */
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxHealth() {
        return maxHp;
    }

    public int getCurrentHealth() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    // ***EXPERIENCE POINTS + LEVELING UP*** //

    /**
     * Method to add experience points
     */
    public void addExp(int exp) {
        this.exp += exp;
        // Check if the shark should level up
        if (this.exp >= 100 * level) {
            levelUp();
        }
    }

    /**
     * Method to level up the player
     */
    private void levelUp() {
        level++;
        maxHp += 10; // Increase max health
        hp = maxHp; // Heal the shark to full health
        attack += 5; // Increase attack power
        defense += 2; // Increase defense
        System.out.println(name + " leveled up to level " + level + "!");
    }

    // ***INVENTORY*** //

    /**
     * pick up method
     * 
     * @param item
     */
    public void addToInventory(Item item) {
        this.inventory.add(item);
    }

    /**
     * drop item method
     * 
     * @param item
     */
    public void removeFromInventory(Item item) {
        this.inventory.remove(item);
    }

    public List<Item> getInventory(){
        return this.inventory;
    }
  
    public void displayInventory() {
        System.out.println("Inventory of " + name + ":");
        if (inventory.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (Item item : inventory) {
                System.out.println("- " + item.getName());
            }
        }
    }

    // ***COMBAT*** //

    /**
     * Method for player to attack enemy
     * @param enemy
     */
    public void attack(Enemy enemy) {
        int damage = Math.max(attack - enemy.getDefense(), 0); // Calculate damage after considering defense
        System.out.println(name + " attacks " + enemy.getType() + " for " + damage + " damage!");
        enemy.takeDamage(damage);
    }

    /**
     * Method for player to take damage
     */
    public void takeDamage(int damage) {
        int actualDamage = Math.max(damage - defense, 0); // Calculate actual damage after considering defense
        hp -= actualDamage;
        if (hp <= 0) {
            System.out.println("You have been defeated!"); //revive or game over??
        }
    }

    /**
     * Method for player to check remaining health in Enemy
     */
    public void examineEnemy(Enemy enemy){
        if (enemy.getCurrentHealth() < 1) {
            System.out.println("The " + enemy.getType() + " is dead!");
        }
        if (enemy.getCurrentHealth() == 1) {
            System.out.println("The " + enemy.getType() + " is almost dead!");
        } 
        if (enemy.getCurrentHealth() > 1 && this.hp <= 5) {
            System.out.println("The " + enemy.getType() + " is looking rough.");
        } 
        if (enemy.getCurrentHealth() > 5 ) {
            System.out.println("The " + enemy.getType() + " is looking strong.");
        }
    }
}