public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        // Handle null or filenames without an extension
        if (filename == null) {
            return "Rejected — invalid file type";
        }

        int lastDotIndex = filename.lastIndexOf('.');

        // Check if '.' exists and is not the first or last character
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        // Extract extension from the last '.' to the end of the string
        String extension = filename.substring(lastDotIndex + 1);

        // Compare case-insensitively against accepted extensions
        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(validateFileExtension("Assignment1.PDF")); // Accepted
        System.out.println(validateFileExtension("notes.txt"));       // Rejected — invalid file type
        System.out.println(validateFileExtension("project.final.zip")); // Accepted
        System.out.println(validateFileExtension("noextension"));     // Rejected — invalid file type
    }
}