public class Problem3 {
    private final String firstName;
    private final String lastNameInitial;

    public Problem3(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastNameInitial = parts[1].substring(0, 1) + ".";
    }

    public String getNickname() {
        return firstName + " " + lastNameInitial;
    }

    public static void main(String[] args) {
        Problem3 tag = new Problem3("Maria Gomez");

        System.out.println("tag.getNickname() -> \"" + tag.getNickname() + "\"");
    }
}