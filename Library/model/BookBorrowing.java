package Library.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookBorrowing {
    private int user_id;
    private int book_id;
    private LocalDate borrow_date;
    private LocalDate return_date;
//DATE - format YYYY-MM-DD
    public BookBorrowing(int user_id, int book_id, LocalDate borrow_date, LocalDate return_date){
        this.book_id = book_id;
        this.user_id = user_id;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
    }
    public int getUserId(){
        return user_id;
    }
    public int getBook_id(){
        return book_id;
    }
    public LocalDate getBorrow_date(){
        return borrow_date;
    }
    public void setBorrow_date(LocalDate borrow_date){
        this.borrow_date = borrow_date;
    }
    public LocalDate getReturn_date(){
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }
}
