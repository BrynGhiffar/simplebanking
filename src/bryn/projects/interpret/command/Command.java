package bryn.projects.interpret.command;

import bryn.projects.models.Bank;

import java.util.regex.Pattern;

public abstract class Command {

    protected Bank bank;
    protected Pattern pattern;

    public Command(Bank bank, String pattern) {
        this.bank = bank;
        this.pattern = Pattern.compile(pattern);
    }

    protected boolean matches(String command) {
        return pattern.matcher(command).matches();
    }

    // returns Whether the command had the correct syntax
    public abstract boolean parseCommand(String command);
}
