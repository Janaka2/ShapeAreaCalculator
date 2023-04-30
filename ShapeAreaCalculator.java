public abstract class Shape {
}

public record Circle(double radius) extends Shape {
}

public record Rectangle(double width, double height) extends Shape {
}

public record Triangle(double base, double height) extends Shape {
}

public class ShapeAreaCalculator {

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 4);

        System.out.println("Area of circle: " + calculateArea(circle));
        System.out.println("Area of rectangle: " + calculateArea(rectangle));
        System.out.println("Area of triangle: " + calculateArea(triangle));
    }

    public static double calculateArea(Shape shape) {
        return switch (shape) {
            case Circle c -> Math.PI * c.radius() * c.radius();
            case Rectangle r -> r.width() * r.height();
            case Triangle t -> t.base() * t.height() / 2;
            default -> throw new IllegalArgumentException("Unsupported shape: " + shape);
        };
    }
}
