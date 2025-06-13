// Base class: Shape
class Shape {
    // Method to be overridden
    public void draw() {
        System.out.println("Drawing a shape.");
    }

    // Method to calculate area (default)
    public double area() {
        return 0;
    }
}

// Derived class: Circle (inherits Shape)
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Overriding draw() method
    @Override
    public void draw() {
        System.out.println("Drawing a circle.");
    }

    // Overriding area() method
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Derived class: Rectangle (inherits Shape)
class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Overriding draw() method
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle.");
    }

    // Overriding area() method
    @Override
    public double area() {
        return length * width;
    }
}

// Main class to demonstrate polymorphism
public class ShapeDemo {
    public static void main(String[] args) {
        // Shape reference but Circle object
        Shape shape1 = new Circle(5.0);
        shape1.draw();
        System.out.println("Area: " + shape1.area());

        // Shape reference but Rectangle object
        Shape shape2 = new Rectangle(4.0, 6.0);
        shape2.draw();
        System.out.println("Area: " + shape2.area());
    }
}
