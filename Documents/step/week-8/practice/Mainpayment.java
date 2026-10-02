import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getType();
}

class CardPayment extends Payment {
    public CardPayment(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.02; // 2% fee
    }

    @Override
    public String getType() { return "CARD"; }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.01; // 1% fee
    }

    @Override
    public String getType() { return "WALLET"; }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return amount; // No fee
    }

    @Override
    public String getType() { return "BANKTRANSFER"; }
}

public class Mainpayment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        Payment[] payments = new Payment[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            switch (type) {
                case "CARD":
                    payments[i] = new CardPayment(amount);
                    break;
                case "WALLET":
                    payments[i] = new WalletPayment(amount);
                    break;
                case "BANKTRANSFER":
                    payments[i] = new BankTransferPayment(amount);
                    break;
            }
        }

        double grandTotal = 0;
        for (Payment p : payments) {
            double finalAmount = p.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f%n", p.getType(), finalAmount);
        }
        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }
}