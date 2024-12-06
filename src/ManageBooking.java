import java.util.ArrayList;
import java.util.List;

public class ManageBooking {
    private List<Booking> bookings;
    private ManageRoom manageRoom;
    private ManageAccount manageAccount;
    private BookingBuilder bookingBuilder;

    public ManageBooking( ManageAccount manageAccount, ManageRoom manageRoom) {
        this.bookings = new ArrayList<>();
        this.manageRoom = manageRoom;
        this.manageAccount = manageAccount;
        this.bookingBuilder = new BookingBuilder();
    }

    //reserve room
    public String reserveRoom(int customerID, String timeSlot, int roomID, int numParticipants){
        //check if cust exist
        bookingBuilder.reset();

        Customer customer = manageAccount.getCustomerByID(customerID);
        if (customer == null) {
            return "Customer not found. Please register first.";
        }
        bookingBuilder.setCustomer(customer);

        //payment info check
        if (customer.getPaymentInfo() == null) {
            return "Customer payment info is missing. Please update your payment information.";
        }


        //check room avail
        if (!manageRoom.isRoomAvailable(roomID, timeSlot, bookings)) {
            return "Room is not available at the specified time slot.";
        }
        bookingBuilder.setTimeSlot(timeSlot);


        //check room exist / player count
        Room room = manageRoom.getRoomByID(roomID);
        if (room == null) {
            return "Room not found.";
        }
        bookingBuilder.setRoom(room);

        if (numParticipants > room.getMaxParticipant()) {
            return "Number of participants exceeds room capacity.";
        }
        bookingBuilder.setNumberOfParticipants(numParticipants);

        //reserve
        int bookingID = bookings.size() + 1;
        bookingBuilder.setBookingId(bookingID);

        float downPayment = 0.2f * numParticipants * room.getBasePrice();
        bookingBuilder.setDownPayment(downPayment);

        bookings.add(bookingBuilder.build());

        //update status
        //room.setStatus("booked");
        return "Room reserved successfully.";
    }
}
