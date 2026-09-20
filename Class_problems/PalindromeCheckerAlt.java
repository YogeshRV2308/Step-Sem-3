import java.util.stream.IntStream;

public class PalindromeCheckerAlt {

    /**
     * 1. Iterative Approach: Two-pointer technique with while loop.
     * Time Complexity: O(n) | Space Complexity: O(1)
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left++) != text.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 2. Recursive Approach: Tail-recursive using index bounds (No Substring allocations).
     * Time Complexity: O(n) | Space Complexity: O(n) call stack
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        return recursiveHelper(text, 0, text.length() - 1);
    }

    private static boolean recursiveHelper(String text, int left, int right) {
        if (left >= right) return true; // Base case: middle reached
        if (text.charAt(left) != text.charAt(right)) return false;
        return recursiveHelper(text, left + 1, right - 1);
    }

    /**
     * 3. Array / String Reversal Approach: Using StringBuilder.reverse().
     * Time Complexity: O(n) | Space Complexity: O(n)
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;

        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }

    /**
     * Bonus: Functional / Stream Approach (1-Liner)
     * Time Complexity: O(n) | Space Complexity: O(1)
     */
    public static boolean isPalindromeStream(String text) {
        if (text == null) return false;
        int len = text.length();
        return IntStream.range(0, len / 2)
                .allMatch(i -> text.charAt(i) == text.charAt(len - 1 - i));
    }

    /**
     * Helper runner for printing and validation.
     */
    public static void test(String input) {
        boolean iter = isPalindromeIterative(input);
        boolean recur = isPalindromeRecursive(input);
        boolean rev = isPalindromeArrayReversal(input);

        String format = "%s: %s | %s: %s | %s: %s%n%n";
        String status = (iter && recur && rev) ? "Palindrome" : "Not Palindrome";

        System.out.printf("Input: \"%s\"%n", input);
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n%n", 
                status, status, status);
    }

    public static void main(String[] args) {
        test("madam");
        test("hello");
        test("step on no pets");
    }
}