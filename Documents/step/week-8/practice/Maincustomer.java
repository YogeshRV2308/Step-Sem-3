import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getCustomerType();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) { super(amount); }
    @Override public double calculateFinalAmount() { return amount * 0.90; }
    @Override public String getCustomerType() { return "STUDENT"; }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) { super(amount); }
    @Override public double calculateFinalAmount() { return amount * 0.95; }
    @Override public String getCustomerType() { return "STAFF"; }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) { super(amount); }
    @Override public double calculateFinalAmount() { return amount + 10.0; }
    @Override public String getCustomerType() { return "GUEST"; }
}

public class Maincustomer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        Customer[] bills = new Customer[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            switch (type) {
                case "STUDENT":
                    bills[i] = new StudentCustomer(amount);
                    break;
                case "STAFF":
                    bills[i] = new StaffCustomer(amount);
                    break;
                case "GUEST":
                    bills[i] = new GuestCustomer(amount);
                    break;
            }
        }

        double grandTotal = 0;
        for (Customer customer : bills) {
            double finalAmount = customer.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f%n", customer.getCustomerType(), finalAmount);
        }
        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }
}