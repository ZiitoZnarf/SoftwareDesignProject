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
        manageBooking = new ManageBooking(manageAccount, manageRoom);
        manageRoom = new ManageRoom();

        //Add Rooms
        manageRoom.addRoom(new Room(101, 3, 5, "available", "Hidden Pyramid", 34.99f));
        manageRoom.addRoom(new Room(102, 6, 3, "available", "Haunted Mansion", 29.99f));
        manageRoom.addRoom(new Room(103, 5, 4, "booked", "Classic", 24.99f));
        manageRoom.addRoom(new Room(104, 2, 5, "unavailable", "Submarine Underwater", 39.99f));

        //Add Customers
        manageAccount.registerCustomer("Mic Erontaldo", 21, "MicrophoneRontaldo@website.com");
        manageAccount.registerCustomer("Mahemmod Azoom", 23, "azoom1234@nevermind.com");
        manageAccount.registerCustomer("Crouton Smoth", 27, "ShowerCurtain@treeg.com");
        manageAccount.registerCustomer("Kandon Bran", 31, "KurgerBing@nononoyes.com");
        manageAccount.registerCustomer("Eryk Warlock", 24, "Expelliarmus@magic.com");




        System.out.println("Look, a println statement!");
    }
}