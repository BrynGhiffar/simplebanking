package bryn.projects.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private Map<String, Customer> customers;
    private Integer numberOfCustomers;
    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
        customers = new HashMap<>();
    }

    public void addCustomer(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customers.put(firstName + " " + lastName, customer);
    }

    public Integer getNumberOfCustomers() {
        return this.numberOfCustomers;
    }

    public Customer getCustomer(String name) {
        return customers.get(name);
    }

    public List<String> getCustomerNames() {
        return customers.keySet().stream().toList();
    }

    public Boolean customerExists(String name) {
        return customers.containsKey(name);
    }
}
