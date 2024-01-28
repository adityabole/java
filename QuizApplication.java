import java.util.Scanner;

public class QuizApplication {
    private static final int QUIZ_DURATION_SECONDS = 60;
    private static final int NUM_QUESTIONS = 5;
    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizThread quizThread = new QuizThread();
        quizThread.start();

        System.out.println("Welcome to the Quiz Application!");
        System.out.println("You have " + QUIZ_DURATION_SECONDS + " seconds to answer " + NUM_QUESTIONS + " questions.");

        // Questions
        String[] questions = {
            "What is the capital of France?",
            "Who wrote 'Romeo and Juliet'?",
            "What is the chemical symbol for gold?",
            "What year did the Titanic sink?",
            "What is the tallest mammal?"
        };

        // Choices
        String[][] choices = {
            {"A) Paris", "B) London", "C) Berlin", "D) Rome"},
            {"A) Charles Dickens", "B) Mark Twain", "C) William Shakespeare", "D) Jane Austen"},
            {"A) Ag", "B) Au", "C) Ag", "D) Pt"},
            {"A) 1910", "B) 1912", "C) 1914", "D) 1920"},
            {"A) Elephant", "B) Giraffe", "C) Hippopotamus", "D) Rhino"}
        };

        // Answers
        int[] answers = {0, 2, 1, 1, 1};

        for (int i = 0; i < NUM_QUESTIONS; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
            for (int j = 0; j < choices[i].length; j++) {
                System.out.println(choices[i][j]);
            }
            System.out.print("Your choice (A/B/C/D): ");
            String userChoice = scanner.nextLine().toUpperCase();
            int choiceIndex = -1;
            switch (userChoice) {
                case "A":
                    choiceIndex = 0;
                    break;
                case "B":
                    choiceIndex = 1;
                    break;
                case "C":
                    choiceIndex = 2;
                    break;
                case "D":
                    choiceIndex = 3;
                    break;
            }
            if (choiceIndex == answers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }

        // Stop the timer thread
        quizThread.interrupt();

        System.out.println("\nQuiz over! Your final score is: " + score + "/" + NUM_QUESTIONS);
        scanner.close();
    }

    static class QuizThread extends Thread {
        public void run() {
            for (int i = QUIZ_DURATION_SECONDS; i > 0; i--) {
                System.out.println("Time remaining: " + i + " seconds");
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    return; // Exit thread if interrupted
                }
            }
            System.out.println("Time's up! Quiz has ended.");
        }
    }
}
