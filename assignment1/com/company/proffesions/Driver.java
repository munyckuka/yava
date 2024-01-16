package assignment1.com.company.proffesions;
import assignment1.Person;
public class Driver extends Person{
    int drivingExperience;
    public Driver(String fullname, int drivingExperience){
        super(fullname);
        this.drivingExperience = drivingExperience;
    }
    public String toString(){
        return "Driver data: \nname:" + getFullName() + " exp:" + drivingExperience+ "\n";
    }
}
