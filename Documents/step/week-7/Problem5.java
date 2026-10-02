public class Problem5 {
    private final String[] presentStudents;
    private int presentCount;

    public Problem5(int maxStudents) {
        this.presentStudents = new String[maxStudents];
        this.presentCount = 0;
    }

    public void markPresent(String studentName) {
        if (isPresent(studentName)) {
            return;
        }

        if (presentCount < presentStudents.length) {
            presentStudents[presentCount] = studentName;
            presentCount++;
        } else {
            System.out.println("Cannot mark present: Class capacity reached.");
        }
    }

    public boolean isPresent(String studentName) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(studentName)) {
                return true;
            }
        }
        return false;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public static void main(String[] args) {
        Problem5 sheet = new Problem5(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}