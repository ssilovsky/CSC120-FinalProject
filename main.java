import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹");
        System.out.println("˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹");
        System.out.println("˚ִִ໋𓍢ִ✧˖𓍢ִִ໋Welcome to the kingdom of Aquamaris!˖𓍢ִִִ໋˚⊹");
        System.out.println("˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹");
        System.out.println("˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ✧˚.₊⊹˖𓍢ִ˚˖𓍢ִִ໋˚˖𓍢ִ✧˚.₊⊹");

        System.out.println("Are you ready?");
            System.out.println("1. Start");
            System.out.println("2. Quit");
        String readyResponse = scanner.nextLine().toLowerCase();

            if (readyResponse.equals("1")) {
                startGame(scanner);
            } else if (readyResponse.equals("2")) {
                System.out.println("Okay, see you soon. Goodbye!");
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Invalid response. Please enter '1' or '2'");
            }
        }
        

        private static void startGame(Scanner scanner) {
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            PlayableChar player = new PlayableChar(name, 100, 10, 5);

            while (true) {
                System.out.println("Hello " + name + "! The royal crown has been taken from the \nkingdom. It's up to you to retrieve the crown before \nit is used for evil!");
                System.out.println("What do you want to do?");
                System.out.println("1. Explore");
                System.out.println("2. Check inventory");
                System.out.println("3. Move to another area");
                System.out.println("4. Quit");
    
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        // examine elements in current area that you are in
                        // 
                        break;
                    case 2:
                        player.displayInventory();
                        break;
                    case 3:
                        //movePlayer(scanner, player);
                        break;
                    case 4:
                        System.out.println("Thanks for playing!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
//System.out.println("Hello " + name + "! The royal crown has been taken from the kingdom of Aquamaris. It's your job to retrieve the crown before it is used for evil! Explore ");
//"You have died. Game Over!"
//"Restart?"
//Checkpoint system? 
//""