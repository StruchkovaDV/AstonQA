import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculateAreaTest {

    private static MyCalculator calculator;

    @BeforeAll
    static void setUp() {
        calculator = new MyCalculator();
    }

    @ParameterizedTest(name = "area({0}, {1}, {2}) = {3}")
    @CsvSource({
            "3, 4, 5, 6.0",
            "4, 4, 5, 7.806247"
    })
    void shouldCalculateAreaForValidTriangles(int a, int b, int c, double expectedArea) {
        double area = calculator.calculateAreaTriangle(a, b, c);

        assertEquals(expectedArea, area, 1e-6,
                () -> String.format("Неверная площадь для треугольника (%d, %d, %d)", a, b, c));
    }

    @ParameterizedTest(name = "invalid side: {0}, {1}, {2}")
    @CsvSource({
            "-2, 4, 5",
            "0, 4, 5",
            "4, -1, 5",
            "4, 5, 0"
    })
    void shouldThrowExceptionWhenSideIsNotPositive(int a, int b, int c) {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateAreaTriangle(a, b, c)
        );

        assertTrue(ex.getMessage().contains("Стороны"));
    }

    @ParameterizedTest(name = "non-existing triangle: {0}, {1}, {2}")
    @CsvSource({
            "1, 4, 5",
            "2, 2, 5",
            "10, 1, 1"
    })
    void shouldThrowExceptionWhenTriangleDoesNotExist(int a, int b, int c) {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateAreaTriangle(a, b, c)
        );

        assertTrue(ex.getMessage().contains("не существует"));
    }
}