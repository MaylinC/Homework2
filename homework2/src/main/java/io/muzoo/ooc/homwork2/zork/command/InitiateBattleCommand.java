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
    public void execute(String arg) {
        if(participants.getLocation().getCheckMonster()) {
            Monsters monster = participants.getLocation().getMonsters();
            Combat combat = new Combat(participants,monster,commandFactory,limitCommand);
            commandFactory.getCommandMap().put("attack", new AttackCommand(participants, monster)); // create attack command whenInitiateBattleCommand are called
            commandFactory.getCommandMap().put("leave", new LeaveBattleCommand(combat));
            try {
                combat.battle();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
