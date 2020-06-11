package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Combat;
import io.muzoo.ooc.homwork2.zork.Participants;
import io.muzoo.ooc.homwork2.zork.creatures.Monsters;

import java.io.IOException;

public class InitiateBattleCommand implements Command {
    private CommandFactory commandFactory;
    private Participants participants;
    private LimitCommand limitCommand;

    public InitiateBattleCommand(CommandFactory commandFactory, Participants participants, LimitCommand limitCommand) {
        this.participants = participants;
        this.commandFactory = commandFactory;
        this.limitCommand = limitCommand;
    }
    @Override
    public void execute(String arg) throws IOException {
        if(participants.getLocation().getCheckMonster()) {
            Monsters monsters = participants.getLocation().getMonsters();
            commandFactory.getCommandMap().put("attack", new AttackCommand(participants, monsters)); // create attack command whenInitiateBattleCommand are called
            Combat combat = new Combat(participants,monsters,commandFactory,limitCommand);
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
