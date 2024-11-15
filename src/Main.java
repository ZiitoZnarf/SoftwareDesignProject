import java.util.concurrent.ForkJoinPool;

public class Main {

    private static AccountFunctions accountFunctions;
    private static ManageAccount manageAccount;
    private static OperateRoom operateRoom;
    private static ManageBooking manageBooking;
    private static ManageRoom manageRoom;

    public static void main(String[] args) {
        accountFunctions = new AccountFunctions();
        manageAccount = new ManageAccount();
        operateRoom = new OperateRoom();
        manageBooking = new ManageBooking();
        manageRoom = new ManageRoom();

        System.out.println("Look, a println statement!");
    }
}