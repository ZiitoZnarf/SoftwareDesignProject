public class Customer {
    private int playerID;
    private String name;
    private String puzzleCompletionTime;
    private int age;
    private String contactInfo;
    private String paymentInfo;
    private Team team;

    //construct
    public Customer(int playerID, String name, int age, String contactInfo){
        this.playerID = playerID;
        this.name = name;
        this.age = age;
        this.contactInfo = contactInfo;
        this.paymentInfo = null;
    }

    //getters
    public int getPlayerID(){
        return playerID;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getContactInfo(){
        return contactInfo;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
}
