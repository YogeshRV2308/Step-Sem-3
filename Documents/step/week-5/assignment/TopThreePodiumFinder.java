package assignment;
import java.util.Arrays;

public class TopThreePodiumFinder {

    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        // Single pass linear scan without sorting
        for (int score : scores) {
            if (score >= first) {
                // Shift down: new highest score shifts 1st to 2nd, and 2nd to 3rd
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                // Shift down: score fits between 1st and 2nd
                third = second;
                second = score;
            } else if (score > third) {
                // Score fits into 3rd spot
                third = score;
            }
        }

        return new int[] { first, second, third };
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        int[] podium = findTopThreeScores(scores);
        System.out.println(Arrays.toString(podium)); // [90, 90, 82]
    }
}