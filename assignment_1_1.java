class phone {
    private String number;
    private String model;
    private double weight;

    
    public phone(){}
    public phone(String number, String model){
        this.number = number;
        this.model = model;
    }
    public phone(String number, String model, double weight) {
            this(number, model);
            this.weight = weight;
        }
    public String receiveCall(String caller) {
        return caller+ " is ringing";
    }
    public String receiveCall(String caller, String callerNum){
        return caller + "(" + callerNum + ") is calling";
    } 
    public String getNumber(){
        return number;
    }
    public void sendMessage(String... numbers) {
        for (String number : numbers) {
            System.out.println("sended to " + number);
        }
    }
    
    // public static void main(String[] args) {
    //     phone p1 = new phone("123-123-12-12", "nokia", 12);
    //     phone p2 = new phone("123-123-33-33", "lenova", 12);
    //     phone p3 = new phone("333-123-44-44", "nokia", 13);
    //     System.out.println("p1 p2 p3");
    //     System.out.println(p1.number + " " + p2.number + " " + p3.number);
    //     System.out.println(p1.model + " " + p2.model + " " + p3.model);
    //     System.out.println(p1.weight + " " + p2.weight + " " + p3.weight);
        
    //     p1.receiveCall("222-333-11-11"); System.out.println(p1.getNumber());
    //     p2.receiveCall("111-111-11-11"); System.out.println(p2.getNumber());
    //     p3.receiveCall("555-555-55-55"); System.out.println(p3.getNumber());
        
    // }
}

class person{
    private String fullName;
    private int age; 

    public person(){}
    public person(String fullName, int age){
        this.fullName = fullName;
        this.age = age;
    }
    public String talk(String fullNamem, String text){
        return fullNamem + " said " + text;
    }
    public void move(String fullName){
        System.out.println(fullName + " is moving");
    }
    public static void main(String[] args) {
        person john = new person();
        person muck = new person("Muck_Lover", 17);
    }
}

class matrix{
    int[][] array;
    int r,c;
    public matrix(int[] array, int r, int c){
        this.c = c;
        this.r = r;
        this.array=new int[r][c];
    }
    public void multiply(int[][] arr, int mult, int c, int r){
        for(int i=0;i<r;i++){
            for(int j=0; j<c;j++){
                arr[i][j] *= mult;
                System.out.println(arr[i][j]);
            }
        }
    }
    public void printMatrix(int[][] arr, int c, int r) {
        for(int i=0;i<r;i++){
            for(int j=0; j<c;j++){
                System.out.println(arr[i][j]);
            }
        }
    }
    public void sum(int[][] arr, int[][] arr2, int c, int r){
        for(int i =0; i<r; i++){
            for(int j=0;j<c; j++){
                arr[i][j]+=arr2[i][j];
            }
        }
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
    System.out.print(name + " took " + titles.length + " books ");
    for(book title : titles){
        System.out.print(title.name + " ");
    }
    }
}

public class Main {
    public static void main(String args[]){
        book book1 = new book("The Little Prince", "Antoine de Saint Exupéry");
        book book2 = new book("Harry Potter and the Philosopher's Stone","J.K. Rowling");
        libraryUser user1 = new libraryUser("A. Alish", 1, "SE", "2000", "777777777");
        user1.returnBook(user1.name, book1, book2);
    }
}
