package lesson4.task2;

public class Rectangle implements Shape {
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
