package assignment1.com.company.vehicles;
import assignment1.com.company.details.Engine;
import assignment1.com.company.proffesions.Driver;
public class Lorry extends Car{
    double carryingCapacity;
    public Lorry(String brand, String type, Double wt, Driver driver, Engine engine, double carryingCapacity){
        super(brand, type, wt, driver, engine);
        this.carryingCapacity = carryingCapacity;
    }
    @Override
    public String toString(){
        return "Car data: \n " + carBrand + " " + carClass+ " " + weight+ " "+ carryingCapacity + "\n" + 
        driver.toString() + '\n' + engine.toString();
    }
}
