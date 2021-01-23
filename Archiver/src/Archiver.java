import exception.WrongZipFileException;
import utils.CommandExecutor;
import utils.ConsoleHelper;
import utils.Operation;

import java.io.IOException;

public class Archiver {
    public static void main(String[] args) throws IOException {
        Operation operation = null;
        while ((operation = askOperation()).ordinal() != Operation.EXIT.ordinal()) {
            try {
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("You didn't choose file of archive or choose incorrect file.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("An error occurrence. Check the entered data's.");
            }
        }
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("Choose the operation:");
        ConsoleHelper.writeMessage(String.format("\t %d - archive the files", Operation.CREATE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - add file in archive", Operation.ADD.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - delete file from archive", Operation.REMOVE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - extract archive", Operation.EXTRACT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - view content of archive", Operation.CONTENT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - exit", Operation.EXIT.ordinal()));
        return Operation.values()[ConsoleHelper.readInt()];
    }
}