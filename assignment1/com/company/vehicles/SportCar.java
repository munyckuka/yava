package assignment1.com.company.vehicles;

import assignment1.com.company.details.Engine;
import assignment1.com.company.proffesions.Driver;

public class SportCar extends Car{
    double topSpeed;
    public SportCar(String brand, String type, Double wt, Driver driver, Engine enginem, double topSpeed){
        super(brand, type, wt, driver, enginem);
        this.topSpeed = topSpeed;
    }
    public String toString(){
        return "Car data: \n " + carBrand + " " + carClass+ " " + weight+" " + topSpeed + "\n" + 
        driver.toString() + '\n' + engine.toString();
    }
}
