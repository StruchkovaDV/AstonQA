import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculateArithmeticOperationsTest {

    private static MyCalculator calculator;

    @BeforeClass
    public static void createCalculator() {
        calculator = new MyCalculator();
    }

    @DataProvider
    public Object[][] createData() {
        return new Object[][]{
                {2, 3, '+', 5.0},
                {3, 2, '-', 1.0},
                {2, 3, '*', 6.0},
                {6, 3, '/', 2.0},
                {-2, 3, '+', 1.0},
                {-1, 2, '/', -0.5}
        };
    }

    @Test(dataProvider = "createData")
    public void shouldCalculateResultForValidOperation(int a, int b, char operation, double expected) {

        double result = calculator.calculateArithmeticOperations(a, b, operation);

        assertEquals(result, expected,1e-9,
                "Ожидаемое значение результата не совпадает с фактическим.");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void shouldThrowExceptionWhenDivisionByZero(){
        calculator.calculateArithmeticOperations(3, 0, '/');
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenWrongOperation(){
        calculator.calculateArithmeticOperations(2, 3, '$');
    }
}
