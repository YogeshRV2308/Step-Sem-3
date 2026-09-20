public class SeatDuplicationChecker {

    /**
     * Scans the array of seat numbers using nested loops to identify duplicates.
     * Time Complexity: O(n^2) | Auxiliary Space: O(1)
     * 
     * @param seatNumbers Array of seat numbers assigned to students.
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length <= 1) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean foundDuplicate = false;

        // Outer loop selects each seat number
        for (int i = 0; i < seatNumbers.length; i++) {
            
            // Check if this seat number was already flagged in an earlier iteration
            boolean alreadyReported = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[i] == seatNumbers[k]) {
                    alreadyReported = true;
                    break;
                }
            }

            // If already processed as a duplicate, skip to prevent double-printing
            if (alreadyReported) {
                continue;
            }

            // Inner loop compares seatNumbers[i] against all subsequent elements
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                    break; // Stop checking inner loop once duplicate is confirmed for seat i
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Array with a duplicate seat
        int[] hallA = {101, 102, 103, 102, 105};
        System.out.print("Input Hall A: ");
        printArray(hallA);
        checkDuplicateSeats(hallA);

        System.out.println();

        // Test Case 2: Array with no duplicate seats
        int[] hallB = {101, 102, 103, 104, 105};
        System.out.print("Input Hall B: ");
        printArray(hallB);
        checkDuplicateSeats(hallB);

        System.out.println();

        // Test Case 3: Multiple duplicate seats
        int[] hallC = {201, 202, 201, 203, 202, 204};
        System.out.print("Input Hall C: ");
        printArray(hallC);
        checkDuplicateSeats(hallC);
    }

    // Helper method to format array output
    private static void printArray(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("}");
    }
}