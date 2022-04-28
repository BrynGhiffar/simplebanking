package bryn.projects.models;

public class Account {

    private Double balance;

    public Account(Double initial) {
        this.balance = initial;
    }

    public Double getBalance() {
        return balance;
    }

    public Boolean deposit(Double amt) {
        Boolean cond = (amt > 0);
        if (cond) balance += amt;
        return cond;
    }

    public Boolean withdraw(Double amt) {
        Boolean cond = (balance >= amt) && (amt > 0);
        if (cond) balance -= amt;
        return cond;
    }
}
