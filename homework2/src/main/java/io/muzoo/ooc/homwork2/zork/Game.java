package io.muzoo.ooc.homwork2.zork;

import io.muzoo.ooc.homwork2.zork.command.Command;
import io.muzoo.ooc.homwork2.zork.command.CommandFactory;
import io.muzoo.ooc.homwork2.zork.command.GetCommand;
import io.muzoo.ooc.homwork2.zork.command.Parser;
import io.muzoo.ooc.homwork2.zork.creatures.Monsters;
import javafx.beans.binding.MapBinding;
import sun.awt.windows.ThemeReader;

import javax.swing.text.Element;

public class Game {

    private MapBinding mapBinding;
    private CommandFactory commandFactory;
    private Monsters monsters;
    private Boolean quit;
    private Boolean existGame;
    private Parser parser;
    private SetRoom setRoom;
    private GetCommand command;
    private Boolean bossDestroyed;
    private Participants player;

    public void Game(CommandFactory commandFactory) {
        parser = new Parser();
        this.commandFactory = commandFactory;
        this.quit = false;
        this.existGame = false;
        this.bossDestroyed = false;
        command = new GetCommand();
    }

    public void printWelcome() {
        System.out.println("Welcome to Zork, enjoy your game !!!");
    }

    public void currentLocationData() {

        System.out.println("You are in " + player.getLocation().getDescription());
        if (player.getLocation().getCheckMonster()) {
            System.out.println("There is a " + player.getLocation().getMonsters().getName() + "in this current room");
        }
        else {
            System.out.println("You are lucky! there's no Monster in this current room");
        }
        if (player.getLocation().getCheckItem()) {
            System.out.println(player.getLocation().getItem().getName() + "appear in this room");
        }
        else {
            System.out.println("Too bad there's not item in this room");
        }
    }

    public void play() {
        printWelcome();
        while(!existGame) {

            command.getCommand(parser,commandFactory);
            commandFactory.playCommand(player, monsters);

            if (quit) {

            }

        }
    }











}
