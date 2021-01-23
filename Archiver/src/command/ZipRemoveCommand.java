package command;


import engine.ZipFileManager;
import utils.ConsoleHelper;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Delete file from archive.");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Enter the full path of the file in archive:");
        Path sourcePath = Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(sourcePath);
        ConsoleHelper.writeMessage("Deleting from archive is done.");
    }
}