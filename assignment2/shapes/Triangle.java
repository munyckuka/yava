package assignment2.shapes;

public class Triangle implements Shape{
    int side1, side2, side3;
    public Triangle(int side1, int side2, int side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public String calculateArea() {
        return "Area of triangle = SOME NUMBER XD";
    }

    @Override
    public String calculatePerimeter() {
        return "Perimeter of triangle = "+ (side3+side2+side1);
    }
}
