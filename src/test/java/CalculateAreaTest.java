import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculateAreaTest {

    private static MyCalculator calculator;

    @BeforeClass
    public static void createCalculator() {
        calculator = new MyCalculator();
    }

    @DataProvider
    public Object[][] createValidData() {
        return new Object[][]{
                {3, 4, 5, 6.0},
                {4, 4, 5, 7.806247}
        };
    }

    @Test(dataProvider = "createValidData")
    public void shouldCalculateAreaForValidTriangles(int a, int b, int c, double expectedArea) {
        double area = calculator.calculateAreaTriangle(a, b, c);
        assertEquals(area, expectedArea, 1e-6,
                String.format("Неверная площадь для треугольника (%d, %d, %d)", a, b, c));
    }

    @DataProvider
    public Object[][] createDataWhenSideIsNotPositive() {
        return new Object[][]{
                {-2, 4, 5},
                {0, 4, 5},
                {4, -1, 5},
                {4, 5, 0}
        };
    }

    @Test(dataProvider = "createDataWhenSideIsNotPositive",
            expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSideIsNotPositive(int a, int b, int c) {
        calculator.calculateAreaTriangle(a, b, c);
    }

    @DataProvider
    public Object[][] createDataWhenTriangleDoesNotExist() {
        return new Object[][]{
                {1, 4, 5},
                {2, 2, 5},
                {10, 1, 1}
        };
    }

    @Test(dataProvider = "createDataWhenTriangleDoesNotExist",
            expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenTriangleDoesNotExist(int a, int b, int c) {
        calculator.calculateAreaTriangle(a, b, c);
    }
}
