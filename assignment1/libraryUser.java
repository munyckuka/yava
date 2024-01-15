package assignment1;

public class libraryUser{
    public String name;
    int id;
    String faculty;
    String dateOfBirth;
    String phone;
    public libraryUser(){}
    public libraryUser(String name, int id, String faculty, String dateOfBirth, String phone){
        this.name=name;
        this.id=id;
        this.faculty=faculty;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
    }
    public void takeBook(int num, String name){
        System.out.println(name + " took " + num + " books");
    }
    public void returnBook(String name, Book... titles){
        System.out.print(name + " took " + titles.length + " books ");
        for(Book title : titles){
            System.out.print(title.name + " ");
        }
    }
}
