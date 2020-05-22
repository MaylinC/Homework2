package io.muzoo.ooc.homwork2.zork.item;

public class ResurrectionStone {

    private String name;
    private boolean foundStone;

    public ResurrectionStone() {
        foundStone = false;
        name = "Resurrection Stone";
    }

    public String getName(){
        return name;
    }

    public boolean getBooFound() {
        return foundStone;
    }
}
