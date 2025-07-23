package lesson4.task2;

public class Triangle implements Shape {
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
