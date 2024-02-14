package Library.dao;

import Library.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private final String url;
    private final String username;
    private final String password;

    // Constructor
    public UserDao(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    public String getUsername(User user){
        String query = "SELECT username FROM Users WHERE email = ?";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, user.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("username");
            }else return "NOT FOUND";
        } catch (SQLException e){
            e.printStackTrace();
            return "ERROR";
        }
    }




    

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM Users";
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)){
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                User user = new User(username, email);
                users.add(user);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }


    public void updateUser(int id, String username, String email){
        String query = "UPDATE Users SET username = ? , email = ? where id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteUser(int id){
        String query = "DELETE FROM Users WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
