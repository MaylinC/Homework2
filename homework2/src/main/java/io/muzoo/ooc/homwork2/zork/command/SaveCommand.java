package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Game;
import io.muzoo.ooc.homwork2.zork.Json.JsonWriter;

import java.io.IOException;

public class SaveCommand implements Command {
    private Game game;

    SaveCommand(Game game) {
        this.game = game;
    }
    @Override
    public void execute(String arg) throws IOException {
        if(game.getMapExist()) {
            JsonWriter jsonWriter = new JsonWriter(game);
            jsonWriter.writer(arg);
        }
        else {
            System.out.println("This command can't be use");
        }
    }

    @Override
    public String getDescription() {
        return "Use this command to save game";
    }
}
