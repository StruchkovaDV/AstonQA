package figure;

public class FigureMain {
    public static void main(String[] args) {
        Circle circle = new Circle("Белый", "Красный", 5);
        System.out.println("Круг:");
        circle.printInfo();

        Triangle triangle = new Triangle("Синий", "Желтый", 4,3,5);
        System.out.println("Треугольник:");
        triangle.printInfo();

        Rectangle rectangle = new Rectangle("Черный", "Синий", 5, 7);
        System.out.println("Прямоугольник:");
        rectangle.printInfo();
    }
}
