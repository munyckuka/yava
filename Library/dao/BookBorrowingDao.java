package Library.dao;

import Library.model.BookBorrowing;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookBorrowingDao {
    private final String url;
    private  final  String username;
    private final String password;
    public BookBorrowingDao(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }
    public int getBookBorrowingId(BookBorrowing bookBorrowing){
        String query = "SELECT id from BookBorrowings where book_id = ? and borrow_date = ?";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, bookBorrowing.getBook_id());
            preparedStatement.setObject(2, bookBorrowing.getBorrow_date(), Types.DATE);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            } else {
                return -1;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return -1;
        }

    }
    public BookBorrowing getBookBorrowing(BookBorrowing bookBorrowing){
        String query = "SELECT  from BookBorrowings where id = ?";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, bookBorrowing.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int user_id = resultSet.getInt("user_id");
                int book_id = resultSet.getInt("book_id");
                LocalDate borrow_date = resultSet.getDate("borrow_date").toLocalDate();
                LocalDate return_date = resultSet.getDate("return_date").toLocalDate();
                BookBorrowing returnBookBorrowing = new BookBorrowing(bookBorrowing.getId(), user_id, book_id, borrow_date, return_date);
                return  returnBookBorrowing;
            } else {
                return null;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }
    public List<BookBorrowing> getAllBookBorrowings(){
        String query = "SELECT * from BookBorrowings";
        List<BookBorrowing> bookBorrowings = new ArrayList<>();
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int user_id = resultSet.getInt("user_id");
                int book_id = resultSet.getInt("book_id");
                LocalDate borrow_date = resultSet.getDate("borrow_date").toLocalDate();
                BookBorrowing bookBorrowing = new BookBorrowing(id, user_id, book_id, borrow_date);
                bookBorrowings.add(bookBorrowing);
            }
        } catch (SQLException e){
                e.printStackTrace();
        }
        return bookBorrowings;
    }
    public void addBookBorrowing(BookBorrowing bookBorrowing){
        String query = "INSERT INTO BookBorrowings (user_id, book_id, borrow_date) VALUES  (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, bookBorrowing.getUser_Id());
            preparedStatement.setInt(2, bookBorrowing.getBook_id());
            preparedStatement.setObject(3, bookBorrowing.getBorrow_date(), Types.DATE);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public  void returnBook(BookBorrowing bookBorrowing){
        String query = "UPDATE BookBorrowings SET return_date = ? WHERE user_id = ? AND book_id = ? AND borrow_date = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setObject(1, bookBorrowing.getReturn_date(), Types.DATE);
            preparedStatement.setInt(2, bookBorrowing.getUser_Id());
            preparedStatement.setInt(3, bookBorrowing.getBook_id());
            preparedStatement.setObject(4, bookBorrowing.getBorrow_date(), Types.DATE);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
