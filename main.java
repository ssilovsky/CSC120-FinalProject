import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class main {

 // enemy list instances for different areas
    public static Enemy[] area_1_encounters = {new Enemy("Minnow", 1), new Enemy("Remora", 2), new Enemy("Cuttlefish", 1), new Enemy("Rock crab", 2), new Enemy("Catfish", 2)};
    public static Enemy[] area_2_encounters = {new Enemy("Bubbler Seahorse", 11), new Enemy("Jellyfish", 12), new Enemy("Siren Snapper", 11), new Enemy("Kelp Golem", 12), new Enemy("Weed Wraiths", 12)};
    public static Enemy[] area_3_encounters = {new Enemy("Vent Vipers", 21), new Enemy("Steam Spitters", 22), new Enemy("Lava Leeches", 22),  new Enemy("Yeti Crab", 22)};
    public static Enemy[] area_4_encounters = {new Enemy("Sunfish", 31), new Enemy("Marlin", 32), new Enemy("Sailfish", 31), new Enemy("Dolphin", 32), new Enemy("Tuna", 32)};
    public static Enemy[][] enemyGroupings = {area_1_encounters, area_2_encounters, area_3_encounters, area_4_encounters};
    public static Enemy[] currentEnemy = enemyGroupings[0];

    public static Enemy[] bossEnemies = {new Enemy("Big Bad 1", 10), new Enemy("Big Bad 2", 20), new Enemy("Big Bad 3", 30), new Enemy("Big Bad 4", 50)};
    public static Enemy currentBoss = bossEnemies[0];

    public static Location[] locations = {Location.START, Location.KELP, Location.THERMAL, Location.FINAL};
    public static Location currentLocation = locations[0];

    public static Coordinate start = new Coordinate(9, 9);
    public static Coordinate kelp = new Coordinate(9, 9);
    public static Coordinate thermal = new Coordinate(9, 9);
    public static Coordinate last = new Coordinate(9, 9);


    public static Coordinate[] areas = { start, kelp, thermal, last};
    public static Coordinate area = areas[0];

    public static String[] descriptions = {
                "\nWelcome to the Kingdom of Aquamaris, a realm veiled \nin mystery and danger, where the ocean's vast expanse meets \nthe ancient majesty of royal rule. Here, beneath \nthe shimmering waves, lies the seat of power \nfor the oceanic monarchy, now thrown into chaos \nafter the theft of the royal crown.",
                "\nWelcome to the Kelp Forest, a tranquil yet perilous sanctuary \nnestled within the depths of the ocean. Here, \ntowering kelp forests sway gently with the ebb and flow of the currents, \ncreating a mesmerizing underwater landscape teeming with life. \nHowever, danger lurks in unexpected places, testing the courage \nof even the most seasoned adventurers.",
                "\nWelcome to the Hydrothermal Abyss, a realm of searing \nheat and primordial energy hidden beneath the \nocean's depths. Here, towering chimneys of mineral-rich \nwater erupt from the seafloor, creating otherworldly landscapes \nteeming with life adapted to the extremes. \nBut amidst the swirling currents and turbulent \ngeothermal activity, danger lurks for those who dare to \nventure into this fiery abyss.",
                ""};
    public static String areaDescription = descriptions[0];

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
        PlayableChar player = new PlayableChar(name, 10, 5);
  

        // build all the areas to have enemies
        start.build();
        start.getGrid()[0][2] = Tile.ENEMY;
        start.getGrid()[0][5] = Tile.ENEMY;
        start.getGrid()[1][3] = Tile.ENEMY;
        start.getGrid()[1][7] = Tile.ENEMY;
        start.getGrid()[2][1] = Tile.ENEMY;
        start.getGrid()[3][3] = Tile.ENEMY;
        start.getGrid()[3][5] = Tile.ENEMY;
        start.getGrid()[4][0] = Tile.ENEMY;
        start.getGrid()[4][7] = Tile.ENEMY;
        start.getGrid()[5][2] = Tile.ENEMY;
        start.getGrid()[6][3] = Tile.ENEMY;
        start.getGrid()[6][6] = Tile.ENEMY;
        start.getGrid()[7][1] = Tile.ENEMY;
        start.getGrid()[7][3] = Tile.ENEMY;
        start.getGrid()[7][4] = Tile.ENEMY;
        start.getGrid()[7][5] = Tile.ENEMY;
        start.getGrid()[8][3] = Tile.ENEMY;
        start.getGrid()[8][5] = Tile.ENEMY;
        start.getGrid()[8][4] = Tile.EXIT;

        kelp.build();
        kelp.getGrid()[0][0] = Tile.ENTRANCE;
        kelp.getGrid()[0][2] = Tile.ENEMY;
        kelp.getGrid()[0][5] = Tile.ENEMY;
        kelp.getGrid()[0][7] = Tile.ENEMY;
        kelp.getGrid()[1][3] = Tile.ENEMY;
        kelp.getGrid()[2][0] = Tile.ENEMY;
        kelp.getGrid()[2][2] = Tile.ENEMY;
        kelp.getGrid()[2][6] = Tile.ENEMY;
        kelp.getGrid()[3][5] = Tile.ENEMY;
        kelp.getGrid()[4][1] = Tile.ENEMY;
        kelp.getGrid()[4][3] = Tile.ENEMY;
        kelp.getGrid()[5][0] = Tile.ENEMY;
        kelp.getGrid()[5][5] = Tile.ENEMY;
        kelp.getGrid()[6][2] = Tile.ENEMY;
        kelp.getGrid()[6][7] = Tile.ENEMY;
        kelp.getGrid()[7][3] = Tile.ENEMY;
        kelp.getGrid()[7][6] = Tile.ENEMY;
        kelp.getGrid()[7][7] = Tile.ENEMY;
        kelp.getGrid()[7][8] = Tile.ENEMY;
        kelp.getGrid()[8][1] = Tile.ENEMY;
        kelp.getGrid()[8][4] = Tile.ENEMY;
        kelp.getGrid()[8][6] = Tile.ENEMY;
        kelp.getGrid()[8][8] = Tile.ENEMY;
        kelp.getGrid()[8][4] = Tile.EXIT;

        thermal.build();
        thermal.getGrid()[0][0] = Tile.ENTRANCE;
        thermal.getGrid()[0][2] = Tile.ENEMY;
        thermal.getGrid()[0][5] = Tile.ENEMY;
        thermal.getGrid()[0][3] = Tile.ENEMY;
        thermal.getGrid()[0][8] = Tile.ENEMY;
        thermal.getGrid()[1][1] = Tile.ENEMY;
        thermal.getGrid()[1][3] = Tile.ENEMY;
        thermal.getGrid()[1][5] = Tile.ENEMY;
        thermal.getGrid()[1][7] = Tile.ENEMY;
        thermal.getGrid()[2][1] = Tile.ENEMY;
        thermal.getGrid()[2][5] = Tile.ENEMY;
        thermal.getGrid()[3][0] = Tile.ENEMY;
        thermal.getGrid()[3][3] = Tile.ENEMY;
        thermal.getGrid()[3][7] = Tile.ENEMY;
        thermal.getGrid()[4][1] = Tile.ENEMY;
        thermal.getGrid()[4][3] = Tile.ENEMY;
        thermal.getGrid()[4][5] = Tile.ENEMY;
        thermal.getGrid()[4][7] = Tile.ENEMY;
        thermal.getGrid()[5][2] = Tile.ENEMY;
        thermal.getGrid()[5][6] = Tile.ENEMY;
        thermal.getGrid()[6][1] = Tile.ENEMY;
        thermal.getGrid()[6][4] = Tile.ENEMY;
        thermal.getGrid()[6][8] = Tile.ENEMY;
        thermal.getGrid()[7][1] = Tile.ENEMY;
        thermal.getGrid()[7][2] = Tile.ENEMY;
        thermal.getGrid()[7][3] = Tile.ENEMY;
        thermal.getGrid()[7][6] = Tile.ENEMY;
        thermal.getGrid()[8][1] = Tile.ENEMY;
        thermal.getGrid()[8][3] = Tile.ENEMY;
        thermal.getGrid()[8][5] = Tile.ENEMY;
        thermal.getGrid()[8][8] = Tile.ENEMY;
        thermal.getGrid()[8][4] = Tile.EXIT;

        last.build();
        last.getGrid()[0][0] = Tile.ENTRANCE;
        last.getGrid()[0][2] = Tile.ENEMY;
        last.getGrid()[0][4] = Tile.ENEMY;
        last.getGrid()[0][6] = Tile.ENEMY;
        last.getGrid()[0][8] = Tile.ENEMY;
        last.getGrid()[1][1] = Tile.ENEMY;
        last.getGrid()[1][3] = Tile.ENEMY;
        last.getGrid()[1][5] = Tile.ENEMY;
        last.getGrid()[1][7] = Tile.ENEMY;
        last.getGrid()[2][0] = Tile.ENEMY;
        last.getGrid()[2][2] = Tile.ENEMY;
        last.getGrid()[2][4] = Tile.ENEMY;
        last.getGrid()[2][6] = Tile.ENEMY;
        last.getGrid()[2][8] = Tile.ENEMY;
        last.getGrid()[3][1] = Tile.ENEMY;
        last.getGrid()[3][3] = Tile.ENEMY;
        last.getGrid()[3][5] = Tile.ENEMY;
        last.getGrid()[3][7] = Tile.ENEMY;
        last.getGrid()[4][0] = Tile.ENEMY;
        last.getGrid()[4][2] = Tile.ENEMY;
        last.getGrid()[4][4] = Tile.ENEMY;
        last.getGrid()[4][6] = Tile.ENEMY;
        last.getGrid()[4][8] = Tile.ENEMY;
        last.getGrid()[5][1] = Tile.ENEMY;
        last.getGrid()[5][3] = Tile.ENEMY;
        last.getGrid()[5][5] = Tile.CROWN;
        last.getGrid()[5][7] = Tile.ENEMY;
        last.getGrid()[6][0] = Tile.ENEMY;
        last.getGrid()[6][2] = Tile.ENEMY;
        last.getGrid()[6][4] = Tile.ENEMY;
        last.getGrid()[6][6] = Tile.ENEMY;
        last.getGrid()[6][8] = Tile.ENEMY;
        last.getGrid()[7][1] = Tile.ENEMY;
        last.getGrid()[7][3] = Tile.ENEMY;
        last.getGrid()[7][5] = Tile.ENEMY;
        last.getGrid()[7][7] = Tile.ENEMY;
        last.getGrid()[7][8] = Tile.ENEMY;
        last.getGrid()[8][0] = Tile.ENEMY;
        last.getGrid()[8][2] = Tile.ENEMY;
        last.getGrid()[8][4] = Tile.ENEMY;
        last.getGrid()[8][6] = Tile.ENEMY;
        last.getGrid()[8][7] = Tile.ENEMY;
        last.getGrid()[8][8] = Tile.EXIT;


        System.out.println("Hello " + name
                + "! The royal crown has been taken from the \nkingdom. It's up to you to retrieve the crown before \nit is used for evil!");
        System.out.println(areaDescription);
        System.out.println("What do you want to do?");
        player.addExp(100);


        int choice;

        while (true) {
            
            // add edge case
            System.out.println();
            System.out.println("1. Explore");
            System.out.println("2. Check inventory");
            System.out.println("3. Move to another area");
            System.out.println("4. Quit");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please input an integer.");
                scanner.next();
                continue;
            }


            switch (choice) {
                case 1:
                    // examine elements in current area that you are in
                    //
                    while (choice == 1) {
                        int direction = 0;
                        System.out.println("Where do you want to go?");
                        // add edge case
                        System.out.println("1. North");
                        System.out.println("2. South");
                        System.out.println("3. East");
                        System.out.println("4. West");

                        try {
                            direction = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Please input an integer.");
                            scanner.next();
                            continue;
                        }
                        try{
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
                        } catch(RuntimeException e){
                            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                            System.out.println("You can't go any further in this direction! Try going another way!");
                            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                        }


                        if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.ENEMY) {
                            // combat loop
                            Combat combatTest = new Combat();
                            Enemy enemy = currentEnemy[(new Random()).nextInt(currentEnemy.length)];
                            combatTest.combatLoop(player, enemy);
                            if (combatTest.getBattleResult()) {
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.EMPTY;
                            } else{
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.ENEMY;
                            }

                        }

                        if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.ITEM) {
                            String itemName = "useless seaweed";
                            ItemType type = ItemType.SEAWEED;
                            System.out.println("You found an item!");
                            System.out.println("Do you want to pick this item up?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            String choice2 = scanner.nextLine();
                            if (choice2.equalsIgnoreCase("1")) {
                                player.addToInventory(new Item(itemName, type));
                                // Then update the tile to EMPTY since the item has been picked up
                                area.setTile(player.getLocationX(), player.getLocationY(), Tile.EMPTY);
                                System.out.println("You picked up " + itemName + "!");
                            } else if (choice2.equals("2")) {
                                System.out.println("You decided not to pick up " + itemName + "!");
                            } else {
                                System.out.println("Invalid response. Please enter '1' or '2'");
                            }
                        }

                        if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.CROWN) {
                            String itemName2 = "･ﾟ*･The Royal Crown✧･ﾟ";
                            ItemType type2 = ItemType.CROWN;
                            System.out.println("You found the crown!");
                            player.addToInventory(new Item(itemName2, type2));
                            // Then update the tile to EMPTY since the item has been picked up
                            area.setTile(player.getLocationX(), player.getLocationY(), Tile.EMPTY);
                            System.out.println("You picked up " + itemName2 + "!");
                        }

                        if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.EXIT) {
                            Combat combatBoss = new Combat();
                            Enemy boss = new Enemy("Furious Orca (Boss)", 10);
                            combatBoss.combatLoop(player, boss);
                            if (combatBoss.getBattleResult()) {
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.EXIT;
                            } else{
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.ENEMY;
                            }
                          System.out.println("Well done you've defeated the boss! You may now move to another area.");
                        }

                        // if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.WALL) {
                        //     System.out.println("You cannot go any farther this way!");
                        //     // add edge case for wall
                        // }

                        break;
                    }
                    break;


                case 2:
                    player.displayInventory();
                    break;
                case 3:

                    if (area.getGrid()[player.getLocationX()][player.getLocationY()] == Tile.EXIT) {
                        currentLocation = locations[+1];
                        area = areas[+1];
                        areaDescription = descriptions[+1];
                        currentEnemy = enemyGroupings[+1];
                        currentBoss = bossEnemies[+1];
                        player.setLocationX(0);
                        player.setLocationY(0);
                        System.out.println(areaDescription);
                    } 
                    else if(area.getGrid()[player.getLocationX()][player.getLocationY()] == Tile.ENTRANCE){
                        currentLocation = locations[-1];
                        area = areas[-1];
                        areaDescription = descriptions[-1];
                        System.out.println(areaDescription);
                    }
                    else {
                        System.out.println("You are not at an exit yet. Please explore more!");
                    }
                    break;
                case 4:
                    // System.out.println("Thanks for playing!"); // font: ivrit
                    System.out.println("  _____ _                 _          _____            ____  _             _             \n" + //
                                                " |_   _| |__   __ _ _ __ | | _____  |  ______  _ __  |  _ \\| | __ _ _   _(_)_ __   __ _ \n" + //
                                                "   | | | '_ \\ / _` | '_ \\| |/ / __| | |_ / _ \\| '__| | |_) | |/ _` | | | | | '_ \\ / _` |\n" + //
                                                "   | | | | | | (_| | | | |   <\\__ \\ |  _| (_) | |    |  __/| | (_| | |_| | | | | | (_| |\n" + //
                                                "   |_| |_| |_|\\__,_|_| |_|_|\\_|___/ |_|  \\___/|_|    |_|   |_|\\__,_|\\__, |_|_| |_|\\__, |\n" + //
                                                "                 ____  _   _    _    ____  ____   ____ _            |___/         |___/ \n" + //
                                                "                / ___|| | | |  / \\  |  _ \\|  _ \\ / ___| |                               \n" + //
                                                "                \\___ \\| |_| | / _ \\ | |_) | |_) | |  _| |                               \n" + //
                                                "                 ___) |  _  |/ ___ \\|  _ <|  __/| |_| |_|                               \n" + //
                                                "                |____/|_| |_/_/   \\_|_| \\_|_|    \\____(_)       ");
                    System.out.println("Player Final Level: " + player.getLevel());
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