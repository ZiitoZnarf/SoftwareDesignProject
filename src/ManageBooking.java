import java.util.ArrayList;
import java.util.List;

public class ManageBooking {
    private List<Booking> bookings;
    private ManageRoom manageRoom;

    public ManageBooking(ManageRoom manageRoom) {
        this.bookings = new ArrayList<>();
        this.manageRoom = manageRoom;
    }

    //reserve room
    public String reserveRoom(int customerID, String timeSlot, int roomID, int numParticipants, ManageAccount manageAccount){
        //check if cust exist
        Customer customer = manageAccount.getCustomerByID(customerID);
        if (customer == null) {
            return "Customer not found. Please register first.";
        }

        //check room avail
        Room room = manageRoom.getRoomByID(roomID);
        if (room == null) {
            return "Room not found.";
        }
        if (!room.getStatus().equalsIgnoreCase("available")) {
            return "Room is not available.";
        }
        if (numParticipants > room.getMaxParticipant()) {
            return "Number of participants exceeds room capacity.";
        }

        int bookingID = bookings.size() + 1;
        float downPayment = 0.2f * room.getBasePrice();

        //reserve
        Booking newBooking = new Booking(bookingID, downPayment, numParticipants, timeSlot, room, customer);
        bookings.add(newBooking);

        //update room status
        room.setStatus("booked");
        return "Room reserved successfully.";
    }
}
