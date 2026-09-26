public class TransactionReferenceValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) {
            return null;
        }

        // Trim leading and trailing spaces
        String trimmed = raw.trim();

        // If the trimmed string has fewer than 3 characters, upper-case what exists
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        // Upper-case only the first 3 characters and concatenate the rest unchanged
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference == null) {
            return "Invalid: null reference string";
        }

        // 1. Length Validation
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // 2. Bank Code Validation (First 3 characters must be letters)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // 3. Body Validation (Remaining 11 characters must be digits)
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // 4. Extract parts for formatting
        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        // 5. Build formatted output line using StringBuilder
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] ");
        formatted.append("DATE: ").append(day).append("/").append(month).append("/").append(year);
        formatted.append(" | SEQ: ").append(seq);

        return formatted.toString();
    }

    public static void main(String[] args) {
        // Driver code to demonstrate functionality
        String[] sampleInputs = {
            " hdf03022600042 ",  // Valid (Needs normalization)
            "12F03022600042",    // Invalid: Bank code has numbers
            "hdf0302260004",     // Invalid: Wrong length (13 chars)
            "HDF0302260004A"     // Invalid: Non-digit body
        };

        for (String input : sampleInputs) {
            String normalized = normalizeReference(input);
            String result = validateAndFormat(normalized);
            System.out.println("Input:  \"" + input + "\"");
            System.out.println("Output: " + result);
            System.out.println("----------------------------------------");
        }
    }
}