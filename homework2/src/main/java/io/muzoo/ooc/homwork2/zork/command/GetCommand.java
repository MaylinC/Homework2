package io.muzoo.ooc.homwork2.zork.command;

public class GetCommand {

    public void getCommand(Parser parser, CommandFactory commandFactory) {
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
