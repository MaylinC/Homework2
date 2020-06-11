package io.muzoo.ooc.homwork2.zork.command;

public class HelpCommand implements Command{

    private CommandFactory commandFactory;

    HelpCommand(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }


    @Override
    public void execute(String arg) {
        for (String command : commandFactory.getCommandMap().keySet()) {
            System.out.println(command + ": " + commandFactory.getCommandMap().get(command).getDescription());
        }
    }

    @Override
    public String getDescription() {
        return "This command display the information of each command in the game";
    }
}
