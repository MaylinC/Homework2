package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Combat;
import io.muzoo.ooc.homwork2.zork.Participants;
import io.muzoo.ooc.homwork2.zork.creatures.Monsters;

import java.io.IOException;

public class InitiateBattleCommand implements Command {
    private CommandFactory commandFactory;
    private Participants participants;

    public InitiateBattleCommand(CommandFactory commandFactory, Participants participants) {
        this.participants = participants;
        this.commandFactory = commandFactory;
    }
    @Override
    public void execute(String arg) throws IOException {
        if(participants.getLocation().getCheckMonster()) {
            Monsters monsters = participants.getLocation().getMonsters();
            CommandFactory.commandMap.put("attack", new AttackCommand(participants, monsters)); // create attack command whenInitiateBattleCommand are called
            Combat combat = new Combat(participants,monsters,commandFactory);
            combat.battle();
        }
        else {
            System.out.println("No monsters appear in this room");
        }
    }

    @Override
    public String getDescription() {
        return "Initiate the battle with this command";
    }
}
