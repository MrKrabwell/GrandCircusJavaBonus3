package com.company;

import java.util.Scanner;
import java.util.Random;


public class Main {

    public static int getUserGuess() {
        // Variable declarations
        int userInput = 0;           // User input integer
        boolean validInput = false;  // boolean for validity of input
        Scanner scnr = new Scanner(System.in);  // Scanner object to get user Input
        String junkText = "";                   // String object to hold junk user input.

        // Keep asking the user for a valid input.
        while (!validInput) {
            // Prompt user to enter a number
            System.out.print("Enter your lousy guess: ");
            userInput = scnr.nextInt();
            junkText = scnr.nextLine();

            // Is it between 1 and 100?
            if (userInput < 1 || userInput > 100) {
                System.out.println("That's not a number between 1 and 100.  Try again.\n");
            }
            else {
                validInput = true;
            }
        }
        return userInput;
    }

    /***********************************************************************************************
     * This method asks the uesr to guess the random number and returns the number of guesses used *
     ***********************************************************************************************/
    public static int guessRandomNumber(int number) {
        // Variable declarations
        int userInput = 0;                      // userInput integer
        int numGuesses = 0;                     // Number of guesses it took for user to get it right
        boolean correctGuess = false;           // boolean on if the guess was correct or not.

        // Prompt user to enter guess
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Try to guess it n00b.\n");

        // Loop until user guesses correct number
        while (!correctGuess) {
            // Asking the user for a valid input.
            userInput = getUserGuess();
            // increase the number of guesses it took
            numGuesses++;

            int diffNum = userInput - number;    // difference of user guess and random number

            // If the user's guess is off by less than 10 higher, "Too High"
            if (diffNum > 0 && diffNum <= 10) {
                System.out.println("Too high!\n");
            }
            // If the user's guess is off by less than 10 lower, "Too High"
            else if (diffNum < 0 && diffNum >= -10) {
                System.out.println("Too low!\n");
            }
            else if (diffNum > 10) {
                System.out.println("Way too high!\n");
            }
            else if (diffNum < -10) {
                System.out.println("Way too low!\n");
            }
            // User guessed correctly!
            else {
                System.out.println("The random number was " + number + "!  You guessed correctly!\n");
                correctGuess = true;
            }
        }

        // Return the number of guesses it took
        return numGuesses;
    }

    /*************************************************************************
     * This method asks the user if they want to continue the program or not *
     *************************************************************************/
    public static boolean askUserToContinue(){
        // Variable declarations
        java.lang.String userInput="";                                        // User input string
        java.util.Scanner scan = new java.util.Scanner(java.lang.System.in);  // Scanner object for user input

        // Prompt user to enter yes or no
        java.lang.System.out.print("Try again? (y/n): ");
        userInput=scan.nextLine();

        // Validate whether user input is ok, and continue asking until right
        while(!userInput.equalsIgnoreCase("y")&&
                !userInput.equalsIgnoreCase("yes")&&
                !userInput.equalsIgnoreCase("n")&&
                !userInput.equalsIgnoreCase("no")){
            java.lang.System.out.print("That is not a valid input. ");
                    java.lang.System.out.print("Try again? (y/n): ");
            userInput=scan.nextLine();
        }

        // Return true if user says yes, and false if user says no
        if(userInput.equalsIgnoreCase("y")||userInput.equalsIgnoreCase("yes")){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        // Variable declarations
        boolean contProgram = true;     // boolean to keep the program running or not.
        Random rand = new Random();     // Random number generator objet
        int numGuesses = 0;             // Number of guesses it took for the user to get it right

        // Welcome message
        System.out.println("Welcome to the Guess a Number Game!");
        System.out.println("+++++++++++++++++++++++++++++++++++");

        // Keep the program running until the user terminates
        while (contProgram) {
            // Ask the user to guess the random number
            numGuesses = guessRandomNumber(rand.nextInt(100)+1);

            // Print how many tries it took and how amazing this person is
            System.out.print("You got it in " + numGuesses + " tries.  ");
            if (numGuesses == 1) {
                System.out.println("You must be seriously amazing slash telepathic!");
            }
            else if (numGuesses >= 2 && numGuesses <=5) {
                System.out.println("That's pretty good!");
            }
            else if (numGuesses >= 6 && numGuesses <= 8) {
                System.out.println("That's ok, I guess.  You could do better.");
            }
            else {
                System.out.println("Wow, you suck...");
            }
            System.out.println("");

            // Ask the user if they want to continue to the program
            contProgram = askUserToContinue();
            System.out.println("");
        }

    }
}
