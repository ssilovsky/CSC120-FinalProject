import java.util.Scanner;

public class MainLoop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String userInput = "";
        String name = "";

        System.out.println("Welcome to Sharktopia, the ShaRPG!");

        System.out.println("Are you ready? (Please enter 1 or 2)");
        System.out.println("1. Start");
        System.out.println("2. Quit");

        do{
            userInput = in.nextLine();
            if (userInput.equals("1")) {
                System.out.println("First, what is your name?");
                userInput = in.nextLine();
                name = userInput;
                System.out.println("Hello " + name + "!");
            }
            if (userInput.equals("2")) {
                System.out.println("Oh ok, goodbye!");
                in.close();
                break;
            } else {
                System.out.println("Please input a valid command!");
            }

        }
        while (in.hasNextLine());

    }
}
