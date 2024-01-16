package assignment1;
import assignment1.*;
public class Aspirant extends Student {
    private String scientificWork;
    public Aspirant(String firstName, String lastName, String group, double averageMark, String scientificWork) {
        super(lastName, scientificWork, group, averageMark);
        this.scientificWork = scientificWork;
    }
    @Override
    public int getScholarShip(){
        return (averageMark == 5) ? 200 : 180;
    }
}