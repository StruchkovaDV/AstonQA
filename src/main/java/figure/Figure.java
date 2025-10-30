package figure;

public interface Figure {

    void setFillColor(String color);

    void setBorderColor(String color);

    String getFillColor();

    String getBorderColor();

    double calculatePerimeter();

    double calculateArea();

    default void printInfo() {
        System.out.println(
                "Периметр: " + calculatePerimeter() + "\n" +
                        "Площадь: " + calculateArea() + "\n" +
                        "Цвет заливки: " + getFillColor() + "\n" +
                        "Цвет границы: " + getBorderColor() + "\n"
        );
    }
}
