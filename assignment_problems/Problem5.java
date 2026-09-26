package assignment_problems;
import java.util.*;

public class Problem5 {
    public static void printFilteredWordFrequency(String feedback) {
        Set<String> stopWords = new HashSet<>(Arrays.asList(
            "the", "was", "and", "a", "is", "of", "in"
        ));

        // Normalize text: convert to lowercase and strip punctuation
        String cleaned = feedback.toLowerCase()
                                .replace(".", "")
                                .replace(",", "")
                                .replace("!", "")
                                .replace("?", "");

        // Split into words by whitespace
        String[] words = cleaned.split("\\s+");

        Map<String, Integer> frequencyMap = new HashMap<>();

        // Count non-stop-word frequencies
        for (String word : words) {
            if (word.isEmpty() || stopWords.contains(word)) {
                continue;
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Convert map entries to list and sort descending by frequency
        List<Map.Entry<String, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Print frequency report
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(feedback);
        /*
           Output:
           great: 2
           mentor: 1
           session: 1
           clear: 1
        */
    }
}