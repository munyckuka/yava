package assignment1.animals;

public class Cat extends Animal{
    public Cat(String food, String location){
        super(food, location);
    }
    @Override
    public String makeNoise(){return "Meow";}
    @Override
    public String eat(){return "Cat eats " + food;} 
    
}
