package Library.service;

import Library.dao.BookDao;
import Library.model.Book;

import java.util.List;

public class BookService {
    private BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    public int getId(Book book){
        return bookDao.getId(book);
    }
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }


    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    public void updateBookAmount(Book book) {
        bookDao.updateBookAmount(book);
    }
    public void updateBook(int id,String title, String author){
        bookDao.updateBook(id, title, author);
    }

    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }
}