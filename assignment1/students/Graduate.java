package assignment1.students;

public class Graduate extends Student{
    private String areaOfStudy;
    public Graduate(String newFName, String newLName, String newGroup, double newMark, String areaOfStudy){
        super(newFName, newLName, newGroup, newMark);
        this.areaOfStudy = areaOfStudy;
    }
    public String get_areaOfStudy(){
        return areaOfStudy;
    }
}
