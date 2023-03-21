package model.util.abstracts;

public abstract class AbstractCommand {

    protected String commandPrefix;
    protected int amountOfArgs;

    public abstract String execute(String[] args);

    public String getCommandPrefix() {
        return commandPrefix;
    }
}
