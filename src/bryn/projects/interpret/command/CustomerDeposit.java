package bryn.projects.interpret.command;

import bryn.projects.models.Bank;
import bryn.projects.models.Customer;

public class CustomerDeposit extends Command{
    public CustomerDeposit(Bank bank) {
        super(bank, "^[ a-z]+ deposits [0-9]+\\.?[0-9]+$");
    }

    private String getCustomerName(String command) {
        String[] res = command.split(" deposits ");
        return res[0].stripLeading().stripTrailing();
    }

    private Double getAmount(String command) {
        String[] res = command.split(" deposits ");
        return Double.valueOf(res[1].stripLeading().stripTrailing());
    }

    @Override
    public boolean parseCommand(String command) {
        if (matches(command)) {
            String customerName = getCustomerName(command);
            if (bank.customerExists(customerName)) {
                Customer customer = bank.getCustomer(customerName);
                if (customer.getAccount() != null) {
                    Double amount = getAmount(command);
                    Double past = customer.getAccount().getBalance();
                    customer.getAccount().deposit(amount);
                    if (customer.getAccount().getBalance() != past)
                        System.out.printf("Customer %s has deposited $%.2f\n", customerName, amount);
                    else
                        System.out.printf("Customer %s has made no transactions\n", customerName);
                } else {
                    System.out.printf("Customer %s does not have an account. Please create an account\n", customerName);
                }
            } else {
                System.out.println("Error customer does not exist");
            }
            return true;
        }
        return false;
    }
}
