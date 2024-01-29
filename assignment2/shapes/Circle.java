package assignment2.shapes;

public class Circle implements Shape{
    int radius;
    final int pi = 3;
    public Circle(int radius){
        this.radius = radius;
    }
    @Override
    public String calculateArea(){
        return "Area of circle = " + radius*radius*2*pi;
    }

    @Override
    public String calculatePerimeter() {
        return "Perimeter of circle = " + 2*pi*radius;
    }
}
