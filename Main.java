


import Library.dao.*;
import Library.model.*;
import Library.service.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) {
        String connectionUrl = "jdbc:postgresql://localhost:1234/Library";
        String username = "postgres";
        String password = "1234";
        Connection con = null;
        allFunctionallity(connectionUrl, username, password, con);

    }
    public static void allFunctionallity(String connectionUrl, String username, String password, Connection con){


        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "1234");

//  BOOKS-----------------------------------------------------
//            connecting to database
            BookDao bookDao = new BookDao(connectionUrl, username, password);
            BookService bookService = new BookService(bookDao);
//      printing all books
            System.out.println("All books: #print 1");
            List<Book> allBooks = bookService.getAllBooks();
            for(Book book : allBooks){
                System.out.println(book.getId()+". "+book.getTitle()+" - "+book.getAuthor());
            }
//            create list of titles for future use
            List<String>titles = allBooks.stream().map(Book::getTitle).toList();
//      Adding book
            Book novel = new Book("Wuthering Heights", "Emily Bronte");
            String newBookTitle = novel.getTitle();
//            if book exists in library, add +1 to amount of book. Otherwise, add new book to library

            if (titles.contains(newBookTitle)) {
                bookService.updateBookAmount(novel);
            }
            else bookService.addBook(novel);
//      Changing books title and author
            int novelId = bookService.getId(novel);
//            System.out.println(novelId);
            bookService.updateBook(novelId, "NONE", "Emily Bronte");

//      printing all books
            System.out.println("All books: #print 1");
            allBooks = bookService.getAllBooks();
            for(Book book : allBooks){
                System.out.println(book.getId()+". "+book.getTitle()+" - "+book.getAuthor());
            }
//      Delete row (book)
            bookService.deleteBook(novelId);
//      printing all books
            System.out.println("All books: #print 1");
            allBooks = bookService.getAllBooks();
            for(Book book : allBooks){
                System.out.println(book.getId()+". "+book.getTitle()+" - "+book.getAuthor());
            }


//  USERS-----------------------------------------------------
            System.out.println("USERS-----------------------------------------------------");
            UserDao userDao = new UserDao(connectionUrl, username, password);
            UserService userService = new UserService(userDao);
//      printing all users
            System.out.println("All users: #print 1");
            List<User> allUsers = userService.getAllUsers();
            for(User user : allUsers){
                System.out.println(user.getId()+". "+user.getUsername()+" - "+user.getEmail());
            }
//      add user
            User lord = new User("Sonjin Woo", "son.woo@example.com");
            userService.addUser(lord);
            User man = new User("Ming Woo", "Minmin@example.com");
            userService.addUser(man);
//      changing users mail
            int userid = userService.getUserId(man);
            userService.updateUser(userid, man.getUsername(), "newEmail@example.com");
//      printing all users
            System.out.println("\nAll users: #print 2");
            allUsers = userService.getAllUsers();
            for(User user : allUsers){
                System.out.println(user.getId()+". "+user.getUsername()+" - "+user.getEmail());
            }
//      deleting users
            userService.deleteUser(userService.getUserId(lord));
            userService.deleteUser(userid);
//      printing all users
            System.out.println("\nAll users: #print 3");
            allUsers = userService.getAllUsers();
            for(User user : allUsers){
                System.out.println(user.getId()+". "+user.getUsername()+" - "+user.getEmail());
            }
//  Borrowing book-------------------------------------
            System.out.println("\nBookBorrowing---------------------------");
            BookBorrowingDao bookBorrowingDao = new BookBorrowingDao(connectionUrl, username, password);
            BookBorrowingService bookBorrowingService = new BookBorrowingService(bookBorrowingDao);
//      Get all borrowings
            System.out.println("All book Borrowings: ");
            List<BookBorrowing> allBookBorrowings = bookBorrowingService.getAllBookBorrowings();
            for (BookBorrowing bookBorrowing : allBookBorrowings){
                System.out.println(bookBorrowing.getId()+ ". " + userService.getUserNameById(bookBorrowing.getUser_Id())+" borrowed "+bookService.getBookById(bookBorrowing.getBook_id()) + " in "+ bookBorrowing.getBorrow_date());
            }
//      borrow book
            LocalDate today = LocalDate.now();
            BookBorrowing borrowMoby = new BookBorrowing(1, 2, today.minusWeeks(1));
            bookBorrowingService.addBookBorrowing(borrowMoby);
//      print
            System.out.println("All book Borrowings: #2");

            allBookBorrowings = bookBorrowingService.getAllBookBorrowings();
            for (BookBorrowing bookBorrowing : allBookBorrowings){
                System.out.println(bookBorrowing.getId()+ ". " + userService.getUserNameById(bookBorrowing.getUser_Id())+" borrowed "+bookService.getBookById(bookBorrowing.getBook_id()) + " in "+ bookBorrowing.getBorrow_date());
            }
//      return book
            borrowMoby.setReturn_date(LocalDate.now());
            bookBorrowingService.returnBook(borrowMoby);
//      print
            System.out.println("Returned book: ");
            System.out.println(userService.getUserNameById(borrowMoby.getUser_Id())+" borrowed "+bookService.getBookById(borrowMoby.getBook_id()) + " in "+ borrowMoby.getBorrow_date() + " returned "+borrowMoby.getReturn_date());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
}



