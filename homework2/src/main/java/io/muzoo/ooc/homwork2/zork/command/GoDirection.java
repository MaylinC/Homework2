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
        if (participants.getLocation().getNeighbor(cmd2) != null) {
            String nextRoom = participants.getLocation().getNeighbor(cmd2);
            participants.updateLocation(bigMap.get(nextRoom));
            System.out.println(nextRoom);
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

