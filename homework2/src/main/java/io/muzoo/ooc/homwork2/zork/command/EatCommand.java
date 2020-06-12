package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Participants;

import java.io.IOException;

public class EatCommand implements Command{
    private Participants participants;

    public EatCommand (Participants participants) {
        this.participants = participants;
    }

    @Override
    public void execute(String arg) {
        Integer hp = participants.getInventory().getMushroom();
        participants.updateHP(participants.getHp() + hp);
        System.out.println("Your HP is increase by 2");
    }

    @Override
    public String getDescription() {
        return "Use this command to eat mushroom and gain a bit more HP";
    }
}
