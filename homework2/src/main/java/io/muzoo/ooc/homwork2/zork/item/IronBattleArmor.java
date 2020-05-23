package io.muzoo.ooc.homwork2.zork.item;

public class IronBattleArmor {

    private boolean foundArmor;
    private Integer gainDefence;

    public IronBattleArmor() {
        this.foundArmor = false;
        this.gainDefence = 20;
    }

    public IronBattleArmor(boolean foundArmor) {
        this.foundArmor = foundArmor;
    }

    public boolean getBooFound() {
        return foundArmor;
    }

    public Integer getGainDefence() {
        return gainDefence;
    }
}
