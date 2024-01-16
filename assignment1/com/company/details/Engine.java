package assignment1.com.company.details;

public class Engine {
    int power;
    String manufacturer;
    public Engine(int power, String manufacturer) {
        this.power = power;
        this.manufacturer = manufacturer;
    }
    public String toString(){
        return "Engine data: \n" + power + " " + manufacturer;
    }
}