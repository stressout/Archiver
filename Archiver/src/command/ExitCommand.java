package command;


import utils.ConsoleHelper;

public class ExitCommand implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Goodbye!");
    }
}
