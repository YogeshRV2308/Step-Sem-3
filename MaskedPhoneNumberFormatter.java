public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        // Validation: Null check, exact length of 10 digits, and all numeric check
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            return "Invalid phone number";
        }

        // Extract the last 4 digits
        String lastFour = phone.substring(6);

        // Build the masked string using StringBuilder
        StringBuilder maskedPhone = new StringBuilder();
        maskedPhone.append("XXXXXX");
        maskedPhone.append("-");
        maskedPhone.append(lastFour);

        return maskedPhone.toString();
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(maskPhoneNumber("9876543210")); // XXXXXX-3210
        System.out.println(maskPhoneNumber("98765"));      // Invalid phone number
        System.out.println(maskPhoneNumber("987654321a")); // Invalid phone number
        System.out.println(maskPhoneNumber(null));         // Invalid phone number
    }
}