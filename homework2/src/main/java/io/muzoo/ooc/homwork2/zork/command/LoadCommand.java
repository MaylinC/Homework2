package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Game;
import io.muzoo.ooc.homwork2.zork.Json.JsonReader;

import java.io.IOException;

public class LoadCommand implements Command {
    Game game;

    public LoadCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(String arg) throws IOException {
        JsonReader jsonReader = new JsonReader(game);
        jsonReader.loader(arg);
        game.getCommandFactory().getCommandMap().put("take", new TakeCommand(game.getPlayer()));
        game.getCommandFactory().getCommandMap().put("eat", new EatCommand(game.getPlayer()));
        game.getCommandFactory().getCommandMap().put("drop", new DropCommand(game.getPlayer()));
        game.getCommandFactory().getCommandMap().put("initiateBattle", new InitiateBattleCommand(game.getCommandFactory(), game.getPlayer(), game.getLimitCommand()));
        game.getCommandFactory().getCommandMap().put("go", new GoDirection(game));
        game.getCommandFactory().getCommandMap().put("info", new InfoCommand(game.getPlayer()));
    }

    @Override
    public String getDescription() {
        return "use this command to load your save game";
    }
}
