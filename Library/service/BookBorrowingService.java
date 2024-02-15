package Library.service;

import Library.dao.BookBorrowingDao;
import Library.model.BookBorrowing;

import java.util.List;

public class BookBorrowingService {
    private BookBorrowingDao bookBorrowingDao;
    public BookBorrowingService(BookBorrowingDao bookBorrowingDao){
        this.bookBorrowingDao = bookBorrowingDao;
    }

    public int getBookBorrowingId(BookBorrowing bookBorrowing){
        return bookBorrowingDao.getBookBorrowingId(bookBorrowing);
    }
    public List<BookBorrowing> getAllBookBorrowings(){
        return bookBorrowingDao.getAllBookBorrowings();
    }
    public void addBookBorrowing(BookBorrowing bookBorrowing){
        bookBorrowingDao.addBookBorrowing(bookBorrowing);
    }
    public void returnBook(BookBorrowing bookBorrowing){
        bookBorrowingDao.returnBook(bookBorrowing);
    }
}
