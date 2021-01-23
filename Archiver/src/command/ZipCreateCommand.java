package command;

import engine.ZipFileManager;
import exception.PathIsNotFoundException;
import utils.ConsoleHelper;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Creating an archive.");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Enter the full name of the file or directory for the archiving:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.createZip(sourcePath);
            ConsoleHelper.writeMessage("Archive created.");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Incorrect file name or directory.");
        }
    }
}
