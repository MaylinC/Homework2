package io.muzoo.ooc.homwork2.zork.item;

public class ResurrectionStone extends DeathlyItem {

    public ResurrectionStone() {
        foundItem= false;
        gainHp = 250;
        name = "Resurrection Stone";
    }

    public ResurrectionStone(boolean foundStone) {
        this.foundItem = foundStone;
    }

}
