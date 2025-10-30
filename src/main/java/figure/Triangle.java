package figure;

public class Triangle implements Figure {
    private String fillColor;
    private String borderColor;
    private double[] sides = new double[3];

    public Triangle(String fillColor, String borderColor, double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Такого треугольника не существует");
            }
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        sides[0] = a;
        sides[1] = b;
        sides[2] = c;
    }

    @Override
    public void setFillColor(String color) {
        fillColor = color;
    }

    @Override
    public void setBorderColor(String color) {
        borderColor = color;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return sides[0] + sides[1] + sides[2];
    }

    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2.0; // полупериметр
        return Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
    }
}
