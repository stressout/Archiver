package utils;

import command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command> ALL_COMMANDS_MAP = new HashMap<>();

    static {
        ALL_COMMANDS_MAP.put(Operation.CREATE, new ZipCreateCommand());
        ALL_COMMANDS_MAP.put(Operation.ADD, new ZipAddCommand());
        ALL_COMMANDS_MAP.put(Operation.REMOVE, new ZipRemoveCommand());
        ALL_COMMANDS_MAP.put(Operation.EXTRACT, new ZipExtractCommand());
        ALL_COMMANDS_MAP.put(Operation.CONTENT, new ZipContentCommand());
        ALL_COMMANDS_MAP.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutor() {
    }
    
    // The "Command" pattern
    public static void execute(Operation operation) throws Exception {
        ALL_COMMANDS_MAP.get(operation).execute();
    }
}
