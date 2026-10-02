package assignment;
class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double openingBasicSalary) {
        if (openingBasicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Starting at 0.0");
            this.basicSalary = 0.0;
        } else {
            this.basicSalary = openingBasicSalary;
        }
        this.bonus = 0.0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus credit rejected: amount must be greater than 0");
            return;
        }
        this.bonus += amount;
        System.out.println("Bonus credited: Rs " + this.bonus);
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax deduction rejected: invalid percentage");
            return;
        }
        this.basicSalary -= (this.basicSalary * percent / 100.0);
        System.out.println("Tax deducted: " + percent + "%");
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }
}