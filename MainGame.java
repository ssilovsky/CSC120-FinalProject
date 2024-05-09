import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class MainGame {
    // enemy list instances for different areas
    public static Enemy[] area_1_encounters = { new Enemy("Minnow", 1), new Enemy("Remora", 2),
            new Enemy("Cuttlefish", 1), new Enemy("Rock Crab", 2), new Enemy("Catfish", 2) };
    public static Enemy[] area_2_encounters = { new Enemy("Bubbler Seahorse", 5), new Enemy("Jellyfish", 6),
            new Enemy("Siren Snapper", 6), new Enemy("Kelp Golem", 5), new Enemy("Weed Wraiths", 6) };
    public static Enemy[] area_3_encounters = { new Enemy("Vent Vipers", 10), new Enemy("Steam Spitters", 11),
            new Enemy("Lava Leeches", 10), new Enemy("Yeti Crab", 11) };
    public static Enemy[] area_4_encounters = { new Enemy("Sunfish", 16), new Enemy("Marlin", 16),
            new Enemy("Sailfish", 15), new Enemy("Dolphin", 15), new Enemy("Tuna", 16) };
    public static Enemy[][] enemyGroupings = { area_1_encounters, area_2_encounters, area_3_encounters,
            area_4_encounters };
    public static Enemy[] currentEnemy = enemyGroupings[0];

    // bosses
    public static Enemy[] bossEnemies = { new Enemy("Orca", 5), new Enemy("Manta Ray", 15),
            new Enemy("Bigfin Squid", 20), new Enemy("Kraken", 25) };
    public static Enemy currentBoss = bossEnemies[0];

    // locations
    public static Location[] locations = { Location.START, Location.KELP, Location.THERMAL, Location.FINAL };
    public static Location currentLocation = locations[0];

    // creating coordinate grids for each zone
    public static Coordinate start = new Coordinate(9, 9);
    public static Coordinate kelp = new Coordinate(9, 9);
    public static Coordinate thermal = new Coordinate(9, 9);
    public static Coordinate last = new Coordinate(9, 9);

    // list of the areas
    public static Coordinate[] areas = { start, kelp, thermal, last };
    public static Coordinate area = areas[0];

    // descriptions of each area
    public static String[] descriptions = {
            "\nWelcome to the Kingdom of Aquamaris, a realm veiled \nin mystery and danger, where the ocean's vast expanse meets \nthe ancient majesty of royal rule. Here, beneath \nthe shimmering waves, lies the seat of power \nfor the oceanic monarchy, now thrown into chaos \nafter the theft of the royal crown.",
            "\nWelcome to the Kelp Forest, a tranquil yet perilous sanctuary \nnestled within the depths of the ocean. Here, \ntowering kelp forests sway gently with the ebb and flow of the currents, \ncreating a mesmerizing underwater landscape teeming with life. \nHowever, danger lurks in unexpected places, testing the courage \nof even the most seasoned adventurers.",
            "\nWelcome to the Hydrothermal Abyss, a realm of searing \nheat and primordial energy hidden beneath the \nocean's depths. Here, towering chimneys of mineral-rich \nwater erupt from the seafloor, creating otherworldly landscapes \nteeming with life adapted to the extremes. \nBut amidst the swirling currents and turbulent \ngeothermal activity, danger lurks for those who dare to \nventure into this fiery abyss.",
            "\nWelcome to the Kraken's Abyss, the sinister domain where \nthe evil sea monster holds sway over the darkest depths \nof the ocean. The cries of lost souls and ancient \ncurses echo throughout the lair of the creature with \nunimaginable power and malevolence. \nAs you descend into the murky depths, \nyou see the Kraken’s massive form coiled in the shadows, \nready to unleash its wrath upon any who dare to \nchallenge its supremacy. A faint hue of gold peeks through \nthe tight grasp of its tentacles, could it be the very \ncrown you’ve been searching for?" };
    public static String areaDescription = descriptions[0];

    // used to move the areas forward
    public static int i = 0;

     // Color array for the background
    //  private static Color[] colors = {Color.BLUE, Color.GREEN, Color.ORANGE, Color.DARK_GRAY};
    //  private static Color bgColor = colors[0];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(
                "We recommend playing SHARPG in windowed mode, instead of full screen,\n            as there are pop-ups for the map and combat!");
        System.out.println("\n                 Thank you, and we hope you enjoy!");
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

        // have a quick pause before game starts so that the player can read the above
        // suggestion on window mode
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Something went wrong!"); // there shouldn't be anything to interrupt the thread.sleep
                                                         // since just quick pause
            e.printStackTrace();
        }

        // game start (getting player name)
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

    /**
     * Bad Ending...
     * @param player
     */
    private static void badEnding(){
        System.out.println("\n" + //
                        "   ▄▄▄▄    ▄▄▄      ▓█████▄    ▓█████  ███▄    █ ▓█████▄  ██▓ ███▄    █   ▄████ \n" + //
                        "  ▓█████▄ ▒████▄    ▒██▀ ██▌   ▓█   ▀  ██ ▀█   █ ▒██▀ ██▌▓██▒ ██ ▀█   █  ██▒ ▀█▒\n" + //
                        "  ▒██▒ ▄██▒██  ▀█▄  ░██   █▌   ▒███   ▓██  ▀█ ██▒░██   █▌▒██▒▓██  ▀█ ██▒▒██░▄▄▄░\n" + //
                        "  ▒██░█▀  ░██▄▄▄▄██ ░▓█▄   ▌   ▒▓█  ▄ ▓██▒  ▐▌██▒░▓█▄   ▌░██░▓██▒  ▐▌██▒░▓█  ██▓\n" + //
                        "  ░▓█  ▀█▓ ▓█   ▓██▒░▒████▓    ░▒████▒▒██░   ▓██░░▒████▓ ░██░▒██░   ▓██░░▒▓███▀▒\n" + //
                        "  ░▒▓███▀▒ ▒▒   ▓▒█░ ▒▒▓  ▒    ░░ ▒░ ░░ ▒░   ▒ ▒  ▒▒▓  ▒ ░▓  ░ ▒░   ▒ ▒  ░▒   ▒ \n" + //
                        "  ▒░▒   ░   ▒   ▒▒ ░ ░ ▒  ▒     ░ ░  ░░ ░░   ░ ▒░ ░ ▒  ▒  ▒ ░░ ░░   ░ ▒░  ░   ░ \n" + //
                        "   ░    ░   ░   ▒    ░ ░  ░       ░      ░   ░ ░  ░ ░  ░  ▒ ░   ░   ░ ░ ░ ░   ░ \n" + //
                        "   ░            ░  ░   ░          ░  ░         ░    ░     ░           ░       ░ \n" + //
                        "        ░            ░                            ░                             \n" + //
                        "");
        System.out.println("You have chosen to hand over the royal crown to the figure. \n" + // 
                        "");
        System.out.println("When the figure disappears into the shadows with the crown, you realize the grave \n" + //
                        "mistake you've made. A wave of nausea and dread sweeps over you and your surroundings\n" + //
                        "fall into darkness. Someone (?) catches you before you sink into the deeper wells of\n" + //
                        "the sea. \n" + //
                        "You wake up surrounded by the eerie glow of the bioluminescent flora. Hushed whispers \n" + //
                        "can be heard echoing from all corners of the vast cave you see yourself in. Where is\n" + //
                        "that sound coming from? \n" + //
                        "You gather all your energy to crawl and peer over the nearest ledge where you see the \n" + //
                        "cultists adorned with the same hood as the figure from before. They surround the crown.\n" + //
                        "You try to shout for them to stop but to no avail. Where did your voice go?\n" + //
                        "You watch the golden glow of the crown slowly loses its light. As the cult finalizes its\n" + //
                        "ritual, a sinister energy envelops the dying crown, replaced by a sickly gloom of crimson. \n" + //
                        "In the hands of the cultists, the crown becomes a beacon of malevolence, radiating\n" + //
                        "an aura of corruption.\n" + //
                        "Without the power of the crown, the kingdom will fall into darkness.\n" + //
                        "You failed to save the kingdom and the oceanic realm plunged into chaos.");
    }

     
    /**
     * Good Ending
     * @param player
     */
    private static void goodEnding(){
        System.out.println("\n" + //
                        "          ▄██████▄   ▄██████▄   ▄██████▄  ████████▄             \n" + //
                        "         ███    ███ ███    ███ ███    ███ ███   ▀███            \n" + //
                        "         ███    █▀  ███    ███ ███    ███ ███    ███            \n" + //
                        "        ▄███        ███    ███ ███    ███ ███    ███            \n" + //
                        "       ▀▀███ ████▄  ███    ███ ███    ███ ███    ███            \n" + //
                        "         ███    ███ ███    ███ ███    ███ ███    ███            \n" + //
                        "         ███    ███ ███    ███ ███    ███ ███   ▄███            \n" + //
                        "         ████████▀   ▀██████▀   ▀██████▀  ████████▀             \n" + //
                        "                                                                \n" + //
                        "     ▄████████ ███▄▄▄▄   ████████▄   ▄█  ███▄▄▄▄      ▄██████▄  \n" + //
                        "    ███    ███ ███▀▀▀██▄ ███   ▀███ ███  ███▀▀▀██▄   ███    ███ \n" + //
                        "    ███    █▀  ███   ███ ███    ███ ███▌ ███   ███   ███    █▀  \n" + //
                        "   ▄███▄▄▄     ███   ███ ███    ███ ███▌ ███   ███  ▄███        \n" + //
                        "  ▀▀███▀▀▀     ███   ███ ███    ███ ███▌ ███   ███ ▀▀███ ████▄  \n" + //
                        "    ███    █▄  ███   ███ ███    ███ ███  ███   ███   ███    ███ \n" + //
                        "    ███    ███ ███   ███ ███   ▄███ ███  ███   ███   ███    ███ \n" + //
                        "    ██████████  ▀█   █▀  ████████▀  █▀    ▀█   █▀    ████████▀  \n" + //
                        "                                                                \n" + //
                        "");
        System.out.println("You have chosen to refuse the cult's offer.\n" + //
        "");
        System.out.println("The figure sneers at your decision, attempting to attack, but the \n" + //
                        "trials and tribulations of your journey have made you stronger and \n" + //
                        "much more agile.\n" + //
                        "You manage to quickly swim away from the danger and safely back\n" + //
                        "to the kingdom. As you place the crown back on the rightful throne, \n" + //
                        "the kingdom rejoices in your victory. Peace is restored to the oceanic \n" + //
                        "realm, and your bravery is celebrated for generations to come!\n" + //
                        "Congratulations, adventurer!");
    }
    /**
     * Special Thanks! (Printing out final level and thanks for playing :)
     * 
     * @param player
     */
    private static void specialThanks(PlayableChar player) {
        System.out.println(
                "  _____ _                 _          _____            ____  _             _             \n"
                        + //
                        " |_   _| |__   __ _ _ __ | | _____  |  ______  _ __  |  _ \\| | __ _ _   _(_)_ __   __ _ \n"
                        + //
                        "   | | | '_ \\ / _` | '_ \\| |/ / __| | |_ / _ \\| '__| | |_) | |/ _` | | | | | '_ \\ / _` |\n"
                        + //
                        "   | | | | | | (_| | | | |   <\\__ \\ |  _| (_) | |    |  __/| | (_| | |_| | | | | | (_| |\n"
                        + //
                        "   |_| |_| |_|\\__,_|_| |_|_|\\_|___/ |_|  \\___/|_|    |_|   |_|\\__,_|\\__, |_|_| |_|\\__, |\n"
                        + //
                        "                 ____  _   _    _    ____  ____   ____ _            |___/         |___/ \n"
                        + //
                        "                / ___|| | | |  / \\  |  _ \\|  _ \\ / ___| |                               \n"
                        + //
                        "                \\___ \\| |_| | / _ \\ | |_) | |_) | |  _| |                               \n"
                        + //
                        "                 ___) |  _  |/ ___ \\|  _ <|  __/| |_| |_|                               \n"
                        + //
                        "                |____/|_| |_/_/   \\_|_| \\_|_|    \\____(_)       ");
        System.out.println("\nPlayer Final Level: " + player.getLevel());
        player.printStarfishCount();
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("\n ___              _      _   _____ _              _       \n" + //
                " / __|_ __  ___ __(_)__ _| | |_   _| |_  __ _ _ _ | |__ ___\n" + //
                " \\__ \\ '_ \\/ -_) _| / _` | |   | | | ' \\/ _` | ' \\| / /(_-<\n" + //
                " |___/ .__/\\___\\__|_\\__,_|_|   |_| |_||_\\__,_|_||_|_\\_\\/__/\n" + //
                "     |_|                                                   \n" + //
                "\n" + //
                "                    ☆☆ Professor Jordan ☆☆\n" + //
                "                    ☆☆ Professor Johanna ☆☆\n" + //
                "                     ☆☆ Our Classmates ☆☆\n" + //
                "                  ☆☆ Bobi and the other TAs ☆☆\n" + //
                "\n" + //
                "                 Thank you for a great semester!\n" + //
                "\n                   --Megan, Sophia, and Lucy ☺");
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }

    // main game loop
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
        last.getGrid()[5][5] = Tile.ENEMY;
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

        System.out.println("\nHello " + name
                + "! The royal crown has been taken from the \nkingdom. It's up to you to retrieve the crown before \nit is used for evil!");
        System.out.println(areaDescription);
        System.out.println("What do you want to do?");
        // player.addExp(100);

        int choice;

        while (true) {
            Map application = new Map(player.getLocationX(), player.getLocationY());
            application.getContentPane().setBackground(new Color(0, 200, 200));
            application.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            // add edge case
            System.out.println();
            System.out.println("1. Go North");
            System.out.println("2. Go South");
            System.out.println("3. Go East");
            System.out.println("4. Go West");
            System.out.println("5. Check inventory");
            System.out.println("6. Look Around / Get Location");
            System.out.println("7. Move to another area");
            System.out.println("8. Help");
            System.out.println("9. Quit");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please input an integer.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        player.goNorth();
                    } catch (RuntimeException e) {
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
                        } else {
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.ENEMY;
                        }

                    }

                    if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.STARFISH) {
                        String choice2;
                        String itemName = "Starfish";
                        ItemType type = ItemType.STARFISH;
                        int quantity = 1;
                        System.out.println("You found an item!");
                        System.out.println("Do you want to pick this item up?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        choice2 = scanner.next();
                        if (choice2.equalsIgnoreCase("1")) {
                            player.addToInventory(new Item(itemName, type, quantity));
                            // Then update the tile to EMPTY since the item has been picked up
                            area.setTile(player.getLocationX(), player.getLocationY(), Tile.EMPTY);
                            System.out.println("You picked up " + itemName + "!");
                        } else if (choice2.equals("2")) {
                            System.out.println("You decided not to pick up " + itemName + "!");
                        } else {
                            System.out.println("Invalid response. Please enter '1' or '2'");
                        }
                    }

                    if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.EXIT) {
                        Combat combatBoss = new Combat();
                        combatBoss.combatLoop(player, currentBoss);
                        if (currentBoss == bossEnemies[3]) {
                            String choice3;
                            System.out.println(
                                    "\nYou have defeated the kraken and have found the crown!\n Congra- What is that behind you?");
                            System.out.println("A mysterious, hooded figure emerges from the shadows, offering you a choice: Will you hand over the royal crown to them?");
                            System.out.println("Are you willing to give up the crown?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            choice3 = scanner.next();
                            if (choice3.equalsIgnoreCase("1")) {
                                badEnding();
                            } else if (choice3.equals("2")) {
                                goodEnding();
                            } else {
                                System.out.println("Invalid response. Please enter '1' or '2'");
                            }
                            specialThanks(player);
                            scanner.close();
                            System.exit(0);
                        } else if (combatBoss.getBattleResult()) {
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.EXIT;
                            System.out.println(
                                    "\nWell done you've defeated the boss! You may now move to another area. But be careful! The mysterious creature that has stolen the crown can use its power to draw a new boss to the area, so make haste before another one returns!");
                        } else {
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.EXIT;
                        }
                    }
                    break;
                case 2:
                    try {
                        player.goSouth();
                    } catch (RuntimeException e) {
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
                        } else {
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.ENEMY;
                        }

                    }

                    if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.STARFISH) {
                        String choice2;
                        String itemName = "Starfish";
                        ItemType type = ItemType.STARFISH;
                        int quantity = 1;
                        System.out.println("You found an item!");
                        System.out.println("Do you want to pick this item up?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        choice2 = scanner.next();
                        if (choice2.equalsIgnoreCase("1")) {
                            player.addToInventory(new Item(itemName, type, quantity));
                            // Then update the tile to EMPTY since the item has been picked up
                            area.setTile(player.getLocationX(), player.getLocationY(), Tile.EMPTY);
                            System.out.println("You picked up " + itemName + "!");
                        } else if (choice2.equals("2")) {
                            System.out.println("You decided not to pick up " + itemName + "!");
                        } else {
                            System.out.println("Invalid response. Please enter '1' or '2'");
                        }
                    }


                    if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.EXIT) {
                        Combat combatBoss = new Combat();
                        combatBoss.combatLoop(player, currentBoss);
                        if (currentBoss == bossEnemies[3]) {
                            String choice3;
                            System.out.println(
                                    "\nYou have defeated the kraken and have found the crown!\n Congra- What is that behind you?\n");
                            System.out.println("A mysterious, hooded figure emerges from the shadows, offering you a choice: Will you hand over the royal crown to them?");
                            System.out.println("Are you willing to give up the crown?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            choice3 = scanner.next();
                            if (choice3.equalsIgnoreCase("1")) {
                                badEnding();
                            } else if (choice3.equals("2")) {
                                goodEnding();
                            } else {
                                System.out.println("Invalid response. Please enter '1' or '2'");
                            }
                            specialThanks(player);
                            scanner.close();
                            System.exit(0);
                        } else if (combatBoss.getBattleResult()) {
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.EXIT;
                            System.out.println(
                                    "\nWell done you've defeated the boss! You may now move to another area. But be careful! The mysterious creature that has stolen the crown can use its power to draw a new boss to the area, so make haste before another one returns!");
                        } else {
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.EXIT;
                        }
                    }
                    break;
                case 3:
                    try {
                        player.goEast();
                    } catch (RuntimeException e) {
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
                        } else {
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.ENEMY;
                        }

                    }

                    if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.STARFISH) {
                        String choice2;
                        String itemName = "Starfish";
                        ItemType type = ItemType.STARFISH;
                        int quantity = 1;
                        System.out.println("You found an item!");
                        System.out.println("Do you want to pick this item up?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        choice2 = scanner.next();
                        if (choice2.equalsIgnoreCase("1")) {
                            player.addToInventory(new Item(itemName, type, quantity));
                            // Then update the tile to EMPTY since the item has been picked up
                            area.setTile(player.getLocationX(), player.getLocationY(), Tile.EMPTY);
                            System.out.println("You picked up " + itemName + "!");
                        } else if (choice2.equals("2")) {
                            System.out.println("You decided not to pick up " + itemName + "!");
                        } else {
                            System.out.println("Invalid response. Please enter '1' or '2'");
                        }
                    }

                    if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.EXIT) {
                        Combat combatBoss = new Combat();
                        combatBoss.combatLoop(player, currentBoss);
                        if (currentBoss == bossEnemies[3]) {
                            String choice3;
                            System.out.println(
                                    "\nYou have defeated the kraken and have found the crown!\n Congra- What is that behind you?\n");
                            System.out.println("A mysterious, hooded figure emerges from the shadows, offering you a choice: Will you hand over the royal crown to them?");
                            System.out.println("Are you willing to give up the crown?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            choice3 = scanner.next();
                            if (choice3.equalsIgnoreCase("1")) {
                                badEnding();
                            } else if (choice3.equals("2")) {
                                goodEnding();
                            } else {
                                System.out.println("Invalid response. Please enter '1' or '2'");
                            }
                            specialThanks(player);
                            scanner.close();
                            System.exit(0);
                        } else if (combatBoss.getBattleResult()) {
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.EXIT;
                            System.out.println(
                                    "\nWell done you've defeated the boss! You may now move to another area. But be careful! The mysterious creature that has stolen the crown can use its power to draw a new boss to the area, so make haste before another one returns!");
                        } else {
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.EXIT;
                        }
                    }
                    break;

                case 4:
                    try {
                        player.goWest();
                    } catch (RuntimeException e) {
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
                        } else {
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.ENEMY;
                        }

                    }

                    if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.STARFISH) {
                        String choice2;
                        String itemName = "Starfish";
                        ItemType type = ItemType.STARFISH;
                        int quantity = 1;
                        System.out.println("You found an item!");
                        System.out.println("Do you want to pick this item up?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        choice2 = scanner.next();
                        if (choice2.equalsIgnoreCase("1")) {
                            player.addToInventory(new Item(itemName, type, quantity));
                            // Then update the tile to EMPTY since the item has been picked up
                            area.setTile(player.getLocationX(), player.getLocationY(), Tile.EMPTY);
                            System.out.println("You picked up " + itemName + "!");
                        } else if (choice2.equals("2")) {
                            System.out.println("You decided not to pick up " + itemName + "!");
                        } else {
                            System.out.println("Invalid response. Please enter '1' or '2'");
                        }
                    }

                    if (area.getTile(player.getLocationX(), player.getLocationY()) == Tile.EXIT) {
                        Combat combatBoss = new Combat();
                        combatBoss.combatLoop(player, currentBoss);
                        if (currentBoss == bossEnemies[3]) {
                            String choice3;
                            System.out.println(
                                    "\nYou have defeated the kraken and have found the crown!\n Congra- What is that behind you?\n");
                            System.out.println("A mysterious, hooded figure emerges from the shadows, offering you a choice: Will you hand over the royal crown to them?");
                            System.out.println("Are you willing to give up the crown?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            choice3 = scanner.next();
                            if (choice3.equalsIgnoreCase("1")) {
                                badEnding();
                            } else if (choice3.equals("2")) {
                                goodEnding();
                            } else {
                                System.out.println("Invalid response. Please enter '1' or '2'");
                            }
                            specialThanks(player);
                            scanner.close();
                            System.exit(0);
                        } else if (combatBoss.getBattleResult()) {
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.EXIT;
                            System.out.println(
                                    "\nWell done you've defeated the boss! You may now move to another area. But be careful! The mysterious creature that has stolen the crown can use its power to draw a new boss to the area, so make haste before another one returns!");
                        } else {
                            area.getGrid()[player.getLocationX()][player.getLocationY()] = Tile.EXIT;
                        }
                    }
                    break;
                case 5:
                    player.displayInventory();
                    break;
                case 6:
                    System.out.println(areaDescription);
                    System.out.println("\nYou are at (" + player.getLocationX() + ", " + player.getLocationY() + ")");
                    if (area.getGrid()[player.getLocationX()][player.getLocationY()] == Tile.EMPTY) {
                        System.out.println("This tile is empty, look around on the map for any areas of interest!");
                    } else if (area.getGrid()[player.getLocationX()][player.getLocationY()] == Tile.ENTRANCE) {
                        System.out.println("You are at an entrance, you can move back to a previous area from here!");
                    } else if (area.getGrid()[player.getLocationX()][player.getLocationY()] == Tile.EXIT) {
                        System.out.println("You are at an exit, you can move to the next area from here!");
                    }
                    break;
                case 7:
                    if (area.getGrid()[player.getLocationX()][player.getLocationY()] == Tile.EXIT) {
                        i++;
                        currentLocation = locations[i];
                        area = areas[i];
                        areaDescription = descriptions[i];
                        currentEnemy = enemyGroupings[i];
                        currentBoss = bossEnemies[i];
                        player.setLocationX(0);
                        player.setLocationY(0);
                        System.out.println(areaDescription);

                    } else if (area.getGrid()[player.getLocationX()][player.getLocationY()] == Tile.ENTRANCE) {
                        i--;
                        currentLocation = locations[i];
                        area = areas[i];
                        areaDescription = descriptions[i];
                        currentEnemy = enemyGroupings[i];
                        currentBoss = bossEnemies[i];
                        System.out.println(areaDescription);
                    } else {
                        System.out.println("You are not at an exit yet. Please explore more!");
                    }
                    break;
                case 8:
                    System.out.println("Help menu here");
                    break;
                case 9:
                    System.out.println("Are you sure you want to quit? (y/n)");
                    while (true) {
                        String input = scanner.nextLine().toLowerCase();
                        if (input.equals("n")) {
                            System.out.println("Okay, let's continue!");
                            break;
                        } else if (input.equals("y")) {
                            specialThanks(player);
                            scanner.close();
                            System.exit(0);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
            application.dispose();
        }
    }
}