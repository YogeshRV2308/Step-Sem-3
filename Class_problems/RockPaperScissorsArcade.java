import java.util.Random;

public class RockPaperScissorsArcade {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    /**
     * Determines the winner of a single round using standard Rock-Paper-Scissors rules.
     * Returns: "Player Wins", "Computer Wins", or "Draw"
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        switch (playerMove.toLowerCase()) {
            case "rock":
                return computerMove.equalsIgnoreCase("Scissors") ? "Player Wins" : "Computer Wins";
            case "paper":
                return computerMove.equalsIgnoreCase("Rock") ? "Player Wins" : "Computer Wins";
            case "scissors":
                return computerMove.equalsIgnoreCase("Paper") ? "Player Wins" : "Computer Wins";
            default:
                return "Invalid Move";
        }
    }

    /**
     * Executes the arcade game session for N rounds and renders the final scoreboard.
     */
    public static void runArcadeSession(String[] predefinedMoves) {
        Random random = new Random();
        int totalRounds = predefinedMoves.length;

        // Arrays to log history for the summary table
        String[] playerMovesHistory = new String[totalRounds];
        String[] computerMovesHistory = new String[totalRounds];
        String[] resultsHistory = new String[totalRounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("=========================================");
        System.out.println("      COLLEGE CODING ARCADE: RPS         ");
        System.out.println("=========================================\n");

        for (int i = 0; i < totalRounds; i++) {
            String playerMove = predefinedMoves[i];
            String computerMove = MOVES[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            // Record history
            playerMovesHistory[i] = playerMove;
            computerMovesHistory[i] = computerMove;
            resultsHistory[i] = result;

            // Track score
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else if (result.equals("Draw")) {
                draws++;
            }

            System.out.printf("Round %d — Player: %s, Computer: %s -> %s%n", 
                    (i + 1), playerMove, computerMove, result);
        }

        // Calculate Win Percentage (excluding invalid moves if any)
        double winPercentage = totalRounds > 0 ? ((double) wins / totalRounds) * 100 : 0.0;

        // Print Tabular Summary
        System.out.println("\n=========================================================");
        System.out.println("                     FINAL SCOREBOARD                    ");
        System.out.println("=========================================================");
        System.out.printf("%-8s | %-13s | %-13s | %-13s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("Round %-2d | %-13s | %-13s | %-13s%n", 
                    (i + 1), playerMovesHistory[i], computerMovesHistory[i], resultsHistory[i]);
        }

        System.out.println("=========================================================");
        System.out.printf("SUMMARY: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", 
                wins, losses, draws, winPercentage);
        System.out.println("=========================================================");
    }

    public static void main(String[] args) {
        // Predefined list of moves for a fast live demo
        String[] samplePlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        runArcadeSession(samplePlayerMoves);
    }
}