public class StudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        // Guard against null input
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        // Split by comma
        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        // Extract and trim fields to remove leading/trailing spaces
        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        // Print formatted record
        System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
    }

    public static void main(String[] args) {
        // Valid Input
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");

        // Invalid Input (Missing field)
        parseStudentRecord("Ananya Verma,RA2211003010123");

        // Invalid Input (Extra field)
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE,2024");
    }
}