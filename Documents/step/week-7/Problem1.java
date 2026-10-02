class PiggyBank {
    private final String id; // Locked in place forever once created
    private double savings;  // Private: cannot be set directly from outside

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0; // Starts at 0 savings
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: Amount must be greater than 0");
            return;
        }
        this.savings += amount;
        System.out.println("Deposited " + amount + " -> savings = " + this.savings);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: Amount must be greater than 0");
            return;
        }
        if (amount > this.savings) {
            System.out.println("Withdrawal rejected: Insufficient funds, savings stays " + this.savings);
            return;
        }
        this.savings -= amount;
        System.out.println("Withdrew " + amount + " -> savings = " + this.savings);
    }

    // Read-only getter for savings
    public double getSavings() {
        return this.savings;
    }

    // Read-only getter for final ID
    public String getId() {
        return this.id;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500); // Rejected, savings stays 70
    }
}