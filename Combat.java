import java.util.ArrayList;
import java.util.Scanner;

public class Combat {

    // Scanner info
    Scanner combatScanner = new Scanner(System.in);
    private String userInput = ""; // to store user input
    // private ArrayList<Enemy> enemies;

    public Combat() { 
    //   this.enemies = new ArrayList<>();
    }

    // Methods

    public void printCombatMenu(){
        System.out.println();
        System.out.println("---Combat Options---");
        System.out.println("1. Attack");
        System.out.println("2. Examine");
        System.out.println("3. Run");
        System.out.println("-----------------");
    }

    /**
     * Player attacks; subtracts from enemy HP
     * 
     * @param foe
     */
    public void playerAttack(Enemy foe, int dmg) {
        System.out.println("The Player Attacks " + foe.getType());
        foe.takeDamage(dmg);
    }

    /**
     * Enemy's attack; subtracts from player HP
     * 
     * @param player
     */
    public void enemyAttack(PlayableChar player, int dmg) {
        System.out.println("The Enemy Attacks " + player.getName());
        player.takeDamage(dmg);

    }

    /**
     * Simple combat loop that detects for specific user input and changes the
     * values for player or enemy HP accordingly
     */
    public void combatLoop(PlayableChar player, Enemy foe) {
        while (player.getHealth() > 0 && foe.HP > 0) {
            userInput = combatScanner.nextLine().toUpperCase();
            if (userInput.contains("ATTACK")) {
                playerAttack(foe, 10);
                System.out.println(foe.HP);
            }
            else if (userInput.contains("OUCH")) {
                enemyAttack(player, 10);
                System.out.println(player.getHealth());
            }else {
                System.out.println("Input a valid command!");
                // if we have a print commands function we could call it here to remind the
                // player of what they can do here
            }
            printCombatMenu();
        }
        if (foe.HP <= 0) {
            System.out.println("Battle Won!");
        }
        if (player.getHealth() <= 0) {
            System.out.println("Battle Lost!");
        }
    }

    public static void main(String[] args) {
        PlayableChar Joe = new PlayableChar("Joe", 20, 20, 5);
        Enemy Evil_Joe = new Enemy("Evil Joe", 2);
        Combat combatTest = new Combat();
        combatTest.combatLoop(Joe, Evil_Joe);
    }
}

// ----------------------------------------------------------------------------
// Notes:
// *Could return boolean T/F for if the battle is won, to send to our main game
// loop whether to end game or not

// *If we have multiple player characters we could end the battle when
// their sum is equal to zero. And we can hopefully avoid bugs with negative
// health by having it so when health falls below zero, the health gets set to
// zero!

// *Need to find a way to determine turn order. Options:
// Random number generator
// Speed stats
// Just have all players attack, then all enemies attack
// etc. (put more ideas here)

// ----------------------------------------------------------------------------