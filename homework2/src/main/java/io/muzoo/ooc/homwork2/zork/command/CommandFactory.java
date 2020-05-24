package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Participants;

import javax.activation.CommandMap;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static Map<String, Command> commandMap = new HashMap<>();

    static { //static initialisation
        commandMap.put("exit", new ExitCommand());
        commandMap.put("take", new TakeCommand());
        commandMap.put("drop", new DropCommand());
        commandMap.put("go", new GoDirection());
        commandMap.put("info", new InfoCommand());
        commandMap.put("help", new );
        commandMap.put("attack", new AttackCommand());
    }

    public static Command getCommand(String cmd) {
        return commandMap.get(cmd);

    }

    public Boolean checkContainCommand(String cmd1){
        return commandMap.containsKey(cmd1);
    }
}

