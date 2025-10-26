import java.util.Arrays;
import java.util.Scanner;

public class Lesson2 {
    Scanner scanner = new Scanner(System.in);

    public void printThreeWords(){
        System.out.println("Orange, Banana, Apple");
    }

    public void checkSumSign(){
        int a = -5;
        int b = 3;
        if (a + b >= 0){
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public void printColor(){
        int value = 1000;
        if(value <= 0){
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public void compareNumbers(){
        int a = 2;
        int b = 5;
        if(a >= b){
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public boolean isSumFrom10To20(int a, int b){
        return (a + b > 10) && (a + b <= 20);
    }

    public void checkIsPositive(int a){
        if (a >= 0){
            System.out.println( a + " - положительное число");
        } else {
            System.out.println( a + " - отрицательное число");
        }
    }

    public boolean isNegative(int a){
        return a < 0;
    }

    public void printStr(String line, int count){
        for (int i = 0; i < count; i++){
            System.out.print(line);
        }
        System.out.println();
    }

    public boolean isLeapYear(int year){
        return (year%4 == 0) && (year%100 != 0) || (year%400 == 0);
    }

    public void invert() {
        int length;
        do {
            System.out.println("Задайте длину массива (> 0):");
            length = scanner.nextInt();
            if (length <= 0) {
                System.out.println("Ошибка: длина должна быть положительной.");
            }
        } while (length <= 0);

        int[] arg = new int[length];
        System.out.println("Заполните массив значениями 0 или 1:");
        for (int i = 0; i < length; i++) {
            int value;
            do {
                value = scanner.nextInt();
                if (value != 0 && value != 1) {
                    System.out.println("Ошибка: допускаются только 0 и 1. Повторите ввод:");
                }
            } while (value != 0 && value != 1);
            arg[i] = value;
        }

        for (int i = 0; i < arg.length; i++) {
            arg[i] = 1 - arg[i];
        }

        System.out.println("Результат инверсии:");
        System.out.println(java.util.Arrays.toString(arg));
    }

    public void fullNumberTo100(){
        int[] numbers = new int [100];
        for (int i = 0; i < 100; i++){
            numbers[i] = i + 1;
        }
    }

    public void multiplyBy2(){
        int[] num = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < num.length; i++){
            if (num[i] < 6) {
                num[i] *= 2;
            }
        }
    }

    public void fullDiagonal(int size){
        int[][] numbers = new int[size][size];
        for(int i = 0; i < size; i++){
            numbers[i][i] = 1;
        }
        for (int i = 0; i < size; i++){
            numbers[i][size - i - 1] = 1;
        }
        for(int i = 0; i < size; i++){
           for(int j = 0; j < size; j++){
               System.out.print(numbers[i][j] + " ");
           }
           System.out.println();
        }
    }

    public int[] fullIniTValue(int len, int initialValue){
        int[] numbers = new int[len];
        Arrays.fill(numbers, initialValue);
        return numbers;
    }
}
