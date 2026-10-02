import java.util.Scanner;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
    public abstract String getType();
}

class BusTransport extends Transport {
    public BusTransport(double distance) { super(distance); }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(10.0, fare); // Capped at max $10
    }

    @Override
    public String getType() { return "BUS"; }
}

class TrainTransport extends Transport {
    public TrainTransport(double distance) { super(distance); }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }

    @Override
    public String getType() { return "TRAIN"; }
}

class MetroTransport extends Transport {
    private double peakHourFactor;

    public MetroTransport(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    public String getType() { return "METRO"; }
}

public class Maintransport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        Transport[] journeys = new Transport[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            if (type.equals("METRO")) {
                double peakHourFactor = sc.nextDouble();
                journeys[i] = new MetroTransport(distance, peakHourFactor);
            } else if (type.equals("BUS")) {
                journeys[i] = new BusTransport(distance);
            } else if (type.equals("TRAIN")) {
                journeys[i] = new TrainTransport(distance);
            }
        }

        double grandTotalFare = 0;
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            grandTotalFare += fare;
            System.out.printf("%s: %.2f%n", t.getType(), fare);
        }
        System.out.printf("Total: %.2f%n", grandTotalFare);

        sc.close();
    }
}