import java.util.Scanner;

// basic turn-based Combat loop without Player and Enemy classes implemented
// will include the actual classes later!
public class Combat {
    // placeholder variables until we have the classes
    int playerHp = 20;
    int enemyHp = 20;

    // Will replace with class objects later once the class is made
    // e.g once we have the enemy class it will be like: Enemy targetedEnemy instead
    // of String. And then we could update their attributes directly
    String targetedEnemy = "Enemy";
    String targetedPlayer = "Player";

    // Scanner info
    Scanner combatScanner = new Scanner(System.in);
    String userInput = ""; // to store user input

    // Methods

    /**
     * Player's attack; subtracts from enemy HP
     * 
     * @param targetedEnemy
     */
    public void playerAttack(String targetedEnemy) {
        System.out.println("The Player Attacks " + targetedEnemy);
        enemyHp -= 10;
    }

    /**
     * Enemy's attack; subtracts from player HP
     * 
     * @param targetedPlayer
     */
    public void enemyAttack(String targetedPlayer) {
        System.out.println("The Enemy Attacks " + targetedPlayer);
        playerHp -= 10;

    }

    /**
     * Simple combat loop that detects for specific user input and changes the
     * values for player or enemy HP accordingly
     */
    public void combatLoop() {
        while (playerHp > 0 && enemyHp > 0) {
            userInput = combatScanner.nextLine().toUpperCase();
            if (userInput.contains("ATTACK")) {
                playerAttack(targetedEnemy);
                System.out.println(enemyHp);
            }
            if (userInput.contains("OUCH")) {
                enemyAttack(targetedPlayer);
                System.out.println(playerHp);
            } else {
                System.out.println("Input a valid command!");
                // if we have a print commands function we could call it here to remind the
                // player of what they can do here
            }

        }
        if (enemyHp <= 0) {
            System.out.println("Battle Won!");
        }
        if (playerHp <= 0) {
            System.out.println("Battle Lost!");
        }
    }

    public static void main(String[] args) {
        Combat combatTest = new Combat();
        combatTest.combatLoop();
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