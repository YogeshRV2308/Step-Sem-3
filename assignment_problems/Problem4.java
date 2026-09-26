package assignment_problems;

public class Problem4 {
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed; // Edge case: avoid StringIndexOutOfBoundsException
        }

        // Uppercase first 3 characters, append the rest unchanged
        String pubCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);

        return pubCode + rest;
    }

    public static String validateAndFormat(String code) {
        // Check 1: Length must be exactly 13
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check 2: First 3 characters must be letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check 3: Remaining 10 characters must be digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Extract components using substring
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        // Build formatted display string
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(pubCode).append("] ")
                 .append("YEAR: ").append(year).append(" | ")
                 .append("CATALOG: ").append(catalog);

        return formatted.toString();
    }

    public static void main(String[] args) {
        String code1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(code1)); // [PEN] YEAR: 2026 | CATALOG: 004251

        String code2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(code2)); // Invalid: publisher code must be 3 letters
    }
}