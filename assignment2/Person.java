package assignment2;
public class Person{
    private String fullName;
    private int age; 

    public Person(){}
    public Person(String fullName){
        this.fullName = fullName;
    }
    public Person(String fullName, int age){
        this.fullName = fullName;
        this.age = age;
    }
    public String talk(String fullNamem, String text){
        return fullNamem + " said " + text;
    }
    public String move(String fullName){
        return fullName + " is moving";
    }
    public String getFullName(){
        return fullName;
    }
}
