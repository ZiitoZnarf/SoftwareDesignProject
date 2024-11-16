import java.util.ArrayList;
import java.util.List;

public class ManageAccount {
    private List<Customer> customers;
    private List<Staff> staff;

    public ManageAccount() {
        this.customers = new ArrayList<>();
        this.staff = new ArrayList<>();
    }

    //register cust
    public String registerCustomer(String name, int age, String contactInfo){
        //check if cust exist
        for (Customer customer : customers){
            if (customer.getName().equalsIgnoreCase(name) && customer.getAge() == age){
                return "Customer account is already in the system.";
            }
        }

        //else create cust
        int newPlayerID = customers.size() + 1;
        Customer newCustomer = new Customer(newPlayerID, name, age, contactInfo);
        customers.add(newCustomer);
        return "Customer account added successfully.";
    }

    //getter
    public Customer getCustomerByID(int playerID){
        for (Customer customer : customers){
            if (customer.getPlayerID() == playerID){
                return customer;
            }
        }

        return null;
    }
}
