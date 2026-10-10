package Assignment;
import java.util.Scanner;

interface Transportable {
    boolean usesBus();
}

abstract class Student {
    String name;
    String typeName;
    static final double TRANSPORT_FEE = 12000.0;

    public Student(String typeName, String name) {
        this.typeName = typeName;
        this.name = name;
    }

    public abstract double calculateTuition();

    public String getName() { return name; }
}

class DayScholar extends Student implements Transportable {
    public DayScholar(String name) { super("DAY_SCHOLAR", name); }
    @Override public double calculateTuition() { return 40000.0; }
    @Override public boolean usesBus() { return true; }
}

class Hosteller extends Student implements Transportable {
    public Hosteller(String name) { super("HOSTELLER", name); }
    @Override public double calculateTuition() { return 40000.0 + 60000.0; }
    @Override public boolean usesBus() { return false; }
}

class Scholar extends Student implements Transportable {
    public Scholar(String name) { super("SCHOLAR", name); }
    @Override public double calculateTuition() { return 20000.0; }
    @Override public boolean usesBus() { return true; }
}

public class MainStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            if (type.equalsIgnoreCase("DAY_SCHOLAR")) {
                students[i] = new DayScholar(name);
            } else if (type.equalsIgnoreCase("HOSTELLER")) {
                students[i] = new Hosteller(name);
            } else if (type.equalsIgnoreCase("SCHOLAR")) {
                students[i] = new Scholar(name);
            }
        }

        double totalCollected = 0;
        for (Student s : students) {
            double fee = s.calculateTuition();
            if (s instanceof Transportable && ((Transportable) s).usesBus()) {
                fee += Student.TRANSPORT_FEE;
            }
            totalCollected += fee;
            System.out.printf("%s: %.2f\n", s.getName(), fee);
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
        sc.close();
    }
}
