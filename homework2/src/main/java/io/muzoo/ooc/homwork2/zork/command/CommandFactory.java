package io.muzoo.ooc.homwork2.zork.command;

import javax.activation.CommandMap;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static Map<String, Command> commandMap = new HashMap<>();

    static { //static initialisation
        commandMap.put("exit", new ExitCommand());
        commandMap.put("echo", new EchoCommand());
//        commandMap.put("take",new )
//        commandMap.put("drop", new )
//        commandMap.put("go", new GoDirection());
//        commandMap.put("info", )
//        commandMap.put("help", );



    }
    public static Command getCommand(String cmd) {
        return commandMap.get("Good Bye !");

    }
}
