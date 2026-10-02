import java.util.Scanner;

abstract class Mainemployee {
    protected String name;
    protected double monthlySalary;

    public Mainemployee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() { return name; }
    public abstract double calculateBonus();
}

class FullTimeEmployee extends Mainemployee {
    public FullTimeEmployee(String name, double monthlySalary) { super(name, monthlySalary); }
    @Override public double calculateBonus() { return monthlySalary * 0.10; }
}

class PartTimeEmployee extends Mainemployee {
    public PartTimeEmployee(String name, double monthlySalary) { super(name, monthlySalary); }
    @Override public double calculateBonus() { return monthlySalary * 0.05; }
}

class InternEmployee extends Mainemployee {
    public InternEmployee(String name, double monthlySalary) { super(name, monthlySalary); }
    @Override public double calculateBonus() { return 2000.0; }
}

public class Mainemp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        Mainemployee[] employees = new Mainemployee[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            switch (type) {
                case "FULLTIME":
                    employees[i] = new FullTimeEmployee(name, salary);
                    break;
                case "PARTTIME":
                    employees[i] = new PartTimeEmployee(name, salary);
                    break;
                case "INTERN":
                    employees[i] = new InternEmployee(name, salary);
                    break;
            }
        }

        double grandTotal = 0;
        for (Mainemployee emp : employees) {
            double bonus = emp.calculateBonus();
            grandTotal += bonus;
            System.out.printf("%s: %.2f%n", emp.getName(), bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", grandTotal);

        sc.close();
    }
}