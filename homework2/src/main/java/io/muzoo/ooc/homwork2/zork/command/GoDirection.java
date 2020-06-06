package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.MapCreation;
import io.muzoo.ooc.homwork2.zork.Participants;
import io.muzoo.ooc.homwork2.zork.SetRoom;

import java.util.Set;

public class GoDirection implements Command {

    private Participants participants;
    private SetRoom setRoom;
    private SetRoom currentRoom;

    public GoDirection(Participants participants, SetRoom currentRoom) {
        this.participants = participants;
        this.currentRoom = currentRoom;
    }

    @Override
    public void execute(String cmd2) {
        if(cmd2.equals("north")) {
            String nextRoom = currentRoom.getNeighbor(cmd2);
            participants.updateLocation(nextRoom);
        }


    }

    @Override
    public String getDescription() {
        return "Use this command to move around the game need to type -go- following with (north,west,east,south";
    }
}

