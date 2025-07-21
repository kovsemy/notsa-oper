import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lesson7TestNGTest {

    @BeforeTest
    void beforeTest() {
        System.out.println("привет подписочники(:");
    }

    @Test
    void testFactorial() {
        int expectedResult = 24;
        int actualResult = Lesson7TestNGFunctions.factorial(4);
        Assert.assertEquals(actualResult, expectedResult, "Неверный результат факториала");
    }

    @Test
    void testCalculateTriangleArea() {
        Assert.assertEquals(Lesson7TestNGFunctions.calculateTriangleArea(3, 3, 3, 1), 3.9);
    }

    @Test
    void testArithmeticOperations() {
        Assert.assertEquals(Lesson7TestNGFunctions.arithmeticOperations(5.2, 10, '/'), 0.52);
    }

    @Test
    void testCompareTwoNumbers() {
        Assert.assertEquals(Lesson7TestNGFunctions.compareTwoNumbers(2, 2), true);
    }

    @AfterTest
    void afterTest() {
        System.out.println("пока подписочники:)");
    }
}
