package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Participants;
import io.muzoo.ooc.homwork2.zork.creatures.Monsters;

import java.sql.PseudoColumnUsage;

public class AttackCommand implements Command{

    private Participants participants;
    private Monsters monster;
    private String description;

    public AttackCommand(Participants participants, Monsters monster, String description) {
        this.participants = participants;
        this.monster = monster;
        this.description = description;
    }

    @Override
    public void execute(String arg) {
        if (monster.getName().equals("Basilisk")) {

        }

    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
