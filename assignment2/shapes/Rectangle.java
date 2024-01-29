package assignment2.shapes;

public class Rectangle implements Shape{
    int length, width;
    public Rectangle(int length, int width){
        this.length = length; this.width =width;
    }
    @Override
    public String calculateArea(){
        return "Area of rectangle = " + width*length;
    }

    @Override
    public String calculatePerimeter() {
        return "Perimeter of rectagnle = " + 2*(length+width);
    }
}
