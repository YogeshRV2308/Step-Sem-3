import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueLetterHunt {

    /**
     * Finds the first non-repeating character using an array lookup table (ASCII optimized).
     * Returns the character, or '\0' (null character) if none exists.
     * 
     * Time Complexity: O(n) | Auxiliary Space: O(1) [Fixed size array of 256]
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Frequency array for ASCII characters (0-255)
        int[] charCounts = new int[256];

        // Pass 1: Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            charCounts[text.charAt(i)]++;
        }

        // Pass 2: Find the first character with a frequency of 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (charCounts[ch] == 1) {
                return ch; // Early exit on first unique character
            }
        }

        return '\0'; // Return null char if no unique character exists
    }

    /**
     * Alternative Approach: LinkedHashMap (Preserves insertion order).
     * Useful when handling arbitrary Unicode or extended character sets.
     * 
     * Time Complexity: O(n) | Auxiliary Space: O(k) where k is unique characters
     */
    public static char findFirstNonRepeatingCharMap(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        Map<Character, Integer> counts = new LinkedHashMap<>();

        // Populate frequencies keeping insertion order intact
        for (char ch : text.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        // Scan the map in insertion order for the first entry with count == 1
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0';
    }

    /**
     * Helper runner method to print results formatted for the mini-game.
     */
    public static void runGame(String input) {
        char result = findFirstNonRepeatingChar(input);

        System.out.printf("Input: \"%s\"%n", input);
        if (result != '\0') {
            System.out.printf("First Non-Repeating Character: '%c'%n%n", result);
        } else {
            System.out.println("No Non-Repeating Character Found\n");
        }
    }

    public static void main(String[] args) {
        // Test Cases
        runGame("swiss");
        runGame("aabbcc");
        runGame("the quick brown fox");
        runGame("z");
    }
}