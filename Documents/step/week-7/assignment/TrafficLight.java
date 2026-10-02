package assignment;
public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; // Starts on RED
    }

    public String next() {
        switch (this.color) {
            case "RED":
                this.color = "GREEN";
                break;
            case "GREEN":
                this.color = "YELLOW";
                break;
            case "YELLOW":
                this.color = "RED";
                break;
        }
        System.out.println("t.next() -> \"" + this.color + "\"");
        return this.color;
    }

    public String getColor() {
        return this.color;
    }

    public String getId() {
        return this.id;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");

        System.out.println("t.getColor() -> \"" + t.getColor() + "\"");
        t.next(); // GREEN
        t.next(); // YELLOW
        t.next(); // RED
    }
}