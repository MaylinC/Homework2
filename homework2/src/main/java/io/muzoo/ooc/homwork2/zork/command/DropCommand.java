package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Participants;

public class DropCommand implements Command {
    private Participants participants;

    public DropCommand(Participants participants) {
        this.participants = participants;
    }

    @Override
    public void execute(String arg) {
        participants.getInventory().dropMushroom();
    }

    @Override
    public String getDescription() {
        return "Use this command to drop unwanted items in your inventory";
    }
}
