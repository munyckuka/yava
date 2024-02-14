package Library.model;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean available = true;
    private int amount = 1;

    public Book (String title, String author){

        this.title = title;
        this.author = author;
    }
    public Book (int id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
    }
//    get/set methods
    public int getId(){return id;}
    public void  setId(int id){
        this.id = id;
    }

    public String getTitle(){return title;}
    public void setTitle(String title) {this.title = title;}

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public boolean getAvailable() {return available;}
    public void setAvailable(boolean available) {this.available = available;}

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
