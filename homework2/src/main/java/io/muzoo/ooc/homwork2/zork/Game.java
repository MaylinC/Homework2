package io.muzoo.ooc.homwork2.zork;

import io.muzoo.ooc.homwork2.zork.command.Command;
import io.muzoo.ooc.homwork2.zork.command.CommandFactory;
import io.muzoo.ooc.homwork2.zork.command.GetCommand;
import io.muzoo.ooc.homwork2.zork.command.Parser;
import io.muzoo.ooc.homwork2.zork.creatures.Monsters;
import javafx.beans.binding.MapBinding;

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

    public void Game(CommandFactory commandFactory) {
        parser = new Parser();
        this.commandFactory = commandFactory;
        this.quit = true;
        this.existGame = true;
        this.bossDestroyed = false;
        command = new GetCommand();
    }

    public void printWelcome() {
        System.out.println("Welcome to Zork, enjoy your game !!!");
    }


    public void play() {
        printWelcome();
        while(!existGame) {

            command.getCommand(parser,commandFactory);
            commandFactory.playCommand();

            






        }
    }











}
