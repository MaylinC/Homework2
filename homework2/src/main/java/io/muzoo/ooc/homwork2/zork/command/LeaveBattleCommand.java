package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Combat;

import java.io.IOException;

public class LeaveBattleCommand implements Command {

    private Combat combat;

    public LeaveBattleCommand(Combat combat) {
        this.combat = combat;
    }
    @Override
    public void execute(String arg) throws IOException {
        combat.setLeave();
    }

    @Override
    public String getDescription() {
        return "Ues this command to leave the battle during the battle zone";
    }
}
