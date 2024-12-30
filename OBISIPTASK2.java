
import javax.swing.*;
import java.util.Random;



public class OBISIPTASK2 {
   
    public static void main(String[] args) {
        Random random = new Random();
        int totalRounds = 3; // Total number of rounds
        int totalScore = 0; // Player's total score

        for (int round = 1; round <= totalRounds; round++) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0; // Number of attempts made by the player
            boolean hasGuessedCorrectly = false;

            // Inform the player about the round
            JOptionPane.showMessageDialog(null, "Round " + round + " of " + totalRounds);
            JOptionPane.showMessageDialog(null, "Guess a number between 1 and 100.");

            while (!hasGuessedCorrectly && attempts < 10) {
                String userInput = JOptionPane.showInputDialog("Enter your guess: ");
                int userGuess;

                try {
                    userGuess = Integer.parseInt(userInput);
                    attempts++;

                    if (userGuess < 1 || userGuess > 100) {
                        JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 100.");
                        attempts--; // Don't count this as an attempt
                        continue;
                    }

                    if (userGuess == numberToGuess) {
                        hasGuessedCorrectly = true;
                        JOptionPane.showMessageDialog(null, "Congratulations! You've guessed the number: " + numberToGuess);
                        totalScore += (10 - attempts); // Score calculation based on attempts
                    } else if (userGuess < numberToGuess) {
                        JOptionPane.showMessageDialog(null, "Too low! Try again.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Too high! Try again.");
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                    attempts--; // Don't count this as an attempt
                }
            }

            if (!hasGuessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Sorry, you've used all your attempts. The number was: " + numberToGuess);
            }

            JOptionPane.showMessageDialog(null, "Your score for this round: " + (10 - attempts) + "\nTotal score: " + totalScore);
        }

        JOptionPane.showMessageDialog(null, "Game Over! Your final score: " + totalScore);
    }

}
