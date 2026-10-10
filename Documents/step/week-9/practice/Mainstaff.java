import java.util.Scanner;

abstract class Staff {
    String name;

    public Staff(String name) {
        this.name = name;
    }

    public abstract double calculatePay();

    public String getName() { return name; }
}

class FullTimeStaff extends Staff {
    double salary;
    public FullTimeStaff(String name, double salary) {
        super(name);
        this.salary = salary;
    }
    @Override
    public double calculatePay() {
        return salary;
    }
}

class HourlyStaff extends Staff {
    double hours, rate;
    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }
}

class Intern extends Staff {
    double stipend;
    public Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }
    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class Mainstaff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Staff[] staffList = new Staff[n];
        double totalPayroll = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            if (type.equalsIgnoreCase("FULLTIME")) {
                staffList[i] = new FullTimeStaff(name, sc.nextDouble());
            } else if (type.equalsIgnoreCase("HOURLY")) {
                staffList[i] = new HourlyStaff(name, sc.nextDouble(), sc.nextDouble());
            } else if (type.equalsIgnoreCase("INTERN")) {
                staffList[i] = new Intern(name, sc.nextDouble());
            }
        }

        for (Staff s : staffList) {
            double pay = s.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f\n", s.getName(), pay);
        }
        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
        sc.close();
    }
}