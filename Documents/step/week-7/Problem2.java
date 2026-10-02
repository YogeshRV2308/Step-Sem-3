class Scorecard {
    private final boolean[] results; // Private array to store answer results
    private final int totalQuestions;
    private int recordedCount;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (recordedCount >= totalQuestions) {
            System.out.println("Answer rejected: Maximum question limit reached.");
            return;
        }
        results[recordedCount] = isCorrect;
        recordedCount++;
    }

    // Exposes only the calculated total score—never the private array
    public int getScore() {
        int count = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) {
                count++;
            }
        }
        return count;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("sc.getScore() -> " + sc.getScore());
    }
}