package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Game;
import io.muzoo.ooc.homwork2.zork.MapCreation;
import io.muzoo.ooc.homwork2.zork.Participants;
import io.muzoo.ooc.homwork2.zork.SetRoom;
import io.muzoo.ooc.homwork2.zork.creatures.Monsters;

import javax.activation.CommandMap;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    public static Map<String, Command> commandMap = new HashMap<>();

    public static void allCommand(Game game){ //static initialisation
        Participants participants = game.getPlayer();
        Map<String, SetRoom> bigMap = game.getBigMap();
        CommandFactory commandFactory = game.getCommandFactory();
        LimitCommand limitCommand = game.getLimitCommand();
        commandMap.put("exit", new ExitCommand(game));
        commandMap.put("quit", new QuitCommand(game));
        commandMap.put("play", new PlayCommand(game,commandFactory));
        commandMap.put("help", new HelpCommand(commandFactory));
        commandMap.put("auto", new AutopilotCommand(commandFactory));
        commandMap.put("save", new SaveCommand(game));
        commandMap.put("load", new LoadCommand(game));
        commandFactory.getCommandMap().put("go", new GoDirection(game));
    }

    public Command getCommand(String cmd) {
        return commandMap.get(cmd);

    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }

    public Boolean checkContainCommand(String cmd1){
        return commandMap.containsKey(cmd1);
    }
}

