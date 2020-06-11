package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Game;

import java.io.IOException;

public class QuitCommand implements Command {

    private Game game;

    public QuitCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(String arg) {
        game.quiteGame();
        game.existGame();
        System.out.println("Thank you for playing");
    }

    @Override
    public String getDescription() {
        return "Use this command to exist game";
    }
}
