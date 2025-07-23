package lesson4.task2;

public class Circle implements Shape {
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
