package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Game;
import io.muzoo.ooc.homwork2.zork.Participants;
import io.muzoo.ooc.homwork2.zork.SetRoom;

import java.io.IOException;
import java.util.Map;

public class PlayCommand implements Command {
    private Game game;
    private SetRoom beginRoom;
    private CommandFactory commandFactory;

    PlayCommand(Game game, CommandFactory commandFactory) {
        this.game = game;
        this.commandFactory = commandFactory;
    }

    @Override
    public void execute(String arg) throws IOException {
        if (arg.equals("Map1")) {
            game.chooseMap(arg);
            beginRoom = game.getCurrentRoom();
            System.out.println("Map is build");
            Participants participants = new Participants();
            game.setPlayer(participants);
            System.out.println("Player is already created");
            participants.updateLocation(beginRoom);
            System.out.println("You are at " + beginRoom.getDescription());
            commandFactory.getCommandMap().put("take", new TakeCommand(participants));
            commandFactory.getCommandMap().put("drop", new DropCommand(participants));
            commandFactory.getCommandMap().put("initiateBattle", new InitiateBattleCommand(commandFactory, participants, game.getLimitCommand()));
            commandFactory.getCommandMap().put("go", new GoDirection(participants,game.getBigMap()));
            commandFactory.getCommandMap().put("info", new InfoCommand(participants));
        }
        else {
            System.out.println("Cannot find the map");
        }
    }

    @Override
    public String getDescription() {
        return "Start the game by using play command";
    }
}
