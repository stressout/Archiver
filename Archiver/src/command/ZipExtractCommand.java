package command;


import engine.ZipFileManager;
import exception.PathIsNotFoundException;
import utils.ConsoleHelper;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Extracting an archive.");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Enter the path for extracting:");
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            zipFileManager.extractAll(destinationPath);
            ConsoleHelper.writeMessage("Archive extracted.");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Incorrect path for extracting.");
        }
    }
}
