import java.util.concurrent.ForkJoinPool;

public class Main {

    private static AccountFunctions accountFunctions;
    private static ManageAccount manageAccount;
    private static OperateRoom operateRoom;
    private static ManageBooking manageBooking;
    private static ManageRoom manageRoom;

    public static void main(String[] args) {
        manageRoom = new ManageRoom();
        manageAccount = new ManageAccount();
        accountFunctions = new AccountFunctions(manageAccount, manageRoom);
        manageBooking = new ManageBooking(manageAccount, manageRoom);
        operateRoom = new OperateRoom(manageRoom, manageBooking);

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
        manageAccount.getCustomerByID(1).setPaymentInfo("1234123412341234");


        //registerCustomer Test Cases:

        System.out.printf("Test registerCustomer where customer already exists in system:\n");
        System.out.printf("manageAccount.registerCustomer(\"Mic Erontaldo\", 21, \"notTheSame@worldwide.com\");\n");
        System.out.printf("%s\n\n", manageAccount.registerCustomer("Mic Erontaldo", 21, "notTheSame@worldwide.com"));

        System.out.printf("Test registerCustomer where customer does not exist in system:\n");
        System.out.printf("manageAccount.registerCustomer(\"Someone Else\", 41, \"crazyLand@wackyville.com\");\n");
        System.out.printf("%s\n\n", manageAccount.registerCustomer(" Someone Else", 41, "crazyLand@wackyville.com\n\n"));


        //reserveRoom Test Cases:

        System.out.printf("Test reserveRoom where customerID does not exist:\n");
        System.out.printf("manageBooking.reserveRoom(-1, \"4:00\", 101, 3);\n");
        System.out.printf("%s\n\n", manageBooking.reserveRoom(-1, "4:00", 101, 3));

        System.out.printf("Test reserveRoom where Customer has no paymentInfo:\n");
        System.out.printf("manageBooking.reserveRoom(2, \"4:00\", 99, 3);\n");
        System.out.printf("%s\n\n", manageBooking.reserveRoom(2, "4:00", 99, 3));

        System.out.printf("Test reserveRoom where room does not exist:\n");
        System.out.printf("manageBooking.reserveRoom(1, \"4:00\", 99, 3);\n");
        System.out.printf("%s\n\n", manageBooking.reserveRoom(1, "4:00", 99, 3));

        System.out.printf("Test reserveRoom where room is not currently available:\n");
        System.out.printf("manageBooking.reserveRoom(1, \"4:00\", 103, 4);\n");
        System.out.printf("%s\n\n", manageBooking.reserveRoom(1, "4:00", 103, 4));

        System.out.printf("Test reserveRoom where number of participants exceeds room capacity:\n");
        System.out.printf("manageBooking.reserveRoom(1, \"4:00\", 102, 4);\n");
        System.out.printf("%s\n\n", manageBooking.reserveRoom(1, "4:00", 102, 4));

        System.out.printf("Room is successfully reserved:\n");
        System.out.printf("manageBooking.reserveRoom(1, \"4:00\", 101, 4);\n");
        System.out.printf("%s\n\n", manageBooking.reserveRoom(1, "4:00", 101, 4));

    }
}