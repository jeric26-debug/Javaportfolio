// Define the Shape interface
interface Shape {
    double calculateArea();
    double calculatePerimeter();
}

// Abstract class implementing the Shape interface
abstract class AbstractShape implements Shape {
    String color;
    double length;
    double width;

    // Constructor to initialize common attributes
    public AbstractShape(String color, double length, double width) {
        this.color = color;
        this.length = length;
        this.width = width;
    }
}

// Circle class extending AbstractShape
class Circle extends AbstractShape {
    double radius;

    // Constructor for Circle
    public Circle(String color, double radius) {
        super(color, 0, 0); // Length and width are not needed for Circle
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle class extending AbstractShape
class Rectangle extends AbstractShape {

    // Constructor for Rectangle
    public Rectangle(String color, double length, double width) {
        super(color, length, width);
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Main class to test the shapes
public class Main {
    public static void main(String[] args) {
        // Create a Circle instance
        Circle circle = new Circle("Black", 7.0);
        System.out.println("Circle:");
        System.out.println("Color: " + circle.color);
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Perimeter: " + circle.calculatePerimeter());

        // Create a Rectangle instance
        Rectangle rectangle = new Rectangle("White", 4.0, 7.0);
        System.out.println("\nRectangle:");
        System.out.println("Color: " + rectangle.color);
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
    }
}
