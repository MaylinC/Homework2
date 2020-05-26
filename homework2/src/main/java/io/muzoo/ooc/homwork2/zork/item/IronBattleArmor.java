package io.muzoo.ooc.homwork2.zork.item;

public class IronBattleArmor extends DeathlyItem {

    public IronBattleArmor() {
        foundItem = false;
        this.gainDefence = 20;
        name = "IronBattle Armor";
    }

    public IronBattleArmor(boolean foundArmor) {
        this.foundItem = foundArmor;
    }

}