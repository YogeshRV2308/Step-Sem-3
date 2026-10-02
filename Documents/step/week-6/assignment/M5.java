package assignment;

class CompanyEmployee {
    String empName;
    double salary;

    // Static fields shared across all instances
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // Increments count upon object creation
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class M5 {
    public static void main(String[] args) {
        new CompanyEmployee("Divya", 65000);
        new CompanyEmployee("Arjun", 25000);
        new CompanyEmployee("Priya", 50000);

        // Called directly through class name
        CompanyEmployee.printCompanyInfo();
    }
}