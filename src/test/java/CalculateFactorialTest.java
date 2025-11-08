import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculateFactorialTest {
    private static MyCalculator calculator;

    @BeforeClass
    public static void createCalculator() {
        calculator = new MyCalculator();
    }

    @DataProvider(name = "createData")
    public Object[][] createData() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {3, 6},
                {5, 120}
        };
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNSmallerZero() {
        calculator.calculateFactorial(-3);
    }

    @Test(dataProvider = "createData")
    public void shouldReturnCorrectFactorial(int n, long expected) {
        long actual = calculator.calculateFactorial(n);
        assertEquals(actual, expected,n + "! должно быть равно " + expected);
    }
}

