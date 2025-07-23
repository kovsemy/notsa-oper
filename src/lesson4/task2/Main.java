package lesson4.task2;

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle("Красный", "Белый", 5);
        Rectangle r = new Rectangle("Синий", "Белый", 5, 5);
        Triangle t = new Triangle("Зеленый", "Белый", 5, 5, 5);

        c.displayInfo();
        r.displayInfo();
        t.displayInfo();
    }
}
