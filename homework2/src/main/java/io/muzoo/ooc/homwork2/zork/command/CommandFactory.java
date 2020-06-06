package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.MapCreation;
import io.muzoo.ooc.homwork2.zork.Participants;
import io.muzoo.ooc.homwork2.zork.SetRoom;
import io.muzoo.ooc.homwork2.zork.creatures.Monsters;

import javax.activation.CommandMap;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    public static Map<String, Command> commandMap = new HashMap<>();

    public static void allCommand(Participants participants, MapCreation mapCreation, CommandFactory commandFactory, SetRoom setRoom){ //static initialisation
//        commandMap.put("exit", new ExitCommand());
        commandMap.put("take", new TakeCommand(participants));
        commandMap.put("drop", new DropCommand(participants));
        commandMap.put("go", new GoDirection(participants, setRoom, mapCreation));
        commandMap.put("map", new MapCommand(mapCreation));
        commandMap.put("info", new InfoCommand(participants));
//        commandMap.put("play"), new PlayCommand();
//        commandMap.put("help", new HelpCommand());
        commandMap.put("initiateBattle", new InitiateBattleCommand(commandFactory, participants));
    }

    public Command getCommand(String cmd) {
        return commandMap.get(cmd);

    }

    public Boolean checkContainCommand(String cmd1){
        return commandMap.containsKey(cmd1);
    }
}

