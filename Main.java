

import java.util.Scanner;

import assignment1.*;

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
        
        // Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        scanner.close();
        
        System.err.println(recur.print(a, b));

        
    }
}