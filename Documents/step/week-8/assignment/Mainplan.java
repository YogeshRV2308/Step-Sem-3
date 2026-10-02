import java.time.LocalDate;
import java.util.Scanner;

abstract class Plan {
    protected String subscriberName;
    protected LocalDate startDate;

    public Plan(String subscriberName, LocalDate startDate) {
        this.subscriberName = subscriberName;
        this.startDate = startDate;
    }

    public String getSubscriberName() { return subscriberName; }
    public abstract LocalDate getRenewalDate();
}

class BasicPlan extends Plan {
    public BasicPlan(String subscriberName, LocalDate startDate) { super(subscriberName, startDate); }
    @Override public LocalDate getRenewalDate() { return startDate.plusDays(30); }
}

class StandardPlan extends Plan {
    public StandardPlan(String subscriberName, LocalDate startDate) { super(subscriberName, startDate); }
    @Override public LocalDate getRenewalDate() { return startDate.plusDays(90); }
}

class PremiumPlan extends Plan {
    public PremiumPlan(String subscriberName, LocalDate startDate) { super(subscriberName, startDate); }
    @Override public LocalDate getRenewalDate() { return startDate.plusDays(365); }
}

public class Mainplan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        Plan[] subscribers = new Plan[n];

        for (int i = 0; i < n; i++) {
            String planType = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            switch (planType) {
                case "BASIC":
                    subscribers[i] = new BasicPlan(name, startDate);
                    break;
                case "STANDARD":
                    subscribers[i] = new StandardPlan(name, startDate);
                    break;
                case "PREMIUM":
                    subscribers[i] = new PremiumPlan(name, startDate);
                    break;
            }
        }

        for (Plan sub : subscribers) {
            System.out.println(sub.getSubscriberName() + ": " + sub.getRenewalDate());
        }

        sc.close();
    }
}