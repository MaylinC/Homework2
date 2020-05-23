package io.muzoo.ooc.homwork2.zork.command;

public class ExitCommand implements Command {

    @Override
    public void execute(String arg) {
        System.exit(0);
    }
}
