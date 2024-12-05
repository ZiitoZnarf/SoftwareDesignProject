import java.util.ArrayList;
import java.util.List;

public class ManageBooking {
    private List<Booking> bookings;
    private ManageRoom manageRoom;
    private ManageAccount manageAccount;

    public ManageBooking( ManageAccount manageAccount, ManageRoom manageRoom) {
        this.bookings = new ArrayList<>();
        this.manageRoom = manageRoom;
        this.manageAccount = manageAccount;
    }

    //reserve room
    public String reserveRoom(int customerID, String timeSlot, int roomID, int numParticipants){
        //check if cust exist
        Customer customer = manageAccount.getCustomerByID(customerID);
        if (customer == null) {
            return "Customer not found. Please register first.";
        }

        //payment info check
        if (customer.getPaymentInfo() == null) {
            return "Customer payment info is missing. Please update your payment information.";
        }

        //check room avail
        if (!manageRoom.isRoomAvailable(roomID, timeSlot, bookings)) {
            return "Room is not available at the specified time slot.";
        }

        //check room exist / player count
        Room room = manageRoom.getRoomByID(roomID);
        if (room == null) {
            return "Room not found.";
        }
        if (numParticipants > room.getMaxParticipant()) {
            return "Number of participants exceeds room capacity.";
        }

        //reserve
        int bookingID = bookings.size() + 1;
        float downPayment = 0.2f * numParticipants * room.getBasePrice();
        Booking newBooking = new Booking(bookingID, downPayment, numParticipants, timeSlot, room, customer);
        bookings.add(newBooking);

        //update status
        room.setStatus("booked");
        return "Room reserved successfully.";
    }
}
