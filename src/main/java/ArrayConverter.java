import exception.MyArrayDataException;
import exception.MyArraySizeException;

public class ArrayConverter {

    private static final int ROWS = 4;
    private static final int COLS = 4;

    public static int parseAndSum(String[][] values) throws MyArraySizeException, MyArrayDataException {
        if (values == null) {
            throw new MyArraySizeException();
        }

        if (values.length != COLS) {
            throw new MyArraySizeException();
        }

        for (int k = 0; k < ROWS; k++) {
            if (values[k] == null) {
                throw new MyArraySizeException();
            }
            if (values[k].length != COLS) {
                throw new MyArraySizeException();
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int element;
                try {
                    element = Integer.parseInt(values[i][j]);
                } catch (NumberFormatException | NullPointerException e) {
                    throw new MyArrayDataException(i, j, values[i][j]);
                }
                sum += element;
            }
        }
        return sum;
    }
}
