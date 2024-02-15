package Library.model;

public class User {
    private int id;
    private String username;
    private String email;

    public User(String username, String email){
        this.username = username;
        this.email = email;
    }
    public User(int id, String username, String email){
        this.username = username;
        this.id = id;
        this.email = email;
    }
//    get/set methods

    public int getId() {
        return id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
