package bryn.projects.interpret.command;

import bryn.projects.models.Bank;

public class CreateCustomer extends Command{

    public CreateCustomer(Bank bank) {
            super(bank, "create customer [a-z]+ [a-z]+");
    }

    String getCustomerName(String command) {
        return command.substring("create customer ".length());
    }

    @Override
    public boolean parseCommand(String command) {

        if (matches(command)) {
            String fullName = getCustomerName(command);
            String[] customerName = fullName.split(" ");
            if (!bank.customerExists(fullName)) {
                bank.addCustomer(customerName[0], customerName[1]);
                System.out.printf("Successfully created customer %s\n", fullName);
            } else {
                System.out.println("Error customer already exists");
            }
            return true;
        }
        return false;
    }
}
