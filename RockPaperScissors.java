import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    // Valid choices for the game
    private static final String[] CHOICES = {"Rock", "Paper", "Scissors"};

    // Class to store round history
    static class RoundRecord {
        int roundNumber;
        String playerMove;
        String computerMove;
        String result;

        RoundRecord(int roundNumber, String playerMove, String computerMove, String result) {
            this.roundNumber = roundNumber;
            this.playerMove = playerMove;
            this.computerMove = computerMove;
            this.result = result;
        }
    }

    /**
     * Determines the winner of a single round based on standard RPS rules.
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 5;
        RoundRecord[] history = new RoundRecord[totalRounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("==========================================");
        System.out.println("  WELCOME TO THE COLLEGE CODING ARCADE!   ");
        System.out.println("==========================================");

        for (int i = 0; i < totalRounds; i++) {
            int roundNum = i + 1;
            System.out.println("\n--- Round " + roundNum + " ---");
            System.out.print("Enter move (Rock, Paper, Scissors): ");
            String playerMove = scanner.nextLine().trim();

            // Validate input
            while (!playerMove.equalsIgnoreCase("Rock") && 
                   !playerMove.equalsIgnoreCase("Paper") && 
                   !playerMove.equalsIgnoreCase("Scissors")) {
                System.out.print("Invalid choice! Enter Rock, Paper, or Scissors: ");
                playerMove = scanner.nextLine().trim();
            }

            // Capitalize properly for visual consistency
            playerMove = playerMove.substring(0, 1).toUpperCase() + playerMove.substring(1).toLowerCase();

            // Generate computer move
            String computerMove = CHOICES[random.nextInt(CHOICES.length)];

            // Determine winner
            String result = playRound(playerMove, computerMove);
            System.out.println("Computer chose: " + computerMove);
            System.out.println("Outcome: " + result);

            // Record statistics
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            // Save round log
            history[i] = new RoundRecord(roundNum, playerMove, computerMove, result);
        }

        // Print Summary Table
        System.out.println("\n=================================================");
        System.out.println("                 MATCH SUMMARY                   ");
        System.out.println("=================================================");
        System.out.printf("%-8s | %-12s | %-13s | %-13s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-------------------------------------------------");

        for (RoundRecord record : history) {
            System.out.printf("%-8d | %-12s | %-13s | %-13s%n", 
                    record.roundNumber, record.playerMove, record.computerMove, record.result);
        }

        System.out.println("-------------------------------------------------");

        // Calculate Win Percentage
        double winPercentage = ((double) wins / totalRounds) * 100;

        // Print Final Stats
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", 
                wins, losses, draws, winPercentage);
        System.out.println("=================================================");

        scanner.close();
    }
}