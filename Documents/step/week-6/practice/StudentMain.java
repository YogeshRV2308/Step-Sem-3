class Student {
    String name;
    double attendance;

    // Static fields shared across all instances
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++; // Increment count on every instantiation
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Total Students Enrolled: " + studentCount);
    }
}

public class StudentMain {
    public static void main(String[] args) {
        Student s1 = new Student("Ravi", 85.5);
        Student s2 = new Student("Anitha", 92.0);

        // Called directly through the class name
        Student.printCollegeInfo();
    }
}