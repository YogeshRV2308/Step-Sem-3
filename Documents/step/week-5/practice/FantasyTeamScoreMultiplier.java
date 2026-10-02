
import java.util.Arrays;

public class FantasyTeamScoreMultiplier {

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        // Apply 2x multiplier directly to captain's index
        playerScores[captainIndex] *= 2.0;
        
        // Apply 1.5x multiplier directly to vice-captain's index
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores)); // [40.0, 110.0, 30.0, 93.0]
    }
}
