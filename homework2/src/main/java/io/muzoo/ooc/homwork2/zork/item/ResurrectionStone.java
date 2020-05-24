package io.muzoo.ooc.homwork2.zork.item;

public class ResurrectionStone extends DeathlyItem {

    public ResurrectionStone() {
        foundItem= false;
        gainHp = 250;
    }

    public ResurrectionStone(boolean foundStone) {
        this.foundItem = foundStone;
    }

}
