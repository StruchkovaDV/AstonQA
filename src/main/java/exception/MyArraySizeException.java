package exception;

public class MyArraySizeException extends Exception{

    public MyArraySizeException(){
        super("Ошибка: размер массива должен быть 4х4");
    }
}
