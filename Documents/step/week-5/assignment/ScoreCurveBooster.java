package assignment;
import java.util.Arrays;

public class ScoreCurveBooster {

    static void curveScores(int[] scores, int bonus) {
        // Direct index modification updates the caller's array in place
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        System.out.println(Arrays.toString(scores)); // [80, 95, 70]
    }
}