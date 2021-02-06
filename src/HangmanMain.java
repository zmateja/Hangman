import java.util.HashSet;
import java.util.Scanner;
//import java.util.*;
public class HangmanMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        menu(scan);
        HashSet<Character> guesses = new HashSet<>();
        String word = "Hangman";

    }
    public static void menu(Scanner scan){
        while (true) {
            System.out.println("Welcome to Hangman");
            System.out.println("1. Start Game");
            System.out.println("2. Quit");

            String input = scan.next();
            if (input.equals("1"))
                return;
            else if (input.equals("2"))
                System.exit(0);
            else System.out.println("Invalid Input");
        }
    }
}
