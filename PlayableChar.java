/**
* This is the playable character class.
* @author  Lucy Auger, Megan Li, Sophia Silovsky
* @version 1.0
* @since   2024-05-09
*/
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
    private ArrayList<Item> inventory;
    private int locationX;
    private int locationY;

    // Combat battleAction;

    /**
     * Constuctor for PlayableChar
     * @param name
     * @param maxHP
     * @param attack
     * @param defense
     */
    public PlayableChar(String name, int attack, int defense) {
        this.name = name;
        this.maxHp = 12;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.level = 1;
        this.exp = 0;
        this.inventory = new ArrayList<Item>();
        this.locationX = 0;
        this.locationY = 0;
    }

    // *** NAVIGATION *** //

    /**
     * Throws exception if player is at top of map
     * Otherwise, the player's Y location is decreased by 1
     */
    public void goNorth() {
        if (this.locationY == 0) {
            this.locationY = 0;
            throw new RuntimeException();
        } else {
            this.locationY -= 1;
        }

    }

    /**
     * Throws exception if player is at bottom of map
     * Otherwise, the player's Y location is increased by 1
     */
    public void goSouth() {
        if (this.locationY == 8) {
            throw new RuntimeException();
        } else {
            this.locationY += 1;
        }

    }

    /**
     * Throws exception if player is at far East of map
     * Otherwise, the player's X location is increased by 1
     */
    public void goEast() {
        if (this.locationX == 8) {
            throw new RuntimeException();
        } else {
            this.locationX += 1;
        }

    }

    /**
     * Throws exception if player is at far West of map
     * Otherwise, the player's X location is decreased by 1
     */
    public void goWest() {
        if (this.locationX == 0) {
            throw new RuntimeException();
        } else {
            this.locationX -= 1;
        }
    }

     // *** MANIPULATORS *** //
    /**
     * Setter for location X
     * @param i
     */
    public void setLocationX(int i){
        this.locationX = i;
    }

    /**
     * Setter for location Y
     * @param i
     */
    public void setLocationY(int i){
        this.locationY = i;
    }



     // *** ACCESSORS *** //

    /**
     * Getter for location X
     * @return locationX, int
     */
    public int getLocationX() {
        return this.locationX;
    }

    /**
     * Getter for location Y
     * @return location Y, int
     */
    public int getLocationY() {
        return this.locationY;
    }

    /**
     * Getter for name
     * @return name, String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for level
     * @return level, int
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Getter for max health
     * @return maxHp, int
     */
    public int getMaxHealth() {
        return this.maxHp;
    }

    /**
     * Getter for current health
     * @return hp, int
     */
    public int getCurrentHealth() {
        return this.hp;
    }

    /**
     * Getter for attack
     * @return attack, int
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * Getter for defense
     * @return defense, int
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * Getter for exp
     * @return exp, int
     */
    public int getExp() {
        return this.exp;

    }

    // ***EXPERIENCE POINTS + LEVELING UP*** //

    /**
     * Method to add experience points, and check for leveling up
     * @param exp
     */
    public void addExp(int exp) {
        this.exp += exp; // add exp
        // Check if the shark should level up
        while(true){
        if (this.exp >= 10 * this.level) {
            levelUp();
        }
        else{
            break;
        }
    }
    }

    /**
     * Method to level up the player and change stats accordingly
     */
    private void levelUp() {
        this.level++;
        this.maxHp += 7; // Increase max health
        this.hp = this.maxHp; // Heal the shark to full health
        this.attack += 5; // Increase attack power
        this.defense += 2; // Increase defense
        System.out.println(this.name + " leveled up to level " + this.level + "!" + "\n HP = " + this.maxHp + "\n Attack = " + this.attack + "\n Defense = " + this.defense);
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

    /**
     * Getter for inventory
     * @return inventory, List<Item>
     */
    public List<Item> getInventory() {
        return this.inventory;
    }

    /**
     * Prints the starfish 
     */
    public void printStarfishCount(){
        if (this.hasCrown()) {
            System.out.println("You collected a total of " + (this.inventory.size() - 1) + " Starfish!");
        } else {
            System.out.println("You collected a total of " + this.inventory.size() + " Starfish!");
        }
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

    public boolean hasCrown() {
        for (Item item : this.getInventory()) {
            if (item.getName().equals("CROWN")) {
                return true;
            }
        }
        return false;
    }

    // ***COMBAT*** //

    /**
     * Method for player to attack enemy
     * 
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
    public void takeDamage(int dmg) {
        if (dmg / this.defense < 1) {
            this.hp -= 1;
        }
        this.hp -= Math.round(dmg / this.defense + this.level*Math.random());  
    }

    /**
     * Setter to reset player health to max health
     */
    public void healPlayer() {
        this.hp = this.maxHp;
        System.out.println(this.name + " rests and heals up!");
    }

    /**
     * Method for player to check remaining health in Enemy
     */
    public void examineEnemy(Enemy enemy) {
        if (enemy.getCurrentHealth() < 1) {
            System.out.println("The " + enemy.getType() + " is dead!");
        }
        if (enemy.getCurrentHealth() == 1) {
            System.out.println("The " + enemy.getType() + " is almost dead!");
        }
        if (enemy.getCurrentHealth() > 1 && this.hp <= this.hp / 2) {
            System.out.println("The " + enemy.getType() + " is looking rough.");
        }
        if (enemy.getCurrentHealth() > this.hp / 2) {
            System.out.println("The " + enemy.getType() + " is looking strong.");
        }
    }
}