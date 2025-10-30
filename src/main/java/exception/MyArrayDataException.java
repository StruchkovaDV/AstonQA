package exception;

public class MyArrayDataException extends Exception{

    public MyArrayDataException(int i, int j, String element){
        super("Ошибка: элемент \"" + element + "\" с номером i = " + i + ", j = " + j + " нельзя преобразовать в число");
    }
}
