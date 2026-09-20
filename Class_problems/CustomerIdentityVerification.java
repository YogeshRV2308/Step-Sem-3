public class CustomerIdentityVerification {

    /**
     * Reverses a customer's name using character array manipulation.
     * Time Complexity: O(n) | Auxiliary Space: O(n)
     * 
     * @param customerName The original name to reverse.
     * @return The reversed character sequence.
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] originalChars = customerName.toCharArray();
        char[] reversedChars = new char[originalChars.length];

        // Traverse the original array backwards and populate the new array
        for (int i = 0; i < originalChars.length; i++) {
            reversedChars[i] = originalChars[originalChars.length - 1 - i];
        }

        // Reconstruct string from character array
        return new String(reversedChars);
    }

    /**
     * Alternative Approach 1: In-Place Two-Pointer Swap on char array.
     */
    public static String reverseTwoPointer(String customerName) {
        if (customerName == null) return null;

        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    /**
     * Alternative Approach 2: Using standard StringBuilder.
     */
    public static String reverseStringBuilder(String customerName) {
        if (customerName == null) return null;
        return new StringBuilder(customerName).reverse().toString();
    }

    public static void main(String[] args) {
        // Test Case 1: Sample Input
        String originalName1 = "Sunil";
        String reversedName1 = reverseCustomerName(originalName1);

        System.out.println("Original Name: " + originalName1);
        System.out.println("Reversed Name: " + reversedName1);
        System.out.println();

        // Test Case 2: Multi-word Name
        String originalName2 = "Jane Doe";
        String reversedName2 = reverseCustomerName(originalName2);

        System.out.println("Original Name: " + originalName2);
        System.out.println("Reversed Name: " + reversedName2);
    }
}