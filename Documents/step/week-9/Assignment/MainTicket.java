package Assignment;
import java.util.Scanner;

abstract class TicketBooking {
    String seatType;
    int count;
    static final double CONVENIENCE_FEE_PER_TICKET = 20.0;

    public TicketBooking(String seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public abstract double getBasePricePerTicket();

    public double calculateTotal() {
        double base = getBasePricePerTicket() * count;
        double fee = CONVENIENCE_FEE_PER_TICKET * count;
        return base + fee;
    }

    public String getSeatType() { return seatType; }
}

class RegularTicket extends TicketBooking {
    public RegularTicket(int count) { super("REGULAR", count); }
    @Override public double getBasePricePerTicket() { return 150.0; }
}

class PremiumTicket extends TicketBooking {
    public PremiumTicket(int count) { super("PREMIUM", count); }
    @Override public double getBasePricePerTicket() { return 250.0; }
}

class ReclinerTicket extends TicketBooking {
    public ReclinerTicket(int count) { super("RECLINER", count); }
    @Override public double getBasePricePerTicket() { return 400.0; }
}

public class MainTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        TicketBooking[] bookings = new TicketBooking[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            if (type.equalsIgnoreCase("REGULAR")) {
                bookings[i] = new RegularTicket(count);
            } else if (type.equalsIgnoreCase("PREMIUM")) {
                bookings[i] = new PremiumTicket(count);
            } else if (type.equalsIgnoreCase("RECLINER")) {
                bookings[i] = new ReclinerTicket(count);
            }
        }

        double total = 0;
        for (TicketBooking b : bookings) {
            double amt = b.calculateTotal();
            total += amt;
            System.out.printf("%s: %.2f\n", b.getSeatType(), amt);
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}