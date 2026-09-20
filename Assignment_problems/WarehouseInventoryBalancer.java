public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;

        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "";
        int highestItemNumber = -1;

        // Traverse both arrays simultaneously
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];

            // Check Section A for new maximum
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItemNumber = i + 1; // 1-based index for display
            }

            // Check Section B for new maximum
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItemNumber = i + 1; // 1-based index for display
            }
        }

        // Determine balance status
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        // Print formatted summary
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, highestQuantity, highestSection, highestItemNumber);
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}