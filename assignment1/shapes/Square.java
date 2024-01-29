package assignment1.shapes;

public class Square extends Shape{
    int length, width;
    public Square(int length, int width){
        this.length = length; this.width =width;
    }
    @Override
    public String calculateArea(){
        return "Area of square = " + width*length;
    }
}
