package directory;

public class DirectoryMain {
    public static void main(String[] args) {
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();

        telephoneDirectory.add("Басков", "+7(915)666-77-88");
        telephoneDirectory.add("Пугачева", "+7(915)611-17-18");
        telephoneDirectory.add("Леонтьев", "+7(876)123-33-44");
        telephoneDirectory.add("Леонтьев", "+7(876)123-55-77");

        try {
            telephoneDirectory.add("1234", "+7(915)666-77-88");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try {
            telephoneDirectory.add("Лепс", "лаопдлф");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Номера телефонов по фамилии Леонтьев");
        System.out.println(telephoneDirectory.get("Леонтьев"));
    }
}
