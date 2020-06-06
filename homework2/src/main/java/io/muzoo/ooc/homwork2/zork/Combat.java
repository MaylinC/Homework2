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

    public Combat(Participants player, Monsters monster, CommandFactory commandFactory) {
        this.player = player;
        this.monster = monster;
        this.commandFactory = commandFactory;
        parser = new Parser();
        command = new GetCommand();
    }

    public void battle() throws IOException {
        System.out.println(monster.getName() + "has appeared!!!!");
        System.out.println("Your HP: " + player.getHp());
        System.out.println(monster.getName() + "'s HP: " + monster.getHp());

        while (monster.getHp() > 0 && player.getHp() > 0) {

            System.out.println("What would you want to do?");
            System.out.println("> attack");
            System.out.println("> take");

            command.getCommand(parser, commandFactory);

            if (monster.getName().equals("Cannibal Tribe")) {
                Integer damageTaken = monster.strike();
                Integer currentHp = player.getHp() - damageTaken;
                System.out.println("Your current HP: " + currentHp);
                currentHp += 2;
                player.updateHP(currentHp);
            } else {
                Integer damageTaken = monster.strike();
                double defencePercent = (1 - (double) player.getDefence() / 100); // so attack will hit 70% if defence is 30%
                Integer currentHp = (player.getHp() - (damageTaken * (int) defencePercent));
                System.out.println("Your current HP: " + currentHp);
                currentHp += 2;
                player.updateHP(currentHp);
            }
        }
        if (monster.getHp() <= 0) {
            System.out.println("you defeated " + monster.getName());
        }
        if (player.getHp() <= 0) {
            System.out.println("you get defeated by " + monster.getName());
        }
    }
}