package figure;

public class Rectangle implements Figure{

    private String fillColor;
    private String borderColor;
    private double[] sides = new double[2];

    public Rectangle(String fillColor, String borderColor, double a, double b) {
        if(a <= 0 || b <= 0){
            throw new IllegalArgumentException("Стороны должны быть > 0");
        }
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        sides[0] = a;
        sides[1] = b;
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
        return 2*(sides[0] + sides[1]);
    }

    @Override
    public double calculateArea() {
        return sides[0] * sides[1];
    }
}
