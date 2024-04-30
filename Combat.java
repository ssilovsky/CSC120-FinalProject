
// import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class Combat {
    // Scanner info + Initalization
    Scanner combatScanner = new Scanner(System.in);
    private String userInput = ""; // to store user input
    private Boolean battlewon = null;
    Random crit = new Random();

    // constructor for Combat class
    public Combat() {
        // this.enemies = new ArrayList<>();
    }

    // Methods
    public void printCombatMenu() {
        System.out.println();
        System.out.println("---Combat Options---");
        System.out.println("1. Battle Stance");
        System.out.println("2. Attack");
        System.out.println("3. Examine");
        System.out.println("4. Run");
        System.out.println("-----------------");
        System.out.print("Input an option: ");
    }

    /**
     * Clears the console
     */
    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // PLAYER METHODS
    /**
     * Player attacks; subtracts from enemy HP
     * 
     * @param foe
     * @param dmg
     */
    public void playerAttack(Enemy foe, int dmg) {
        int c = crit.nextInt(100) + 1; //
        if (c >= 5) {
            System.out.println("You attack the " + foe.getType() + "!");
            foe.takeDamage(dmg);
        } else {
            playerCrit(foe, dmg);
        }
    }

    /**
     * Player crits for a damage multiplier (1.5x dmg + dmg); subtracts from enemy
     * HP
     * 
     * @param foe
     * @param dmg
     */
    public void playerCrit(Enemy foe, int dmg) {
        System.out.println("You get a critical hit on the " + foe.getType() + "!!!!!!!");
        System.out.println("    ,--.                                                      ,---.         ,--.     \n" + //
                " .-,|  |,-.      ,--.   ,--. ,--.  ,--.   ,---.   ,--.   ,--. |   |      .-,|  |,-.  \n" + //
                " _\\ '  ' /_      |  |   |  | |  '--'  |  /  O  \\  |   `.'   | |  .'      _\\ '  ' /_  \n" + //
                "(__      __)     |  |.'.|  | |  .--.  | |  .-.  | |  |'.'|  | |  |      (__      __) \n" + //
                "  / .  . \\       |   ,'.   | |  |  |  | |  | |  | |  |   |  | `--'        / .  . \\   \n" + //
                " `-'|  |`-'      '--'   '--' `--'  `--' `--' `--' `--'   `--' .--.       `-'|  |`-'  \n" + //
                "    `--'                                                      '--'          `--'    ");
        foe.takeDamage((3 * dmg) / 2 + dmg);
    }

    // ENEMY METHODS
    /**
     * Enemy's attack; subtracts from Player HP
     * 
     * 
     * @param dmg
     */
    public void enemyAttack(PlayableChar player, int dmg) {
        int c = crit.nextInt(100) + 1; //
        if (c >= 5) {
            System.out.println("\nThe enemy swings furiously at " + player.getName() + "!");
            player.takeDamage(dmg);
        } else {
            enemyCrit(player, dmg);
        }

    }

    /**
     * Enemy crits for a damage multiplier (1.5x dmg + dmg); subtracts from player
     * HP
     * 
     * @param foe
     * @param dmg
     */
    public void enemyCrit(PlayableChar player, int dmg) {
        System.out.println("The enemy gets a critical hit on " + player.getName() + "!!!!!!!");
        System.out.println("    ,--.                                                 ,---.         ,--.     \n" + //
                " .-,|  |,-.       ,-----.  ,--. ,--.  ,-----. ,--.  ,--. |   |      .-,|  |,-.  \n" + //
                " _\\ '  ' /_      '  .-.  ' |  | |  | '  .--./ |  '--'  | |  .'      _\\ '  ' /_  \n" + //
                "(__      __)     |  | |  | |  | |  | |  |     |  .--.  | |  |      (__      __) \n" + //
                "  / .  . \\       '  '-'  ' '  '-'  ' '  '--'\\ |  |  |  | `--'        / .  . \\   \n" + //
                " `-'|  |`-'       `-----'   `-----'   `-----' `--'  `--' .--.       `-'|  |`-'  \n" + //
                "    `--'                                                 '--'          `--'  ");
        player.takeDamage((2 * dmg) / 3 + dmg);

    }

    /**
     * getter for battlewon, to tell the main whether the tile should be blank or
     * not after battle ends
     * 
     * @return battlewon
     */
    public boolean getBattleResult() {
        return this.battlewon;

    }

    /**
     * Combat loop that detects for specific user input and changes the values for
     * player or enemy HP accordingly
     */
    public void combatLoop(PlayableChar player, Enemy foe) {
        Random dice = new Random();
        clearConsole();
        System.out.println();
        System.out.println("You enter battle with " + foe.getType() + "!");
        while (player.getCurrentHealth() > 0 && foe.getCurrentHealth() > 0) {
            System.out.println("\n>> 🦈 Player health: " + player.getCurrentHealth() + " 🦈 <<");
            System.out.println("\n>> 👹 Enemy health: " + "???" + " 👹 <<");
            printCombatMenu();
            userInput = combatScanner.nextLine().toUpperCase(); 
            System.out.println();
            if (userInput.equals("BATTLE STANCE") || userInput.equals("1")){
                System.out.println("\nYou ready yourself for your next attack!");
                enemyAttack(player, foe.getAttack());
                System.out.println("\nThe enemy continues to strike as you ready yourself!");
                enemyAttack(player, foe.getAttack());
                playerAttack(foe, player.getAttack()*2);
                System.out.print("     -=->> You unleash a series of furious blows on the enemy! The enemy's blood sloshes through the water... <<-=- \n");
            }
            else if (userInput.equals("ATTACK") || userInput.equals("2")) {
                clearConsole();
                playerAttack(foe, player.getAttack());
                enemyAttack(player, foe.getAttack());

            } else if (userInput.equals("EXAMINE") || userInput.equals("3")) {
                clearConsole();
                foe.examine();
                if(player.getLevel() > foe.getLevel()){
                System.out.println("Looks like they might be around " + foe.getCurrentHealth() + "HP");
                }
                else{
                    System.out.println("This enemy is too strong for you to discern their exact HP, however");
                }
            } else if (userInput.equals("RUN") || userInput.equals("4")) {
                clearConsole();
                int ran = dice.nextInt(6) + 1; // roll the diee!
                System.out.println("You rolled a " + ran + " with the Mystic Dice of Fate");
                if (ran >= 5) {
                    System.out.println("Ran from battle!");
                    this.battlewon = false;
                    break;
                } else {
                    System.out.println("You weren't able to escape!");
                    enemyAttack(player, player.getAttack());
                }

            } else {
                System.out.println("Input a valid command!");
                // if we have a print commands function we could call it here to remind the
                // player of what they can do here
            }
        }
        if (foe.getCurrentHealth() <= 0) {
            System.out.println("Battle Won!");
            System.out.println("You Earned " + foe.getExp() + " EXP!");
            player.addExp(foe.getExp());
            System.out.println("Current EXP: " + player.getExp());
            player.healPlayer();
            this.battlewon = true;
        }
        if (player.getCurrentHealth() <= 0) {
            System.out.println("Battle Lost!");
        }
    }

    public static void main(String[] args) {
        PlayableChar joe = new PlayableChar("Joe", 25, 11);
        Enemy eviljoe = new Enemy("Evil Joe", 4);
        Combat combatTest = new Combat();
        combatTest.combatLoop(joe, eviljoe);
    }

}

// ----------------------------------------------------------------------------
// Notes:

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