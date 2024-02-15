package Library.service;

import Library.dao.UserDao;
import Library.model.User;

import java.util.List;

public class UserService {
    private UserDao userDao;
    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public int getUserId(User user){
        return userDao.getUserId(user);
    }
    public String getUserNameById(int id){
        return userDao.getUserNameById(id);
    }
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
    public void addUser(User user){
        userDao.addUser(user);
    }
    public void updateUser(int id, String username, String email) {
        userDao.updateUser(id, username, email);
    }
    public void deleteUser(int id){
        userDao.deleteUser(id);
    }
}
