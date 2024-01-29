package assignment1.students;

public class Undergraduate extends Student{
    private String major;
    public Undergraduate(String newFName, String newLName, String newGroup, double newMark, String major){
        super(newFName, newLName, newGroup, newMark);
        this.major = major;
    }
    public String getMajor() {
        return major;
    }
}
