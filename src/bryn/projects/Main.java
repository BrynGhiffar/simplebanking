package bryn.projects;

// Banking system needs:
// * add customers to the bank
// * open an account
// * check customers balance
// * withdraw and deposit a certain amount

// info [customer] -> returns the balance of the customer
// create customer [name] -> creates a bank
// create account for [customer name] -> creates an account for the given customer
// [customer name] deposits [amt] -> depositing amount
// [customer name] withdraws [amt] -> withdrawing amount

import bryn.projects.interpret.command.*;
import bryn.projects.models.Bank;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Bank bank = new Bank("CLI Bank");
        CustomerInfo customerInfo = new CustomerInfo(bank);
        CreateAccount createAccount = new CreateAccount(bank);
        CreateCustomer createCustomer = new CreateCustomer(bank);
        CustomerDeposit customerDeposit = new CustomerDeposit(bank);
        CustomerWithdraw customerWithdraw = new CustomerWithdraw(bank);
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("Welcome to...");
        System.out.println("                          _____ _      _____     ____              _                           ");
        System.out.println("  ______ ______ ______   / ____| |    |_   _|   |  _ \\            | |     ______ ______ ______ ");
        System.out.println(" |______|______|______| | |    | |      | |     | |_) | __ _ _ __ | | __ |______|______|______|");
        System.out.println("  ______ ______ ______  | |    | |      | |     |  _ < / _` | '_ \\| |/ /  ______ ______ ______ ");
        System.out.println(" |______|______|______| | |____| |____ _| |_    | |_) | (_| | | | |   <  |______|______|______|");
        System.out.println("                         \\_____|______|_____|   |____/ \\__,_|_| |_|_|\\_\\                       ");
        System.out.println("                                                                                               ");
        System.out.println("                                                                                               ");
        do {
            System.out.printf("Enter command (type \"help\" for commands): ");
            command = scanner.nextLine().stripLeading().stripTrailing();
            if (customerInfo.parseCommand(command)) {
            } else if (createAccount.parseCommand(command)) {
            } else if (createCustomer.parseCommand(command)) {
            } else if (customerDeposit.parseCommand(command)) {
            } else if (customerWithdraw.parseCommand(command)) {
            } else if (command.equals("help")) {
                System.out.println();
                System.out.println("---- COMMANDS ----");
                System.out.println("\"info [firstname] [lastname]\" => returns the information of the customer");
                System.out.println();
                System.out.println("\"info\" => returns all customer information");
                System.out.println();
                System.out.println("\"create customer [firstname] [lastname]\" => creates a customer");
                System.out.println();
                System.out.println("\"create account for [firstname] [lastname]\" => creates an account for the customer");
                System.out.println();
                System.out.println("\"[firstname] [lastname] deposits [amount]\" => deposits to the customers account");
                System.out.println();
                System.out.println("\"[firstname] [lastname] withdraws [amount]\" => withdraws from the customers account");
                System.out.println();
                System.out.println("\"exit\" => exits from the program");
                System.out.println();
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Error command not recognised");
            }
        } while (true);
    }
}
