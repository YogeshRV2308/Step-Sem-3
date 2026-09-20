public class TrafficSignalAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal data available.");
            return;
        }

        char maxColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        // Traverse string starting from the second character
        for (int i = 1; i < signalLog.length(); i++) {
            char ch = signalLog.charAt(i);

            if (ch == currentColor) {
                currentStreak++;
            } else {
                currentColor = ch;
                currentStreak = 1;
            }

            // Update running maximum if the current streak exceeds the max
            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                maxColor = currentColor;
            }
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", maxColor, maxStreak);
    }

    public static void main(String[] args) {
        // Test Case 1
        findLongestStreak("RRGGGYRR");

        // Test Case 2
        findLongestStreak("RRRRYYGG");
    }
}