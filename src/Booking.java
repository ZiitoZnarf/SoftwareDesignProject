public class Booking {
    private float downPayment;
    private int bookingId;
    private int numberOfParticipants;
    private String timeSlot;
    private String confirmation;
    private Room room;
    private Customer customer;

    //construct
    public Booking(int bookingId, float downPayment, int numberOfParticipants, String timeSlot, Room room, Customer customer){
        this.bookingId = bookingId;
        this.downPayment = downPayment;
        this.numberOfParticipants = numberOfParticipants;
        this.timeSlot = timeSlot;
        this.room = room;
        this.customer = customer;
        this.confirmation = "Pending"; 
    }

    //getter setter
    public int getBookingId(){
        return bookingId;
    }

    public void setConfirmation(String confirmation){
        this.confirmation = confirmation;
    }

    public String getConfirmation(){
        return confirmation;
    }

    public Room getRoom(){
        return room;
    }

    public Customer getCustomer(){
        return customer;
    }

    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }

    public String getTimeSlot(){
        return timeSlot;
    }

    public float getDownPayment(){
        return downPayment;
    }
}}
