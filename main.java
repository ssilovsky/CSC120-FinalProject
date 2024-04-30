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
        Location[] locations = {Location.START, Location.KELP, Location.THERMAL, Location.FINAL};
        Location currentLocation = locations[0];
        Coordinate area_1 = new Coordinate(9, 9);
        area_1.build();
        area_1.getGrid()[0][2] = Tile.ENEMY;
        area_1.getGrid()[0][1] = Tile.ENTRANCE;
        area_1.getGrid()[8][4] = Tile.EXIT;
        
        Coordinate area_2 = new Coordinate(12, 12);
        area_2.build();
        area_2.getGrid()[0][2] = Tile.ENEMY;
        area_2.getGrid()[0][1] = Tile.ENTRANCE;
        area_2.getGrid()[8][4] = Tile.EXIT;

        Coordinate area_3 = new Coordinate(15, 15);
        area_3.build();
        area_3.getGrid()[0][2] = Tile.ENEMY;
        area_3.getGrid()[0][1] = Tile.ENTRANCE;
        area_3.getGrid()[8][4] = Tile.EXIT;

        Coordinate area_4 = new Coordinate(9, 9);
        area_4.build();

        Coordinate[] areas = {area_1, area_2, area_3, area_4};
        Coordinate area = areas[0];
        String[] descriptions = {"\nWelcome to the Kelp Forest, a tranquil yet perilous sanctuary \nnestled within the depths of the ocean. Here, \ntowering kelp forests sway gently with the ebb and flow of the currents, \ncreating a mesmerizing underwater landscape teeming with life. \nHowever, danger lurks in unexpected places, testing the courage \nof even the most seasoned adventurers.", "\nWelcome to the Hydrothermal Abyss, a realm of searing \nheat and primordial energy hidden beneath the \nocean's depths. Here, towering chimneys of mineral-rich \nwater erupt from the seafloor, creating otherworldly landscapes \nteeming with life adapted to the extremes. \nBut amidst the swirling currents and turbulent \ngeothermal activity, danger lurks for those who dare to \nventure into this fiery abyss.", };
        String areaDescription = descriptions[0];


        System.out.println("Hello " + name + "! The royal crown has been taken from the \nkingdom. It's up to you to retrieve the crown before \nit is used for evil!");
        System.out.println("\n" + "Welcome to the Kingdom of Aquamaris, a realm veiled \nin mystery and danger, where the ocean's vast expanse meets \nthe ancient majesty of royal rule. Here, beneath \nthe shimmering waves, lies the seat of power \nfor the oceanic monarchy, now thrown into chaos \nafter the theft of the royal crown.");
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
                                break;
                            case 2:
                                player.goSouth();
                                break;
                            case 3:
                                player.goEast();
                                break;
                            case 4:
                                player.goWest();
                                break;
                            default:
                                System.out.println("Input a valid command please.");
                                break;
                        }
                        if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.EMPTY) {
                            System.out.println("YEET");
                        }

                        if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.ENEMY) {
                            // combat loop
                            Combat combatTest = new Combat();
                            Enemy Evil_Joe = new Enemy("Evil Joe", 2);
                            combatTest.combatLoop(player, Evil_Joe);
                            // if (combatTest.getBattleResult) {
                            //     area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.EMPTY;
                            // } else{
                            //     area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.ENEMY;
                            // }
                            
                        }

                        if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.ITEM) {
                            System.out.println("Do you want to pick this item up?");
                            // figure out scanner
                        }

                        if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.EXIT) {
                            Combat combatBoss = new Combat();
                            Enemy boss = new Enemy("Evil Joe", 10);
                            combatBoss.combatLoop(player, boss);
                            // if (combatBoss.getBattleResult) {
                            //     area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.ENTRANCE;
                            // } else{
                            //     area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.ENEMY;
                            // }
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
                    if(area.getGrid()[player.getLocationX()][player.getLocationY()] == Tile.ENTRANCE){
                        currentLocation = locations[+1];
                        area = areas[+1];
                        areaDescription = descriptions[+1];
                        System.out.println(areaDescription);
                    } else {
                        System.out.println("You are not at an exit yet. Please explore more!");
                    }

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