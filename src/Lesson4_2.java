public class Lesson4_2 {
    public static void main(String[] args) {
        Circle c = new Circle("Красный", "Белый", 5);
        Rectangle r = new Rectangle("Синий", "Белый", 5, 5);
        Triangle t = new Triangle("Зеленый", "Белый", 5, 5, 5);

        c.displayInfo();
        r.displayInfo();
        t.displayInfo();
    }
}

/*
Странно делать реализацию через интерфейс
абстрактный класс тут бы повеселее смотрелся как мне кажется
 */
interface Shape {
    String getFillColor();
    String getBorderColor();

    double calculatePerimeter();
    double calculateArea();

    default void displayInfo() {
        System.out.printf("Периметр: %f // Площадь: %f // Цвет фона: %s // Цвет границы: %s%n",
                calculatePerimeter(),
                calculateArea(),
                getFillColor(),
                getBorderColor()
        );
    }
}

class Circle implements Shape {
    private String fillColor;
    private String borderColor;
    private double radius;

    public Circle(String fillColor, String borderColor, double radius) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Rectangle implements Shape {
    private String fillColor;
    private String borderColor;
    private double length;
    private double width;

    public Rectangle(String fillColor, String borderColor, double length, double width) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Triangle implements Shape {
    private String fillColor;
    private String borderColor;
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(String fillColor, String borderColor, double sideA, double sideB, double sideC) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}