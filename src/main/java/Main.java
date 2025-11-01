public class Main {
    public static void main(String[] args) {
        MyCalculator calculator = new MyCalculator();

        System.out.println("3! = " + calculator.calculateFactorial(3));
        System.out.println("0! = " + calculator.calculateFactorial(0));
        try {
            System.out.println("-3! = " + calculator.calculateFactorial(-3));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Площадь треугольника a=3, b=4, c=5: " + calculator.calculateAreaTriangle(3,4,5));

        try {
            System.out.println("Площадь треугольника a=1, b=4, c=5: " + calculator.calculateAreaTriangle(1,4,5));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Площадь треугольника a=-2, b=4, c=5: " + calculator.calculateAreaTriangle(-2,4,5));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("2 + 3 = " + calculator.calculateArithmeticOperations(2,3,'+'));

        System.out.println("2 - 3 = " + calculator.calculateArithmeticOperations(2,3,'-'));

        try {
            System.out.println("2 / 0 = " + calculator.calculateArithmeticOperations(2,0,'/'));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("2 % 1 = " + calculator.calculateArithmeticOperations(2,1,'%'));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("2 > 3: " + calculator.compareTwoNumbers(2,3,'>'));
        System.out.println("2 < 3: " + calculator.compareTwoNumbers(2,3,'<'));

        try {
            System.out.println("2 % 1: " + calculator.compareTwoNumbers(2,1,'%'));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}
