package assignment1.students;

public class Student {
    String firstName, lastName, group;
    double averageMark;
    public Student(String newFName, String newLName, String newGroup, double newMark){
        this.firstName = newFName;
        this.lastName = newLName;
        this.group = newGroup;
        this.averageMark = newMark;
    }
    public String get_name(){
        return firstName+' '+lastName;
    }
    public int getScholarShip(){
        return (averageMark == 5) ? 100 : 80;
    }
}
