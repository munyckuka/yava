package assignment1.shapes;

public class Circle extends Shape{
    int radius;
    final int pi = 3;
    public Circle(int radius){
        this.radius = radius;
    }
    @Override
    public String calculateArea(){
        return "Area of circle = " + radius*radius*2*pi;
    }
}
