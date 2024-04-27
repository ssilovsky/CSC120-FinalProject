
// import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class Combat {
    // Scanner info + Initalization
    Scanner combatScanner = new Scanner(System.in);
    private String userInput = ""; // to store user input
    private ArrayList<Enemy> enemies;
    private ArrayList<PlayableChar> party;

    // constructor for Combat class
    public Combat(ArrayList<Enemy> enemies, ArrayList<PlayableChar> party) {
        this.enemies = new ArrayList<>();
        this.party = new ArrayList<>();
    }

    // Methods
    public void printCombatMenu() {
        System.out.println();
        System.out.println("---Combat Options---");
        System.out.println("1. Attack");
        System.out.println("2. Examine");
        System.out.println("3. Run");
        System.out.println("--------------------");
        System.out.print("Input an option: ");
    }

    /**
     * Clears the console
     */
    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Player attacks; subtracts from enemy HP
     * 
     * @param foe
     * @param dmg
     */
    public void playerAttack(Enemy foe, int dmg) {
        System.out.println("The Player Attacks " + foe.getType());
        foe.takeDamage(dmg);
    }

    /**
     * Enemy's attack; subtracts from Player HP
     * 3
     * 
     * @param dmg
     */
    public void enemyAttack(PlayableChar player, int dmg) {
        System.out.println("\nThe Enemy Attacks " + player.getName());
        player.takeDamage(dmg);

    }

    /**
     * Combat loop
     */
    public void combatLoop(PlayableChar player, Enemy foe) {
        // CombatDisplay img = new CombatDisplay();
        // JFrame f = new JFrame();
        // f.add(img);
        // f.setSize(384, 480);
        // f.setVisible(true);
        Random dice = new Random();
        clearConsole();
        System.out.println();
        System.out.println("COMBAT START!");
        while (player.getHealth() > 0 && foe.HP > 0) {
            System.out.println("--------------------");
            System.out.println("\n>> Player health: " + player.getHealth() + " <<");
            printCombatMenu();
            userInput = combatScanner.nextLine().toUpperCase(); 
            System.out.println();
            if (userInput.equals("ATTACK") || userInput.equals("1")) {
                clearConsole();
                playerAttack(foe, 10);
                enemyAttack(player, 10);

            } else if (userInput.equals("EXAMINE") || userInput.equals("2")) {
                clearConsole();
                foe.examine();
            } else if (userInput.equals("RUN") || userInput.equals("3")) {
                clearConsole();
                int ran = dice.nextInt(1, 6); // roll the diee!
                System.out.println("You rolled a " + ran + " with the Mystic Dice of Fate");
                if (ran >= 5) {
                    System.out.println("Ran from battle!");
                    break;
                } else {
                    System.out.println("You weren't able to escape!");
                    enemyAttack(player, 10);
                }

            } else {
                System.out.println("Input a valid command!");
            }
        }
        if (foe.HP <= 0) {
            System.out.println("Battle Won!");
        }
        if (player.getHealth() <= 0) {
            System.out.println("Battle Lost!");
        }
    }

    public static void main(String[] args) {
        PlayableChar joe = new PlayableChar("Joe", 20, 20, 5);
        PlayableChar dylan = new PlayableChar("Dylan", 20, 20, 5);
        Enemy eviljoe = new Enemy("Evil Joe", 2);
        Enemy evildylan = new Enemy("Evil Dylan", 2);
        ArrayList<PlayableChar> party = new ArrayList<PlayableChar>();
        party.add(joe);
        party.add(dylan);
        ArrayList<Enemy> evilsquad = new ArrayList<Enemy>();
        evilsquad.add(eviljoe);
        evilsquad.add(evildylan);
        Combat combatTest = new Combat(evilsquad, party);
        combatTest.combatLoop(joe, eviljoe);
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