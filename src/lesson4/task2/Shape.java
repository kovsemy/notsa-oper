package lesson4.task2;

public interface Shape {
    String getFillColor();
    String getBorderColor();

    double calculatePerimeter();
    double calculateArea();

    default void displayInfo() {
        System.out.printf("Периметр: %.1f // Площадь: %.1f // Цвет фона: %s // Цвет границы: %s%n",
                calculatePerimeter(),
                calculateArea(),
                getFillColor(),
                getBorderColor()
        );
    }
}
