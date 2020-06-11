package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Game;
import io.muzoo.ooc.homwork2.zork.item.ExcaliburSword;

public class ExitCommand implements Command {

    private Game game;

    public ExitCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(String arg) {
        game.existGame();
        System.out.println("You exit the map");
        System.out.println("Build a new map in order to continue playing");
    }

    @Override
    public String getDescription() {
        return "When you want to exist game, use this command";
    }

}
