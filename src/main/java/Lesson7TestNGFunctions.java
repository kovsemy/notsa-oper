import java.math.BigDecimal;
import java.math.RoundingMode;

public class Lesson7TestNGFunctions {

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static double calculateTriangleArea(double sideA, double sideB, double sideC, int scale) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0 ||
                sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException("Неверные стороны треугольника");
        }

        double p = (sideA + sideB + sideC) / 2;
        double area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        return new BigDecimal(area).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

    public static double arithmeticOperations(double a, double b, char operation) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '/':
                if (b == 0) {
                    throw new IllegalArgumentException("Деление на 0 невозможно");
                }
                return a / b;
            case '*':
                return a * b;
            default:
                throw new IllegalArgumentException("Поддерживаемые операции: +, -, /, *");
        }
    }

    public static boolean compareTwoNumbers(int a, int b) {
        return a == b;
    }
}
