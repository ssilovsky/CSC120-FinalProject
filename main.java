import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String userInput = "";
        String name = "";
        boolean isGameOver = false;
        
        System.out.println("˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹");
        System.out.println("˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹");
        System.out.println("˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹Welcome to Sharktopia!˚˖𓍢ִִ໋˚˖𓍢ִ✧˚ִ✧.₊⊹");
        System.out.println("˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹");
        System.out.println("˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹");

        while (!isGameOver) {
            System.out.println("What do you want to do?");
            System.out.println("1. Explore");
            System.out.println("2. Check inventory");
            System.out.println("3. Quit");

        System.out.println("Are you ready? (Please enter 1 or 2)");
        System.out.println("1. Start");
        System.out.println("2. Quit");

        userInput = in.nextLine();

        int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Implement explore logic here, including battles and clues
                    // Example: map.explore(player);
                    break;
                case 2:
                    player.displayInventory();
                    break;
                case 3:
                    System.out.println("Thanks for playing!");
                    isGameOver = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        if(Integer.parseInt(userInput) ==  1){
            System.out.println("First, what is your name?");
            userInput = in.nextLine();
            name = userInput;
        }
        else{
            in.close();
        }
        System.out.println("Hello " + name + "! The royal crown has been taken from the kingdom of Aquamaris. It's your job to retrieve the crown before it is used for evil! Explore ");

    }
/**
 * ? command
 */
}
