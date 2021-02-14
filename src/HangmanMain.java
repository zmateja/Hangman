import java.util.HashSet;
import java.util.Scanner;
//import java.util.*;
public class HangmanMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        menu(scan);
        play(scan);
        while(true) {
            menu(scan);
            play(scan);
        }
    }
    public static void menu(Scanner scan){
        while (true) {
            System.out.println("Welcome to Hangman");
            System.out.println("1. Start Game");
            System.out.println("2. Quit");

            String input = scan.next();
            if (input.equals("1"))
                return;
            else if (input.equals("2")) {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }

            else System.out.println("Invalid Input");
        }
    }
    public static void play(Scanner scan){
        HashSet<Character> guesses = new HashSet<>();
        String word = "hangman";
        char[] curWordStatus = new char[word.length()];
        for(int i = 0; i < word.length(); i++)
            curWordStatus[i] = '_';
        int Strikes = 0;
        int numRounds = 0;
        int lettersFound = 0;
        int index;
        while((Strikes < 5) && lettersFound < word.length()){
            numRounds+=1;
            roundStart(numRounds,word,Strikes,curWordStatus);

            boolean validGuess = false;
            System.out.println("Guess a letter:");
            while(!validGuess){
                char curGuess = scan.next().charAt(0);
                if(guesses.contains(curGuess)){
                    System.out.println("You already guessed that letter! Guess again.");
                }
                else{
                    guesses.add(curGuess);
                    validGuess = true;
                    index = word.indexOf(curGuess);
                    if(index < 0) {
                        Strikes+=1;
                        System.out.println("Sorry, that letter is not in the word. Strike #" + Strikes);
                        break;
                    }
                    else
                        while(index >= 0) {
                            curWordStatus[index] = curGuess;
                            index = word.indexOf(curGuess,index+1);
                            lettersFound+=1;
                        }
                }
            }

            }
        if(Strikes == 5){
            System.out.println("\nYou ran out of guesses! The word was \"" +word+"\".");
        }
        else if(lettersFound == word.length()){
            System.out.println("Congrats! You guessed all the letters in \"" +word+"\".");
        }
        System.out.println("Returning to main menu...\n\n\n\n");

        }
    public static void roundStart(int curRound, String word, int Strikes, char[] curWordStatus){
        System.out.println("\nRound " + curRound + ":");
        System.out.println("Word to guess:");
        for(int i = 0; i < word.length();i++){
//            if(i>0)
//                System.out.print(" ");
            System.out.print(curWordStatus[i]);
        }
        System.out.println("\n\nIncorrect Guesses Remaining: " + (5-Strikes)+ "\n");

    }
}
