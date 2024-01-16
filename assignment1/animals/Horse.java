package assignment1.animals;

public class Horse extends Animal{
    public Horse(String food, String location){
        super(food, location);
    }
    @Override
    public String makeNoise(){return "Neigh";}
    @Override
    public String eat(){return "Horse eats " + food;} 
}