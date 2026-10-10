package Assignment;
import java.util.Scanner;

interface SaverModeSupported {
    boolean supportsSaver();
}

abstract class Appliance {
    String name;
    double hours;
    boolean saverRequested;

    public Appliance(String name, double hours, boolean saverRequested) {
        this.name = name;
        this.hours = hours;
        this.saverRequested = saverRequested;
    }

    public abstract double getPowerWatts();

    public String getName() { return name; }
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean saverRequested) { super("FRIDGE", hours, saverRequested); }
    @Override public double getPowerWatts() { return 150.0; }
}

class AC extends Appliance implements SaverModeSupported {
    public AC(double hours, boolean saverRequested) { super("AC", hours, saverRequested); }
    @Override public double getPowerWatts() { return 1500.0; }
    @Override public boolean supportsSaver() { return true; }
}

class TV extends Appliance {
    public TV(double hours, boolean saverRequested) { super("TV", hours, saverRequested); }
    @Override public double getPowerWatts() { return 100.0; }
}

class Washer extends Appliance implements SaverModeSupported {
    public Washer(double hours, boolean saverRequested) { super("WASHER", hours, saverRequested); }
    @Override public double getPowerWatts() { return 500.0; }
    @Override public boolean supportsSaver() { return true; }
}

public class MainAppliance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        String[] names = new String[n];
        double[] hoursList = new double[n];
        boolean[] savers = new boolean[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            hoursList[i] = sc.nextDouble();
            if (sc.hasNext("(?i)SAVER")) {
                sc.next();
                savers[i] = true;
            } else {
                savers[i] = false;
            }
        }

        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String name = names[i];
            double hours = hoursList[i];
            boolean saver = savers[i];

            Appliance app = null;
            if (name.equalsIgnoreCase("FRIDGE")) {
                app = new Fridge(hours, saver);
            } else if (name.equalsIgnoreCase("AC")) {
                app = new AC(hours, saver);
            } else if (name.equalsIgnoreCase("TV")) {
                app = new TV(hours, saver);
            } else if (name.equalsIgnoreCase("WASHER")) {
                app = new Washer(hours, saver);
            }

            if (app != null) {
                if (saver && !(app instanceof SaverModeSupported)) {
                    System.out.println(app.getName() + ": saver mode not supported");
                    continue;
                }

                double units = (app.getPowerWatts() * app.hours) / 1000.0;
                if (saver) {
                    units *= 0.75;
                }
                double cost = units * 8.0;
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", app.getName(), units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
        sc.close();
    }
}