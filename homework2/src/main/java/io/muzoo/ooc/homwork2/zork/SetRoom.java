package io.muzoo.ooc.homwork2.zork;

import io.muzoo.ooc.homwork2.zork.creatures.Monsters;
import io.muzoo.ooc.homwork2.zork.item.*;

import javax.jws.Oneway;
import java.io.IOException;
import java.util.HashMap;

public class SetRoom {    //set

    private final String description;
    private Boolean checkMonster;
    private Boolean checkItem;
    private Monsters monsters;
    private DeathlyItem item; // take item with any types

    public SetRoom(String description){

        this.description = description;
        checkMonster = false;
        checkItem = false;
    }

    public String getDescription() { return description; }

    private HashMap <String,String> setDirectionMap = new HashMap<>();

    public void setWay(String direction, String neighbor ) {
        setDirectionMap.put(direction, neighbor);
    }

    public String getNeighbor(String direction) {
        return setDirectionMap.get(direction);
    }

    public void generateMonster(Monsters monsters) {
        this.monsters = monsters;
        checkMonster = true;
    }

    public void generateItem(DeathlyItem item) {
        this.item = item;
        this.checkItem = true;
    }

    public void takeOutMonster() {
        checkMonster = false;
    }

    public void takeOutItem() {
        this.checkItem = false; }

    public DeathlyItem getItem() {
        return item;
    }

    public Boolean getCheckItem() {
        return this.checkItem;
    }

    public Boolean setCheckItem() {
        return this.checkItem = true;
    }

    public Boolean getCheckMonster() {
        return this.checkMonster;
    }

    public Boolean setCheckMonster() {
        return this.checkMonster = true;
    }

    public Monsters getMonsters() {
        return monsters;
    }

}
