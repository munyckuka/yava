public class test {
    public static void main(String args[]){
        book book1 = new book("The Little Prince", "Antoine de Saint Exupéry");
        book book2 = new book("Harry Potter and the Philosopher's Stone","J.K. Rowling");
        libraryUser user1 = new libraryUser("A. Alish", 1, "SE", "2000", "777777777");
        user1.returnBook(user1.name, book1, book2);
    }
}

class book{
    String name, author;
    public book(){}
    public book(String name, String author){
        this.name=name;
        this.author=author;
    }
}

class libraryUser{
    String name;
    int id;
    String faculty;
    String dateOfBirth;
    String phone;
    libraryUser(){}
    libraryUser(String name, int id, String faculty, String dateOfBirth, String phone){
        this.name=name;
        this.id=id;
        this.faculty=faculty;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
    }
    public void takeBook(int num, String name){
        System.out.println(name + " took " + num + " books");
    }
    public void returnBook(String name, book... titles){
        System.out.println(name + " took " + titles + " books");
    }
}