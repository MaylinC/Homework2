package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Participants;

public class TakeCommand implements Command {

    private Participants player;

    TakeCommand(Participants player) {
        this.player = player;
    }

    @Override
    public void execute(String cmd2) {
        

    }

    @Override
    public String getDescription() {
        return null;
    }
}
