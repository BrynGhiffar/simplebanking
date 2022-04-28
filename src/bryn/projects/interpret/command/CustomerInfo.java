package bryn.projects.interpret.command;

import bryn.projects.models.Account;
import bryn.projects.models.Bank;
import bryn.projects.models.Customer;

import java.util.List;
import java.util.Locale;

public class CustomerInfo extends Command {

    public CustomerInfo(Bank bank) {
        super(bank, "(info [ a-z]+)|(info)");
    }

    private String getCustomerName(String command) {
        if (command.equals("info")) {
            return null;
        } else {
            return command.substring("info ".length()).stripLeading().stripTrailing();
        }
    }

    @Override
    public boolean parseCommand(String command) {
        if (matches(command)) {
            String name = getCustomerName(command);
            if (name == null) {
                System.out.printf("---- INFO ALL ----\n\n");
                bank.getCustomerNames().forEach(customerName -> {
                    Customer customer = bank.getCustomer(customerName);
                    Account account = customer.getAccount();
                    if (account != null)
                        System.out.println(String.format("=> %s $%.2f", customerName, account.getBalance()));
                    else
                        System.out.println(String.format("=> %s (no account)", customerName));
                });
            } else {
                if (bank.customerExists(name)) {
                    System.out.printf("---- INFO %s ----\n\n", name.toUpperCase(Locale.ROOT));
                    Customer customer = bank.getCustomer(name);
                    Account account = customer.getAccount();
                    if (account != null)
                        System.out.println(String.format("@ %s $%.2f", name, account.getBalance()));
                    else
                        System.out.println(String.format("@ %s (no account)", name));
                } else {
                    System.out.println("Error customer does not exist");
                }
            }
            System.out.println();
            return true;
        }
        return false;
    }
}
