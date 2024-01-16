package assignment1.com.company.vehicles;

import assignment1.com.company.details.Engine;
import assignment1.com.company.proffesions.Driver;

public class Car {
    String carBrand, carClass;
    Double weight;
    Driver driver;
    Engine engine;

    public String start(){
        return "Let's go";
    }
    public String stop(){
        return "Let's stop";
    }
    public String turnRight(){
        return "Turn right";
    }
    public String turnLeft(){
        return "Turn left";
    }
    // Constructor for creating a new instance of the Car object
    public Car(String brand, String type, Double wt, Driver driver, Engine engine) {
        this.carBrand = brand;
        this.carClass = type;
        this.weight = wt;
        this.driver = driver;
        this.engine = engine;
    }
    public String toString(){
        return "Car data: \n " + carBrand + " " + carClass+ " " + weight+ "\n" + 
        driver.toString() + '\n' + engine.toString();
    }
}
