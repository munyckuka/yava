package assignment1.animals;

public class Animal {
    String food, location;
    public Animal(String food, String location){
        this.food = food;
        this.location = location;
    }
    public String makeNoise(){return "Animal is making noise";}
    public String eat(){return "Animal is eating";}
    public String sleep(){return "Animal is sleeping";}
}
