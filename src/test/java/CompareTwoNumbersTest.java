import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CompareTwoNumbersTest {

    private static MyCalculator calculator;

    @BeforeAll
    public static void createCalculator(){
        calculator = new MyCalculator();
    }

    @ParameterizedTest(name = "compare({0}, {1}, {2}) = {3}")
    @CsvSource({
            "2, 3, >, false",
            "3, 2, >, true",
            "3, 3, >, false",

            "1, 3, <, true",
            "3, 1, <, false",
            "3, 3, <, false",

            "2, 3, =, false",
            "3, 3, =, true"
    })
    void shouldReturnCorrectResultForValidOperation(int a, int b, char operation, boolean expected){
         boolean result = calculator.compareTwoNumbers(a, b, operation);

        assertEquals(expected,result, "Ожидаемый результат сравнения не совпадает с фактическим.");
    }

    @Test
    void shouldThrowExceptionWhenWrongOperation(){
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.compareTwoNumbers(2,4, '$')
        );
        assertEquals("Ошибка: такой операции не существует.", ex.getMessage());
    }
}
