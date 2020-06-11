package io.muzoo.ooc.homwork2.zork;

import io.muzoo.ooc.homwork2.zork.Game;
import io.muzoo.ooc.homwork2.zork.command.Command;
import io.muzoo.ooc.homwork2.zork.command.CommandFactory;
import io.muzoo.ooc.homwork2.zork.command.LimitCommand;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        CommandFactory commandFactory = new CommandFactory();
        Game game = new Game(commandFactory);
        commandFactory.allCommand(game);
        game.play();
    }
}
