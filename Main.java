

import java.util.Scanner;

import assignment1.*;
import assignment1.animals.*;
import assignment1.com.company.details.Engine;
import assignment1.com.company.proffesions.Driver;
import assignment1.com.company.vehicles.Car;
import assignment1.com.company.vehicles.SportCar;

public class Main {
    public static void main(String args[]){
        // library and book
        Book book1 = new Book("The Little Prince", "Antoine de Saint Exupéry");
        Book book2 = new Book("Harry Potter and the Philosopher's Stone","J.K. Rowling");
        libraryUser user1 = new libraryUser("A. Alish", 1, "SE", "2000", "777777777");
        user1.returnBook(user1.name, book1, book2);
        // recursion with input
        System.out.println("");
        
        Recursion recur = new Recursion();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();        
        int b = scanner.nextInt();
        scanner.close();
        
        System.err.println(recur.print(a, b));

        // inheritance
        Aspirant aspirant = new Aspirant("John", "Sina", "Math", 5, "art of kicks");
        Student student = aspirant;
        System.out.println(student.getScholarShip() + "\n");
        Student[] students = new Student[3];
        students[0] = student;
        students [1] = new Student("Johan", "Kir", "Math", 5);
        students[2] = new Aspirant("Jane", "Dope", "Math", 3.8, "karate");
        for (Student kid : students){
            System.out.println(kid.getScholarShip());
        }

        //com.company
        Driver driver = new Driver("Aleg Olgae", 10);
        Engine engine = new Engine(2, "horse powers");
        Car car = new Car("Konya", "koryto", 5.5, driver, engine);
        System.out.println(car.toString());
        SportCar sportCar = new SportCar("horsing", "fast", 11.11, driver, engine, 60);
        System.err.println(sportCar.toString());

        // animals
        Animal[] animals = new Animal[3];
        animals[0] = new Cat("fish", "LA");
        animals[1] = new Dog("bark", "Bark Land");
        animals[2] = new Horse("Grass", "Beshparmak");
        
        for (Animal animal : animals){
            System.out.println(Veterinary.treatAnimal(animal));
        }
    }
}
