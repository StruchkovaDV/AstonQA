import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CompareTwoNumbersTest {

    private static MyCalculator calculator;

    @BeforeClass
    public static void createCalculator() {
        calculator = new MyCalculator();
    }

    @DataProvider
    public Object[][] createData() {
        return new Object[][]{
                {2, 3, '>', false},
                {3, 2, '>', true},
                {3, 3, '>', false},

                {1, 3, '<', true},
                {3, 1, '<', false},
                {3, 3, '<', false},

                {2, 3, '=', false},
                {3, 3, '=', true}
        };
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenWrongOperation() {
        calculator.compareTwoNumbers(2, 4, '$');
    }

    @Test(dataProvider = "createData")
    void shouldReturnCorrectResultForValidOperation(int a, int b, char operation, boolean expected){
        boolean result = calculator.compareTwoNumbers(a, b, operation);

        assertEquals(expected,result, "Ожидаемый результат сравнения не совпадает с фактическим.");
    }
}
