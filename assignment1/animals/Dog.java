package assignment1.animals;

public class Dog extends Animal{ 
    public Dog(String food, String location){
        super(food, location);
    }
    @Override
    public String makeNoise(){return "Woof";}
    @Override
    public String eat(){return "Dog eats "+ food;} 
}
