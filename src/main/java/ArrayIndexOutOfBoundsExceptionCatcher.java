public class ArrayIndexOutOfBoundsExceptionCatcher {
    public static void catchArrayIndexOutOfBoundsException(){
        String[] array = new String[4];
        try{
            String element = array[5];
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Исключение ArrayIndexOutOfBoundsException создано и поймано.");
        }
    }
}
