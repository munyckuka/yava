package Library.dao;

import Library.model.Book;

import java.util.Collections;
import java.util.List;

import java.sql.*;
import java.util.ArrayList;

public class BookDao {

    // Database connection parameters
    private final String url;
    private final String username;
    private final String password;

    // Constructor
    public BookDao(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Method to get a database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
//  Method to get books id
    public int getId(Book book){
        String query = "SELECT id FROM Books WHERE title = ? AND author = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }


    }
    public String getBookById(int id){
        String query = "SELECT title, author FROM Books WHERE id = ?";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())    return resultSet.getString("title")+" - "+resultSet.getString("author");
            else return "NONE";
        } catch (SQLException e){
            e.printStackTrace();
            return "NONE";
        }
    }

    // Method to add a book to the database
    public void addBook(Book book) {
        String query = "INSERT INTO Books (title, author) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Method to retrieve all books from the database
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM Books";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                Book book = new Book(id, title, author);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Method to update the amount of book
    public void updateBookAmount(Book book) {
        String query = "UPDATE Books SET amount = ? WHERE title = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setInt(1, book.getAmount()+1);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBook(int id, String title, String author) {
        String query = "UPDATE Books SET title = ? , author = ? WHERE id = ? ";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Method to delete a book from the database
    public void deleteBook(int id) {
        String query = "DELETE FROM Books WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
