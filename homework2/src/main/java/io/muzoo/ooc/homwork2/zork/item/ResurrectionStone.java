package io.muzoo.ooc.homwork2.zork.item;

public class ResurrectionStone {

    private boolean foundStone;
    private Integer gainHp;

    public ResurrectionStone() {
        foundStone = false;
        gainHp = 250;

    }
    public ResurrectionStone(boolean foundStone) {
        this.foundStone = foundStone;
    }

    public boolean getBooFound() {
        return foundStone;
    }

    public Integer getGainHp() {return gainHp;}

    public void setFoundStone() {
        this.foundStone = true;
    }
}
