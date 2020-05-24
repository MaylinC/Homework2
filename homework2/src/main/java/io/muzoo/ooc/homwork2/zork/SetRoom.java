package io.muzoo.ooc.homwork2.zork;

import io.muzoo.ooc.homwork2.zork.creatures.Monsters;
import io.muzoo.ooc.homwork2.zork.item.ExcaliburSword;
import io.muzoo.ooc.homwork2.zork.item.IronBattleArmor;
import io.muzoo.ooc.homwork2.zork.item.ResurrectionStone;
import io.muzoo.ooc.homwork2.zork.item.WizardFuryTruffle;

import javax.jws.Oneway;
import java.io.IOException;
import java.util.HashMap;

public class SetRoom {    //set

    private final String description;
    private Boolean checkMonster;
    private Boolean checkItem;
    private Monsters monsters;
    private Object item; // take item with any types

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

    public void generateItem(Object item) {
        this.item = item;
        this.checkItem = true;
    }

    public void takeOutMonster() {
        checkMonster = false;
    }

    public void takeOutItem() {
        checkItem = false; }

    public Object getItem() {
        return item;
    }



}
