import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String userInput = "";
        String name = "";

        System.out.println("Welcome to Sharktopia!");

        System.out.println("Are you ready? (Please enter 1 or 2)");
        System.out.println("1. Start");
        System.out.println("2. Quit");

        userInput = in.nextLine();
        
        if(Integer.parseInt(userInput) ==  1){
            System.out.println("First, what is your name?");
            userInput = in.nextLine();
            name = userInput;
        }
        else{
            in.close();
        }
        System.out.println("Hello " + name + "!");
        
    }

}
