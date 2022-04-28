package bryn.projects.interpret.command;

import bryn.projects.models.Account;
import bryn.projects.models.Bank;
import bryn.projects.models.Customer;

import java.util.regex.Pattern;

public class CreateAccount extends Command {

    private Pattern commandPattern;

    public CreateAccount(Bank bank) {
        super(bank,"^create account for [ a-z]+$");
    }

    private String getCustomerName(String command) {
        int startName = "create account for ".length();
        String name = command.substring(startName);
        return name;
    }

    @Override
    public boolean parseCommand(String command) {
        if (matches(command)) {
            String name = getCustomerName(command);
            if (bank.customerExists(name)) {
                Customer customer = bank.getCustomer(name);
                if (customer.getAccount() == null) {
                    customer.setAccount(new Account(0.0));
                    System.out.printf("Successfully created account for customer %s\n", name);
                } else {
                    System.out.printf("Customer %s already has an account\n", name);
                }
            } else {
                System.out.println("Error customer does not exist.");
            }
            return true;
        }
        return false;
    }
}