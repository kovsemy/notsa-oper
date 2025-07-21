import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lesson7JUnitTest {
    @Test
    void testFactorial() {
        assertEquals(Lesson7Functions.factorial(4), 24);
    }

    @Test
    void testCalculateTriangleArea() {
        assertEquals(Lesson7Functions.calculateTriangleArea(3, 3, 3, 1), 3.9);
    }

    @Test
    void testArithmeticOperations() {
        assertEquals(Lesson7Functions.arithmeticOperations(5.2, 10, '/'), 0.52);
    }

    @Test
    void testCompareTwoNumbers() {
        assertEquals(Lesson7Functions.compareTwoNumbers(2, 2), true);
    }
}
