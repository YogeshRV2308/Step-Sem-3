package Assignment;
import java.util.Scanner;

interface NightServiceable {
    boolean supportsNightService();
}

abstract class Cab {
    String cabType;
    double km;
    String time;

    public Cab(String cabType, double km, String time) {
        this.cabType = cabType;
        this.km = km;
        this.time = time;
    }

    public abstract double getRatePerKm();

    public double calculateFare() {
        double base = km * getRatePerKm();
        double fare = Math.max(base, 100.0);
        if (time.equalsIgnoreCase("NIGHT")) {
            fare *= 1.20;
        }
        return fare;
    }

    public String getCabType() { return cabType; }
    public String getTime() { return time; }
}

class MiniCab extends Cab {
    public MiniCab(double km, String time) { super("MINI", km, time); }
    @Override public double getRatePerKm() { return 10.0; }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double km, String time) { super("SEDAN", km, time); }
    @Override public double getRatePerKm() { return 14.0; }
    @Override public boolean supportsNightService() { return true; }
}

class SuvCab extends Cab implements NightServiceable {
    public SuvCab(double km, String time) { super("SUV", km, time); }
    @Override public double getRatePerKm() { return 18.0; }
    @Override public boolean supportsNightService() { return true; }
}

public class MainCab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        String[] cabTypes = new String[n];
        double[] kms = new double[n];
        String[] times = new String[n];

        for (int i = 0; i < n; i++) {
            cabTypes[i] = sc.next();
            kms[i] = sc.nextDouble();
            times[i] = sc.next();
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = cabTypes[i];
            double km = kms[i];
            String time = times[i];

            if (type.equalsIgnoreCase("MINI") && time.equalsIgnoreCase("NIGHT")) {
                System.out.println("MINI: night service not available");
                continue;
            }

            Cab cab = null;
            if (type.equalsIgnoreCase("MINI")) {
                cab = new MiniCab(km, time);
            } else if (type.equalsIgnoreCase("SEDAN")) {
                cab = new SedanCab(km, time);
            } else if (type.equalsIgnoreCase("SUV")) {
                cab = new SuvCab(km, time);
            }

            if (cab != null) {
                double fare = cab.calculateFare();
                total += fare;
                System.out.printf("%s: %.2f\n", cab.getCabType(), fare);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}