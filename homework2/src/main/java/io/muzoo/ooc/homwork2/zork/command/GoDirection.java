package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Game;
import io.muzoo.ooc.homwork2.zork.MapCreation;
import io.muzoo.ooc.homwork2.zork.Participants;
import io.muzoo.ooc.homwork2.zork.SetRoom;

import java.util.Map;
import java.util.Set;

public class GoDirection implements Command {

    private Game game;

    public GoDirection(Game game){
        this.game = game;
    }

    @Override
    public void execute(String cmd2) {
        if (game.getPlayer().getLocation().getNeighbor(cmd2) != null) {
            String nextRoom = game.getPlayer().getLocation().getNeighbor(cmd2);
            game.getPlayer().updateLocation(game.getBigMap().get(nextRoom));
            System.out.println(nextRoom);
            game.setCurrentRoom(nextRoom);
            }
        else {
            System.out.println("Invalid direction");
        }
    }

    @Override
    public String getDescription() {
        return "Use this command to move around the game need to type -go- following with (north,west,east,south";
    }
}

