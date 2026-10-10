package Assignment;
import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    String type;
    double weight;
    double declaredValue;

    public Parcel(String type, double weight, double declaredValue) {
        this.type = type;
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();

    public String getType() { return type; }
    public double getDeclaredValue() { return declaredValue; }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) {
        super("STANDARD", weight, declaredValue);
    }
    @Override public double calculateCharge() {
        return 40.0 + (10.0 * weight);
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) {
        super("EXPRESS", weight, declaredValue);
    }
    @Override public double calculateCharge() {
        return 80.0 + (15.0 * weight);
    }
    @Override public double calculateInsurance(double declaredValue) {
        return 0.02 * declaredValue;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) {
        super("FRAGILE", weight, declaredValue);
    }
    @Override public double calculateCharge() {
        return (40.0 + (10.0 * weight)) + 50.0;
    }
    @Override public double calculateInsurance(double declaredValue) {
        return 0.02 * declaredValue;
    }
}

public class MainParcel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Parcel[] parcels = new Parcel[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double val = sc.nextDouble();
            if (type.equalsIgnoreCase("STANDARD")) {
                parcels[i] = new StandardParcel(weight, val);
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                parcels[i] = new ExpressParcel(weight, val);
            } else if (type.equalsIgnoreCase("FRAGILE")) {
                parcels[i] = new FragileParcel(weight, val);
            }
        }

        double grandTotal = 0;
        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = 0.0;
            if (p instanceof Insurable) {
                insurance = ((Insurable) p).calculateInsurance(p.getDeclaredValue());
            }
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", p.getType(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        sc.close();
    }
}