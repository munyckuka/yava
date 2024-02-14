package Library.dao;

import Library.model.BookBorrowing;

import java.sql.*;
import java.time.LocalDate;
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
    public int getUserId(int book_id, LocalDate borrow_date){
        String query = "SELECT user_id from BookBorrowings where book_id = ? and borrow_date = ?";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, book_id);
            preparedStatement.setString(2, borrow_date.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("user_id");
            } else {
                return -1;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return -1;
        }

    }
    public List<BookBorrowing> getAllBookBorrowings(){
        String query = "SELECT * from BookBorrowings";
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()){
                int user_id = resultSet.getInt("user_id");
                int book_id = resultSet.getInt("book_id");
                LocalDate borrow_date = resultSet.getDate("borrow_date").toLocalDate();
                LocalDate return_date = resultSet.getDate("return_date").toLocalDate();
                BookBorrowing bookBorrowing = new BookBorrowing(user_id, book_id, borrow_date, return_date);
            }
        } catch (SQLException e){
                e.printStackTrace();
        }
    }
}
}
