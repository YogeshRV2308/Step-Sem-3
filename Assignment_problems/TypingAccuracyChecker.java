public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int totalChars = original.length();
        int matchedCount = 0;
        int firstMismatchPosition = -1;
        char originalChar = ' ';
        char typedChar = ' ';

        // Traverse both strings character by character
        for (int i = 0; i < totalChars; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCount++;
            } else if (firstMismatchPosition == -1) {
                // Record the position (1-based index) and characters of the first mismatch
                firstMismatchPosition = i + 1;
                originalChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        // Calculate accuracy percentage
        double accuracy = ((double) matchedCount / totalChars) * 100;

        // Display results
        if (firstMismatchPosition == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n", 
                              matchedCount, totalChars, accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n", 
                              matchedCount, totalChars, accuracy, firstMismatchPosition, originalChar, typedChar);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Mismatch present
        checkTypingAccuracy("hello world", "hello worlt");

        // Test Case 2: Perfect match
        checkTypingAccuracy("coding", "coding");
    }
}