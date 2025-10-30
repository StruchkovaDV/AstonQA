package figure;

public class Circle implements Figure{

    private String fillColor;
    private String borderColor;
    private double radius;

    public Circle(String fillColor, String borderColor, double radius) {
        if(radius <= 0){
            throw new IllegalArgumentException("Радиус должен быть > 0.");
        }
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.radius = radius;
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
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
