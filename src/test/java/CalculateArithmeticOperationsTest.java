import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateArithmeticOperationsTest {

    private static MyCalculator calculator;

    @BeforeAll
    public static void createCalculator(){
        calculator = new MyCalculator();
    }

    @ParameterizedTest(name = "ArithmeticOperation({0}, {1}, {2}) = {3}")
    @CsvSource({
            "2, 3, +, 5.0",
            "3, 2, -, 1.0",
            "2, 3, *, 6.0",
            "6, 3, /, 2.0",
            "-2, 3, +, 1.0",
            "-1, 2, /, -0.5"
    })
    void shouldCalculateResultForValidOperation(int a, int b, char operation, double expected) {
        double result = calculator.calculateArithmeticOperations(a, b, operation);

        assertEquals(expected, result, 1e-9,
                "Ожидаемое значение результата не совпадает с фактическим.");
    }

    @Test
    void shouldThrowExceptionWhenDivisionByZero(){
        ArithmeticException ex = assertThrows(
                ArithmeticException.class,
                () -> calculator.calculateArithmeticOperations(3, 0, '/')
        );

        assertEquals("Деление на ноль запрещено.", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenWrongOperation(){
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateArithmeticOperations(2, 3, '$')
        );

        assertEquals("Ошибка: такой операции не существует.", ex.getMessage());
    }
}
