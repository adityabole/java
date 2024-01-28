import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attempts = 0;
        boolean guessed = false;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between " + lowerBound + " and " + upperBound + ". Guess it!");
        
        while (!guessed) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;
            
            if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                guessed = true;
                System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly in " + attempts + " attempts.");
            }
        }
        
        scanner.close();
    }
}

