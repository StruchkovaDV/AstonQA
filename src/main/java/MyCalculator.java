public class MyCalculator {

    public MyCalculator() {
    }

    public long calculateFactorial(int n){
        if (n < 0){
            throw new IllegalArgumentException("Ошибка: Факториал вычисляется только для положительных чисел.");
        }
        if (n == 0){
            return 1;
        }

        long factorial = 1L;

        for (int i = 1; i <= n; i++){
            factorial *= i;
        }
        return factorial;
    }

    public double calculateAreaTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны должны быть положительными.");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Такого треугольника не существует");
        }
        double p = (a + b +c) / 2.0; // полупериметр
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double calculateArithmeticOperations(int a, int b, char operation){
        return switch (operation) {
            case '+' -> (double) a + b;
            case '-' -> (double) a - b;
            case '*' -> (double) a * b;
            case '/' -> {
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль запрещено.");
                }
                yield (double) a / b;
            }
            default -> throw new IllegalArgumentException("Ошибка: такой операции не существует.");
        };
    }

    public boolean compareTwoNumbers(int a, int b, char operation){
        return switch (operation){
            case '>' -> a > b;
            case '<' -> a < b;
            case '=' -> a == b;
            default -> throw new IllegalArgumentException("Ошибка: такой операции не существует.");
        };
    }
}
