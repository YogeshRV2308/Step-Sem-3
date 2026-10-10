import java.util.Scanner;

abstract class Booking {
    double distance;
    String mode;
    static final double BOOKING_FEE = 50.0;

    public Booking(String mode, double distance) {
        this.mode = mode;
        this.distance = distance;
    }

    public abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }

    public String getMode() { return mode; }
}

class BusBooking extends Booking {
    public BusBooking(double distance) {
        super("BUS", distance);
    }
    @Override
    public double calculateBaseFare() {
        return distance * 2.0;
    }
}

class TrainBooking extends Booking {
    public TrainBooking(double distance) {
        super("TRAIN", distance);
    }
    @Override
    public double calculateBaseFare() {
        return distance * 1.5;
    }
}

class FlightBooking extends Booking {
    public FlightBooking(double distance) {
        super("FLIGHT", distance);
    }
    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distance * 4.0);
    }
}

public class MainBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Booking[] bookings = new Booking[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            if (mode.equalsIgnoreCase("BUS")) {
                bookings[i] = new BusBooking(distance);
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                bookings[i] = new TrainBooking(distance);
            } else if (mode.equalsIgnoreCase("FLIGHT")) {
                bookings[i] = new FlightBooking(distance);
            }
        }

        for (Booking b : bookings) {
            double fare = b.calculateTotalFare();
            System.out.printf("%s: %.2f\n", b.getMode(), fare);
        }
        sc.close();
    }
}