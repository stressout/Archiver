package command;

import engine.ZipFileManager;
import exception.PathIsNotFoundException;
import utils.ConsoleHelper;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Adding a new file to the archive.");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Enter the full file name for adding to the archive:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.addFile(sourcePath);
            ConsoleHelper.writeMessage("Adding to the archive is now complete.");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("File not found.");
        }
    }
}
