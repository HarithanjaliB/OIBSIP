import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int round = 1;
        char playAgain;

        System.out.println("===== NUMBER GUESSING GAME =====");

        do {
            int randomNumber = random.nextInt(100) + 1;
            int maxAttempts = 10;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nRound " + round);
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();

                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Correct! You guessed the number.");
                    guessed = true;

                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("Score for this round: " + score);
                    break;
                }

                else if (userGuess < randomNumber) {
                    System.out.println("Too Low!");
                }

                else {
                    System.out.println("Too High!");
                }

                System.out.println("Attempts Left: " + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("You lost!");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("Do you want to play another round? (Y/N): ");
            playAgain = sc.next().charAt(0);

            round++;

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n===== GAME OVER =====");
        System.out.println("Final Score: " + totalScore);

        sc.close();
    }
}