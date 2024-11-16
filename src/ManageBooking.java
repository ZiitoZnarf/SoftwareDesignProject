import java.util.ArrayList;
import java.util.List;

public class ManageBooking {
    private List<Booking> bookings;
    private ManageRoom manageRoom;

    public ManageBooking(ManageRoom manageRoom) {
        this.bookings = new ArrayList<>();
        this.manageRoom = manageRoom;
    }

}
