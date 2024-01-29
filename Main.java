

import java.util.Scanner;

import assignment1.*;
import assignment1.animals.*;
import assignment1.com.company.details.Engine;
import assignment1.com.company.proffesions.Driver;
import assignment1.com.company.vehicles.Car;
import assignment1.com.company.vehicles.SportCar;
import assignment1.shapes.Circle;
import assignment1.shapes.Square;
import assignment1.students.*;
import assignment2.Book;
import assignment2.Person;
import assignment2.Phone;
import assignment2.libraryUser;

public class Main {
    public static void main(String args[]){
//        Person
        Person John = new Person("John Doe", 121);
        Person nn = new Person();
        //Phone
        Phone phone[] = new Phone[4];
        phone[0] = new Phone();
        phone[1] = new Phone("123123", "Grusha");
        phone[2] = new Phone("890890", "Panana", 8.8);
        phone[3] = new Phone("567765", "Astro");
//      get phones numbers and append them to array, then send messages to phones in array
        String phoneNumbers[] = new String[4];
        int i = 0;
        for (Phone tel : phone){
            System.out.println(tel.getNumber());
            phoneNumbers[i]=tel.getNumber();
            i++;
        }
        phone[1].sendMessage(phoneNumbers);
//        Call by person joe from phone[2]
        System.out.println(phone[0].receiveCall(John.getFullName(), phone[2].getNumber()));

        // library and book
        System.out.println();
        Book book1 = new Book("The Little Prince", "Antoine de Saint Exupéry");
        Book book2 = new Book("Harry Potter and the Philosopher's Stone","J.K. Rowling");
        libraryUser user1 = new libraryUser("A. Alish", 1, "SE", "2000", phone[1]);
        user1.returnBook(user1.name, book1, book2);
        // recursion with input

/*
        Recursion recur = new Recursion();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();        
        int b = scanner.nextInt();
        scanner.close();
        
        System.err.println(recur.print(a, b));

        // inheritance
        Student[] students = new Student[6];
        students[0] = new Student("Johns", "Snow", "Math", 2);
        students [1] = new Student("Johan", "Kir", "Math", 5);
        students[2] = new Aspirant("Jane", "Dope", "Math", 3.8, "karate");
        students[3] = new Graduate("John", "Doe", "Politics", 3.5, "Egov");
        students[4] = new Senior("John", "Silverhand", "shooting", 5);
        students[5] = new Undergraduate("John", "Cap", "P.E", 3.5, "Pulling");
        for (Student kid : students){
            System.out.println(kid.get_name());
        }
        System.out.println();
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

*/
    }
}
