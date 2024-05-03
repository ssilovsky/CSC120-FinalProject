
// import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class Combat {
    // Scanner info + Initalization
    Scanner combatScanner = new Scanner(System.in);
    private String userInput = ""; // to store user input
    private Boolean battlewon = false;
    Random crit = new Random();
    private int rounds = 1;
    JFrame combatframe = new JFrame(); // making a frame for combat



    // constructor for Combat class
    public Combat() {
        // this.rounds = rounds;

    }

    // Methods
    public void printCombatMenu() {
        System.out.println();
        System.out.println("---Combat Options---");
        System.out.println("1. Battle Stance");
        System.out.println("2. Attack");
        System.out.println("3. Examine");
        System.out.println("4. Run");
        System.out.println("Type 'help' at anytime for tips");
        System.out.println("-----------------");
        System.out.print("Input an option: ");
    }

    public void combatHelp() {
        System.out.println();
        System.out.println(
                "----------------------------------------------------------*Combat Help*-----------------------------------------------------------");
        System.out.println(
                "1. Battle Stance: a risk-reward attack in which you will deal massive damage, but let the enemy get multiple hits off first");
        System.out.println("2. Attack: basic attack against enemy");
        System.out.println(
                "3. Examine: examine the enemy to try to discern how much health they have left. If level is too high, you cannot get exact number");
        System.out.println(
                "4. Run: attempt to run from the battle. Won't always work, best for the only dire circumstances.");
        System.out.println("-'help': prints this menu");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------");
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
            System.out.println("You attack the " + foe.getType() + "!\n");
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

    // public void combatGraphic() {
    //     JFrame combatframe = new JFrame(); // making a frame for combat
    //     combatframe.setVisible(true); // make it visible
    //     combatframe.setSize(800, 600); // set the size of frame
    //     combatframe.setTitle("COMBAT!");
    //     combatframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // prevent closing window while we have combat open
    //     combatframe.setResizable(false); // keep size constant
    //     }


    /**
     * Combat loop that detects for specific user input and changes the values for
     * player or enemy HP accordingly
     */
    public void combatLoop(PlayableChar player, Enemy foe) {
        this.battlewon = false;

        // JFrame Initialization
        combatframe.setVisible(true); // make it visible
        combatframe.setSize(800, 600); // set the size of frame
        combatframe.setTitle("COMBAT!");
        combatframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // prevent closing window while we have combat open
        combatframe.setResizable(false); // keep size constant

        Random dice = new Random();
        clearConsole();
        System.out.println();
        System.out.println("You enter battle with " + foe.getType() + "!");
        while (player.getCurrentHealth() > 0 && foe.getCurrentHealth() > 0) {
            System.out.println("\nROUND " + this.rounds);
            this.rounds++;
            System.out.println("\n>> 🦈 Player health: " + player.getCurrentHealth() + " 🦈 <<");
            System.out.println("\n>> 👹 Enemy health: " + foe.getCurrentHealth() + " 👹 <<");
            printCombatMenu();
            userInput = combatScanner.nextLine().toUpperCase();
            System.out.println();
            if (userInput.equals("HELP")) {
                combatHelp();
            } else if (userInput.equals("BATTLE STANCE") || userInput.equals("1")) {
                System.out.println("\nYou ready yourself for a powerful blow!\n");
                enemyAttack(player, foe.getAttack());
                // System.out.println("\nThe enemy continues to strike as you ready yourself!");
                enemyAttack(player, foe.getAttack());
                playerAttack(foe, 5 * player.getAttack() / 2);
                System.out.println(
                        "     -=->> You unleash a series of furious blows on the enemy! The enemy's blood sloshes through the water... <<-=- \n");
            } else if (userInput.equals("ATTACK") || userInput.equals("2")) {
                clearConsole();
                playerAttack(foe, player.getAttack());
                enemyAttack(player, foe.getAttack());

            } else if (userInput.equals("EXAMINE") || userInput.equals("3")) {
                clearConsole();
                foe.examine();
                if (player.getLevel() > foe.getLevel()) {
                    System.out.println("Looks like they might be around " + foe.getCurrentHealth() + "HP");
                } else {
                    System.out.println("This enemy is too strong for you to discern their exact HP.");
                }
            } else if (userInput.equals("RUN") || userInput.equals("4")) {
                clearConsole();
                int ran = dice.nextInt(6) + 1; // roll the diee!
                System.out.println("You rolled a " + ran + " with the Mystic Dice of Fate");
                if (ran >= 5) {
                    System.out.println("Ran from battle!");
                    System.out.println(
                            "After swimming for your life, you take time to catch whatever breath a shark can have.");
                    player.healPlayer();
                    foe.healEnemy();
                    this.battlewon = false;
                    combatframe.setVisible(false);
                    combatframe.dispose();
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
            foe.healEnemy();
            combatframe.setVisible(false);
            combatframe.dispose();
        }
        if (player.getCurrentHealth() <= 0) {
            System.out.println("Battle Lost!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        PlayableChar joe = new PlayableChar("Joe", 25, 11);
        joe.level = 4;
        Enemy eviljoe = new Enemy("Evil Joe", joe.level);
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