import java.util.concurrent.ForkJoinPool;

public class Main {

    private static AccountFunctions accountFunctions;
    private static ManageAccount manageAccount;
    private static OperateRoom operateRoom;
    private static ManageBooking manageBooking;
    private static ManageRoom manageRoom;

    public static void main(String[] args) {
        accountFunctions = new AccountFunctions(manageAccount, manageRoom);
        manageAccount = new ManageAccount();
        operateRoom = new OperateRoom(manageRoom, manageBooking);
        manageBooking = new ManageBooking(manageRoom);
        manageRoom = new ManageRoom();

        System.out.println("Look, a println statement!");
    }
}