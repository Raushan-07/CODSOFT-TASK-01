import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            boolean playAgain = true;
            int totalAttempts = 0;
            int roundsWon = 0;

            System.out.println("   ~: Number Guessing Game :~");
            System.out.println("> You have to Guess the number between 1 to 100:");
            System.out.println("> You have only 7 attempts in a Round");
            
            while (playAgain) {
                int minRange = 1;
                int maxRange = 100;
                int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                int attempts = 0;
                boolean guessedCorrectly = false;
                
                
                while (!guessedCorrectly) {
                    System.out.print("  Enter what did you Guess:  ");
                    int guess = scanner.nextInt();
                    attempts++;
                    
                    if (guess == generatedNumber) {
                        System.out.println("Yoooo! You guessed the correct number (" + generatedNumber + ") in " + attempts + " attempts.");
                        guessedCorrectly = true;
                        roundsWon++;
                    } else if (guess < generatedNumber) {
                        System.out.println("  Too low. Guess higher than this");
                    } else {
                        System.out.println("  Too high. Guess lower than this");
                    }
                    
                    if (!guessedCorrectly && attempts >= 7) {
                        System.out.println("I think it's not your day. you've run out of attempts. The correct number was: " + generatedNumber);
                        break;
                    }
                }
                
                totalAttempts += attempts;
                
                System.out.println("\nCurrent score:-\nRounds won: " + roundsWon + ", Total attempts: " + totalAttempts);
                
                System.out.print("\nDo you want to play again? (yes/no): ");
                String playChoice = scanner.next().toLowerCase();
                if (!playChoice.equals("yes")) {
                    playAgain = false;
                }
            }
            
            System.out.println("Thanks for playing Number Guessing Game.I hope you enjoy it");
        }
    }
}
