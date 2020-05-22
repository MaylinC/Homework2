package io.muzoo.ooc.homwork2.zork;

import java.io.IOException;
import java.util.HashMap;

public class SetRoom {    //set

    private final String description;
    private boolean blocked;


    public SetRoom(String description){
        this.description = description;
    }

    public String getDescription() { return description; }

    private HashMap <String,String> setDirectionMap = new HashMap<>();

    public void setWay(String direction, String neighbor ) {

        setDirectionMap.put(direction, neighbor);
    }

    public String getNeighbor(String direction) { return setDirectionMap.get(direction); }

    public static void main(String[] args) throws IOException {

    }
}
