package io.muzoo.ooc.homwork2.zork;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SetRoom {    //set

    private final String description;
    private boolean blocked;


    public SetRoom(String description){
        this.description = description;
    }

    public String getDescription() { return description; }

    private HashMap <String,SetRoom> setDirectionMap = new HashMap<>(); {  //put the direction as a keys and neighbor room as a value

        setDirectionMap.put("south", null);
        setDirectionMap.put("north", null);
        setDirectionMap.put("east", null);
        setDirectionMap.put("west", null);

    }

    public void setWay(String direction, SetRoom neighbor ) {
        setDirectionMap.put(direction, neighbor);
    }

    public SetRoom getNeighbor(String neighbor) { return setDirectionMap.get(neighbor); }


    public static void main(String[] args) throws IOException {

    }
}
