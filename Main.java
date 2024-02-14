


import Library.dao.BookDao;
import Library.model.Book;
import Library.service.BookService;

import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) {
        String connectionUrl = "jdbc:postgresql://localhost:1234/Library";
        String username = "postgres";
        String password = "1234";
        Connection con = null;

        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "1234");

//            BOOKS
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
        } catch (Exception e){
            System.out.println(e);
        } finally {
            try{
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
}



