import java.util.ArrayList;
import java.util.List;

public class OperateRoom {
    private List<Booking> bookings;
    private ManageRoom manageRoom;
    private ManageBooking manageBooking;

    public OperateRoom(ManageRoom manageRoom, ManageBooking manageBooking) {
        this.manageRoom = manageRoom;
        this.manageBooking = manageBooking;
        this.bookings = new ArrayList<>();
    }
}
