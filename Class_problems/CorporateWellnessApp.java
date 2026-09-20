import java.util.Random;

public class CorporateWellnessApp {

    /**
     * Classifies health status based on standard BMI thresholds.
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Calculates BMI and prints a formatted wellness report for the team.
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Error: Mismatched or invalid employee health data.");
            return;
        }

        int teamSize = heights.length;

        // Header Formatting
        System.out.println("===============================================================");
        System.out.println("                   CORPORATE WELLNESS REPORT                   ");
        System.out.println("===============================================================");
        System.out.printf("%-10s | %-10s | %-11s | %-8s | %-12s%n", 
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------");

        // Process and display each team member
        for (int i = 0; i < teamSize; i++) {
            double height = heights[i];
            double weight = weights[i];
            
            // Formula: BMI = weight / (height * height)
            double bmi = weight / (height * height);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-10.2f | %-11.1f | %-8.2f | %-12s%n", 
                    (i + 1), height, weight, bmi, status);
        }

        System.out.println("===============================================================");
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        Random rand = new Random();

        // Populate arrays with realistic random test data
        // Height: 1.50m to 1.90m | Weight: 45.0kg to 105.0kg
        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + (0.40 * rand.nextDouble());
            weights[i] = 45.0 + (60.0 * rand.nextDouble());
        }

        // Generate Report
        printWellnessReport(heights, weights);
    }
}