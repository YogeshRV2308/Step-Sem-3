import java.util.Scanner;

abstract class Plot {
    String owner;
    String shape;

    public Plot(String owner, String shape) {
        this.owner = owner;
        this.shape = shape;
    }

    public abstract double getArea();

    public String getOwner() { return owner; }
    public String getShape() { return shape; }
}

class Circle extends Plot {
    double radius;
    public Circle(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Plot {
    double length, width;
    public Rectangle(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }
    @Override
    public double getArea() {
        return length * width;
    }
}

class Triangle extends Plot {
    double base, height;
    public Triangle(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Plot[] plots = new Plot[n];
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();
            if (type.equalsIgnoreCase("CIRCLE")) {
                plots[i] = new Circle(owner, sc.nextDouble());
            } else if (type.equalsIgnoreCase("RECTANGLE")) {
                plots[i] = new Rectangle(owner, sc.nextDouble(), sc.nextDouble());
            } else if (type.equalsIgnoreCase("TRIANGLE")) {
                plots[i] = new Triangle(owner, sc.nextDouble(), sc.nextDouble());
            }
        }

        for (Plot p : plots) {
            double area = p.getArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f\n", p.getOwner(), p.getShape(), area);
        }
        System.out.printf("Total Area: %.2f\n", totalArea);
        sc.close();
    }
}