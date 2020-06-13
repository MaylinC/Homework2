package io.muzoo.ooc.homwork2.zork;

import io.muzoo.ooc.homwork2.zork.command.*;
import io.muzoo.ooc.homwork2.zork.creatures.Monsters;

import java.io.IOException;

public class Combat {

    private Participants player;
    private Monsters monster;
    private Parser parser;
    private CommandFactory commandFactory;
    private GetCommand command;
    private LimitCommand limitCommand;
    private Boolean leave = false;

    public Combat(Participants player, Monsters monster, CommandFactory commandFactory, LimitCommand limitCommand) {
        this.player = player;
        this.monster = monster;
        this.commandFactory = commandFactory;
        this.limitCommand = limitCommand;
        parser = new Parser();
        command = new GetCommand();
    }

    public void setLeave() {
        this.leave = true;
    }

    public void battle() throws IOException {
        System.out.println(monster.getName() + "has appeared!!!!");
        System.out.println("Your HP: " + player.getHp());
        System.out.println(monster.getName() + "'s HP: " + monster.getHp());
        System.out.println("In the battle Zone, Take care!!");

        while (monster.getHp() > 0 && player.getHp() > 0) {

            System.out.println("What would you want to do?");
            System.out.println("> attack");
            System.out.println("> take");
            System.out.println("> leave");
            System.out.println("> eat");

            command.getCommand(parser, commandFactory, limitCommand.getCanBeUsedCommand(), "Attack");

            if(leave) {
                System.out.println("You are leaving the battle");
                break;
            }

            if (monster.getName().equals("Cannibal Tribe")) {
                Integer damageTaken = monster.strike();
                System.out.println("damageTaken" + damageTaken);
                Integer currentHp = player.getHp() - damageTaken;
                currentHp += 2;
                player.updateHP(currentHp);
                System.out.println("Your current HP: " + currentHp);


            } else {
                Integer damageTaken = monster.strike();
                double defencePercent = Math.toIntExact(Math.round(1 - (double) player.getDefence() / 100)); // so attack will hit 70% if defence is 30%
                Integer currentHp = (player.getHp() - (damageTaken * (int) defencePercent));
                currentHp += 2;
                player.updateHP(currentHp);
                System.out.println("Your current HP: " + currentHp);
            }
            if (monster.getHp() <= 0) {
                System.out.println("you defeated " + monster.getName());
            }
            if (player.getHp() <= 0) {
                System.out.println("you get defeated by " + monster.getName());
            }
        }
        System.out.println("Out of battle Zone");
    }
}
