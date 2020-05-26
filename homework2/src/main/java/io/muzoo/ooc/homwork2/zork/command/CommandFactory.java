package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Participants;
import io.muzoo.ooc.homwork2.zork.creatures.Monsters;

import javax.activation.CommandMap;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static Map<String, Command> commandMap = new HashMap<>();
    private static Participants participants;
    private static Monsters monsters;

    public static void playCommand(){ //static initialisation
        commandMap.put("exit", new ExitCommand());
        commandMap.put("take", new TakeCommand(participants));
        commandMap.put("drop", new DropCommand(participants));
        commandMap.put("go", new GoDirection());
        commandMap.put("info", new InfoCommand(participants));
        commandMap.put("help", new HelpCommand());
        commandMap.put("attack", new AttackCommand(participants, monsters));
    }

    public static Command getCommand(String cmd) {
        return commandMap.get(cmd);

    }

    public Boolean checkContainCommand(String cmd1){
        return commandMap.containsKey(cmd1);
    }
}

