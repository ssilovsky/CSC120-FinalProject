import java.util.ArrayList;
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
        ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(Location.START);
        locations.add(Location.KELP);
        locations.add(Location.THERMAL);
        locations.add(Location.SECRET); // subject to change
        locations.add(Location.FINAL);
        // list location thingy

        Coordinate area = new Coordinate(9, 9);
        area.build();
        area.getGrid()[0][2] = Tile.ENEMY;
        area.getGrid()[8][4] = Tile.EXIT;

        System.out.println("Hello " + name
                + "! The royal crown has been taken from the \nkingdom. It's up to you to retrieve the crown before \nit is used for evil!");
        System.out.println("What do you want to do?");

        while (true) {
            // add edge case
            System.out.println("1. Explore");
            System.out.println("2. Check inventory");
            System.out.println("3. Move to another area");
            System.out.println("4. Quit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // examine elements in current area that you are in
                    //
                    while (choice == 1) {
                        System.out.println("Where do you want to go?");
                        // add edge case
                        System.out.println("1. North");
                        System.out.println("2. South");
                        System.out.println("3. East");
                        System.out.println("4. West");
                        int direction = scanner.nextInt();

                        switch (direction) {
                            case 1:
                                player.goNorth();
                            case 2:
                                player.goSouth();
                            case 3:
                                player.goEast();
                            case 4:
                                player.goWest();
                            default:
                                System.out.println("Input a valid command please.");
                                // place mismatch exception 
                        }

                        if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.ENEMY) {
                            // combat loop
                            Combat combatTest = new Combat();
                            Enemy Evil_Joe = new Enemy("Evil Joe", 2);
                            combatTest.combatLoop(player, Evil_Joe);
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.EMPTY;
                        }

                        if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.ITEM) {
                            System.out.println("Do you want to pick this item up?");
                            // figure out scanner
                        }

                        if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.EXIT) {
                            // boss time
                        }

                        if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.WALL) {
                            System.out.println("You cannot go any farther this way!");
                            // add edge case for wall
                        }

                        break;
                    }
                    break;

                case 2:
                    player.displayInventory();
                    break;
                case 3:
                    // movePlayer(scanner, player);
                    // change area stat enum
                    // when change area, print Area description 

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
// System.out.println("Hello " + name + "! The royal crown has been taken from
// the kingdom of Aquamaris. It's your job to retrieve the crown before it is
// used for evil! Explore ");
// "You have died. Game Over!"
// "Restart?"
// Checkpoint system?
// ""