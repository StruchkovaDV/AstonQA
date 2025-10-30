import exception.MyArrayDataException;
import exception.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        String[][] goodArray = createFullArray(4,4);
        String[][] wrongSizeArray = createFullArray(5,4);
        String[][] wrongSize2Array = createFullArray(4,3);
        String[][] wrongDataArray = createFullArray(4,4);
        wrongDataArray[1][1] = "fsf";

        try {
            System.out.println("Сумма чисел массива: " + ArrayConverter.parseAndSum(goodArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Ошибки:");
        try {
            ArrayConverter.parseAndSum(wrongSizeArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        try {
            ArrayConverter.parseAndSum(wrongSize2Array);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        try {
            ArrayConverter.parseAndSum(wrongDataArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        ArrayIndexOutOfBoundsExceptionCatcher.catchArrayIndexOutOfBoundsException();
    }

    public static String[][] createFullArray(int i, int j){
        String[][] array = new String[i][j];
        for (int k = 0; k < array.length; k++){
            for(int l = 0; l < array[k].length; l++){
                array[k][l] = "1";
            }
        }
        return array;
    }
}
