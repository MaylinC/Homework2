package io.muzoo.ooc.homwork2.zork.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class GetCommand {

    public void getCommand(Parser parser, CommandFactory commandFactory, Map<String, ArrayList<String>> gameStateCommand, String gameState) throws IOException {
        String command = parser.getCommand();
        String cmd1 = command.split("/")[0];
        String cmd2 = command.split("/")[1];
        if (commandFactory.checkContainCommand(cmd1)) {
            commandFactory.getCommand(cmd1).execute(cmd2);
        }
        else {
            System.out.println("Command can't be used");
        }
    }
}
