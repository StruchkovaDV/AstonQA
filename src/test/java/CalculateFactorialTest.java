import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateFactorialTest {

    private static MyCalculator calculator;

    @BeforeAll
    public static void createCalculator(){
        calculator = new MyCalculator();
    }

    @Test
    void shouldThrowExceptionWhenNSmallerZero(){
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateFactorial(-3)
        );
        assertEquals("Ошибка: Факториал вычисляется только для положительных чисел.", ex.getMessage());
    }

    @ParameterizedTest(name = "{0}! = {1}")
    @CsvSource({
            "0, 1",
            "1, 1",
            "3, 6",
            "5, 120"
    })
    void shouldReturnCorrectFactorial(int n, long expected) {
        long actual = calculator.calculateFactorial(n);

        assertEquals(expected, actual, () -> n + "! должно быть равно " + expected);
    }

}
