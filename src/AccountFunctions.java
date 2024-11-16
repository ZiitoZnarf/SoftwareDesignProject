import java.util.ArrayList;
import java.util.List;

public class AccountFunctions {
    private List<Team> teams;
    private ManageAccount manageAccount;
    private ManageRoom manageRoom;

    public AccountFunctions (ManageAccount manageAccount, ManageRoom manageRoom) {
        this.manageAccount = manageAccount;
        this.manageRoom = manageRoom;
        this.teams = new ArrayList<>();
    }
}
