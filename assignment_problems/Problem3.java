package assignment_problems;
public class Problem3 {
    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0];
        String sku = fields[1];
        String quantity = fields[2];

        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150"); // Product: Wireless Mouse | SKU: WM-2201 | Qty: 150
        parseInventoryRecord("Wireless Mouse,150");         // Invalid Record
    }
}