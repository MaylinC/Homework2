package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Game;
import io.muzoo.ooc.homwork2.zork.MapCreation;
import io.muzoo.ooc.homwork2.zork.Participants;
import io.muzoo.ooc.homwork2.zork.SetRoom;

import java.util.Map;
import java.util.Set;

public class GoDirection implements Command {

    private Participants participants;
    private Map<String, SetRoom> bigMap;

    public GoDirection(Participants participants, Map<String, SetRoom> bigMap) {
        this.participants = participants;
        this.bigMap = bigMap;
    }

    @Override
    public void execute(String cmd2) {
        if(cmd2.equals("north")) {
            String nextRoom = participants.getLocation().getNeighbor(cmd2);
            participants.updateLocation(bigMap.get(nextRoom));
            System.out.println("north" + nextRoom);
        }
        else if (cmd2.equals("west")) {
            String nextRoom = participants.getLocation().getNeighbor(cmd2);
            participants.updateLocation(bigMap.get(nextRoom));
            System.out.println("west" + nextRoom);
        }
        else if (cmd2.equals("east")) {
            String nextRoom = participants.getLocation().getNeighbor(cmd2);
            participants.updateLocation(bigMap.get(nextRoom));
            System.out.println("east" + nextRoom);
        }
        else {
            String nextRoom = participants.getLocation().getNeighbor(cmd2);
            participants.updateLocation(bigMap.get(nextRoom));
            System.out.println("south" + nextRoom);
        }
    }

    @Override
    public String getDescription() {
        return "Use this command to move around the game need to type -go- following with (north,west,east,south";
    }
}

