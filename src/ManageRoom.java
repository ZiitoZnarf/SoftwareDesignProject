import java.util.ArrayList;
import java.util.List;

public class ManageRoom {
    private List<Room> rooms;

    public ManageRoom() {
        this.rooms = new ArrayList<>();
    }

    //add room
    public void addRoom(Room room){
        rooms.add(room);
    }

    //get room
    public Room getRoomByID(int roomID) {
        for (Room room : rooms) {
            if (room.getRoomID() == roomID) {
                return room;
            }
        }
        return null;
    }

    //room avail
    public boolean isRoomAvailable(int roomID, String timeSlot, List<Booking> bookings) {
        Room room = getRoomByID(roomID);
        if (room == null || !room.getStatus().equalsIgnoreCase("available")) {
            return false;
        }

        for( Booking booking : bookings){
            if (booking.getRoom().getRoomID() == roomID && booking.getTimeSlot().equalsIgnoreCase(timeSlot)){
                return false;
            }
        }
        return true;
    }
}
