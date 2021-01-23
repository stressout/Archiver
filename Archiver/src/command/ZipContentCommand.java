package command;


import engine.FileProperties;
import engine.ZipFileManager;
import utils.ConsoleHelper;

public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Viewing the content of the archive.");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Content of the archive:");
        zipFileManager.getFilesList().forEach((FileProperties fp) -> ConsoleHelper.writeMessage(fp.toString()));
        ConsoleHelper.writeMessage("Content of the archive have read.");
    }
}
