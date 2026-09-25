public class AtmPinValidator {

    public static void checkPinLength(String pin) {
        // Null check to prevent NullPointerException, followed by length validation
        if (pin == null || pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        // Test Cases
        checkPinLength("482");   // Invalid PIN — must be exactly 4 digits.
        checkPinLength("4820");  // PIN length OK.
        checkPinLength("12345"); // Invalid PIN — must be exactly 4 digits.
        checkPinLength(null);    // Invalid PIN — must be exactly 4 digits.
    }
}