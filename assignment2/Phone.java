package assignment2;
public class Phone {
     String number;
     String model;
     double weight;

    
    public Phone(){}
    //constructors
    public Phone(String number, String model){
        this.number = number;
        this.model = model;
    }
    public Phone(String number, String model, double weight) {
            this(number, model);
            this.weight = weight;
        }
    // functionality
    public String getNumber(){
        return number;
    }
    public String receiveCall(String caller) {
        return caller+ " is ringing";
    }
    public String receiveCall(String caller, String callerNum){
        return caller + " (" + callerNum + ") is calling";
    } 


    public void sendMessage(String... numbers) {
        for (String number : numbers) {
            System.out.println("sended to " + number);
        }
    }
}